package startup;

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
        return 0;
    }
}
