import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        OddEvenSeparator separator = new OddEvenSeparator();
        separator.addNumber(1);
        separator.addNumber(5);
        separator.addNumber(6);
        separator.addNumber(8);
        separator.addNumber(3);
        System.out.println(String.join(", ", Arrays.toString(separator.getEvens()))); // 6, 8
        System.out.println(String.join(", ", Arrays.toString(separator.getOdds()))); // 1, 5, 3
    }
}
