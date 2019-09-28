import java.util.ArrayList;

public class OddEvenSeparator {
    ArrayList<Integer>numbers=new ArrayList<Integer>();
    ArrayList<Integer> evens =new ArrayList<Integer>();
    ArrayList<Integer>odds=new ArrayList<Integer>();

    public void addNumber(int number) {
        numbers.add(number);
    }

    public Integer[] getEvens() {
        for(int i=0;i<numbers.size();i++) {
            if (numbers.get(i) % 2 == 0) {
                evens.add(numbers.get(i));
            }
        }
        return evens.toArray(new Integer[evens.size()]);
    }

    public  Integer[] getOdds() {
        for(int i=0;i<numbers.size();i++) {
            if (numbers.get(i) % 2 == 1) {
                odds.add(numbers.get(i));
            }
        }
        return odds.toArray(new Integer[odds.size()]);
    }
}
