package startup;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        try {
            clearFile();
        }catch (IOException e){
            e.printStackTrace();
        }

        Programmer[] programmers = new Programmer[(int) (Math.random() * 5) + 6];

        Manager manager = new Manager(generateName(5, 10), programmers);

        for (int i = 0; i < programmers.length; i++) {
            programmers[i] = new Programmer(generateName(4, 8), generateLanguage());
        }
        writeIntoDoc(manager.toString());
        for (int i = 0; i < programmers.length; i++) {
            writeIntoDoc(programmers[i].toString());
        }

        int loc=manager.doWork();

        while(true){
            try {
                manager.sendToCources();
            } catch (StartupException e) {
                break;
            }
        }
        int work=manager.doWork();
        if(work-loc>0) {
            writeIntoDoc("Програмисты стали писать на "+(work-loc)+" больше кода");
        }else{
            writeIntoDoc("Програмисты стали писать на "+Math.abs(work-loc)+" меньше кода");
        }
        writeIntoDoc("Менеджер и его команда после обучения:");
        writeIntoDoc(manager.toString());
        for (int i = 0; i < programmers.length; i++) {
            writeIntoDoc(programmers[i].toString());
        }
    }

    private static String generateName(int minAmount, int maxAmount) {
        String name = "";
        Random rd = new Random();
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char upperLetter = abc.charAt(rd.nextInt(abc.length()));
        name += upperLetter;
        int amount = (int) (Math.random() * maxAmount - minAmount) + minAmount;
        for (int i = 0; i < amount; i++) {
            char lowerLetter = abc.toLowerCase().charAt(rd.nextInt(abc.length()));
            name += lowerLetter;
        }
        return name;
    }

    private static String generateLanguage() {
        int language = (int) (Math.random() * 2);
        if (language == 1) {
            return "C++";
        } else {
            return "C#";
        }
    }

    private static void writeIntoDoc(String text){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("resources/startup.info",true));
            writer.write(text+"\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void clearFile() throws IOException {
        File file= new File("resources/startup.info");
        if(file.delete()){
            file.createNewFile();
        }
    }
}
