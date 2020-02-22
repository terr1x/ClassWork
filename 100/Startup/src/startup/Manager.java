package startup;

public class Manager extends Employee {
    Programmer[] team;

    Manager(String name, Programmer[] team) {
        super(name);
        this.team = team;
    }


    @Override
    public int doWork() {
        int sum = 0;
        for (int i = 0; i < team.length; i++) {
            sum += team[i].doWork();
        }
        System.out.println("My team has finished writing task with " + sum);
        return sum;
    }

    public void sendToCources() throws StartupException {
        int randomDude = (int) (Math.random() * team.length);
        team[randomDude].setLanguage("Kotlin");
    }

    @Override
    public String toString() {
        return "I'm manager.My Name: " + getName() + " and my team has " + team.length + " programmers";
    }
}
