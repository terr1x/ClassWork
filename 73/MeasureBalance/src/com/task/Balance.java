package com.task;

public class Balance {
    private int rightBowl = 0;
    private int leftBowl = 0;

    public void addRight(int weight) {
        rightBowl = rightBowl + weight;
    }

    public void addLeft(int weight) {
        leftBowl = leftBowl + weight;
    }

    public BalanceState weigh() {
        if (rightBowl == leftBowl) {
            return BalanceState.IN_BALANCE;
        } else if (rightBowl > leftBowl) {
            return BalanceState.RIGHT;
        } else if (rightBowl < leftBowl) {
            return BalanceState.LEFT;
        }
        return null;
    }
}
