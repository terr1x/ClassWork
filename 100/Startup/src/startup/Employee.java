package startup;

public abstract class Employee{
    private String name;

    Employee(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "Name: "+name;
    }

    public abstract int doWork();
}
