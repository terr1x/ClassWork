public class Generics {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.put("cat");
        System.out.println(stringBox.get());

        Box<Integer> integerBox = new Box<>();
        integerBox.put(342);
        System.out.println(integerBox.get());
    }
}

class Box<T> {
    private T item;

    T get() {
        return item;
    }

    void put(T item) {
        this.item = item;
    }
}