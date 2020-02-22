package startup;

import java.util.Random;

public class Programmer extends Employee {
    private String language;

    Programmer(String name,String language) {
        super(name);
        this.language=language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String newLanguage) throws StartupException {
        if (language.equals(newLanguage)) {
            throw new StartupException();
        }
        language = newLanguage;
    }

    @Override
    public int doWork() {
        int loc= ((int) (Math.random() * 900) +100)*getLanguage().length();
        System.out.println("Has finished writing "+loc+" lines of code in "+getLanguage());
        return loc;
    }

    @Override
    public String toString(){
        return "I'm programmer.Name: "+getName()+".Code in "+getLanguage();
    }
}
