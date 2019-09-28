package com.task;

public class Main {
    public static void main(String[] args) {
        assertEqual(getArmor(80), 1000);
        assertEqual(getArmor(70), 900);
        assertEqual(getArmor(60), 900);
        assertEqual(getArmor(50), 600);
        assertEqual(getArmor(30), 600);
        assertEqual(getArmor(20), 400);
        assertEqual(getArmor(10), 400);
        assertEqual(getArmor(5), 200);
        assertEqual(getArmor(2), 200);
    }

    /**
     * Считеат прочность брони в зависимости от уровня
     */

    private static int getArmor(int level) {
        int armor;
        if (level <= 5) {
            armor = 200;
        } else if (level <= 20) {
            armor = 400;
        } else if (level <= 50) {
            armor = 600;
        } else if (level <= 70) {
            armor = 900;
        } else {
            armor = 1000;
        }
        return armor;
    }

    private static void assertEqual(int actual, int expected) {
        if (actual != expected) {
            throw new AssertionError("expected: " + expected + ", but actual: " + actual);
        }
    }
}
