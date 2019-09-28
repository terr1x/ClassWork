package com.task;

public class Main {

    public static void main(String[] args) {
        Balance balance = new Balance();
        balance.addRight(10);
        balance.addLeft(5);
        balance.addLeft(5);
        System.out.println(balance.weigh() == BalanceState.IN_BALANCE); // true

        balance.addLeft(1);
        System.out.println(balance.weigh() == BalanceState.LEFT); // true

        balance.addRight(2);
        System.out.println(balance.weigh() == BalanceState.RIGHT); // true

        System.out.println(balance.weigh() instanceof Enum); // true
    }
}