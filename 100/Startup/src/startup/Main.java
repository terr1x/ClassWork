package startup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Programmer[] programmers = new Programmer[(int) (Math.random() * 5) + 6];
        for (int i = 0; i < programmers.length; i++) {
            programmers[i] = new Programmer(generateName(4, 8), generateLanguage());
        }
        Manager manager = new Manager(generateName(5, 10), programmers);


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("resources/startup.info"));
            writer.write(manager.toString() + "\n");
            for (int i = 0; i < programmers.length; i++) {
                writer.write(programmers[i].toString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int loc=manager.doWork();

        while(true){
            try {
                manager.sendToCources();
            } catch (StartupException e) {
                break;
            }
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
}
