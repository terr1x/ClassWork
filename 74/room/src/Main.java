public class Main {
    public static void main(String[] args) {
        Room room = new Room();
        Thing table = new Thing("table", 500);
        room.add(table);
        Thing chair = new Thing("chair", 100);
        room.add(chair);

        assertEqual(room.contains(table.getName()), true);
        assertEqual(room.contains("cabinet"), false);
        assertEqual(room.getCost(), 600);

        Thing fridge = new Thing("fridge", 750);
        room.add(fridge);
        room.remove(chair.getName());

        assertEqual(room.contains(fridge.getName()), true);
        assertEqual(room.contains(chair.getName()), false);
        assertEqual(room.getCost(), 1250);
    }

    private static <T> void assertEqual(T actual, T expected) {
        if (!actual.equals(expected)) {
            throw new AssertionError("expected: " + expected + ", but actual: " + actual);
        }
    }
}