import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Cat> cats = new HashMap<>();
        cats.put("Барсик", new Cat("Барсик", 3));
        cats.put("Рыжик", new Cat("Рыжик", 5));

        System.out.println("cats");
        for (Cat cat : cats.values()){
            System.out.println(cat.getAge());
            System.out.println(cat.getName());
        }

        System.out.println("cat names");
        for (String catName : cats.keySet()){
            System.out.println(catName);
        }

        System.out.println("entries");
        for (Map.Entry<String, Cat> entry : cats.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        System.out.println("using");
        System.out.println(cats.get("Рыжик").getAge());
        System.out.println(cats.get("r900"));

        cats.remove("Рыжик");
        //System.out.println(cats.get("Рыжик").getAge());
    }
}

class Cat {
    private final String name;
    private final int age;

    Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}