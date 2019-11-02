import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    HashMap<String, Thing> things = new HashMap<>();

    public void add(Thing thing) {
        things.put(thing.getName(), thing);
    }

    public void remove(String thing) {
        things.remove(thing);
    }

    public boolean contains(String thing) {
        return things.containsKey(thing);
    }

    public int getCost() {
        int allCost = 0;
        for (int i = 0; i < things.size(); i++) {
            allCost = allCost + things.get(i).getPrice();
        }
        return allCost;
    }
}
