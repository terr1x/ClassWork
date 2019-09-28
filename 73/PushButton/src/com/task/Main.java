package com.task;

public class Main {
    public static void main(String[] args) {
        Button button = new Button();
        button.click();
        button.click();
        System.out.println(button.getClickCount()); // 2

        button.click();
        System.out.println(button.getClickCount()); // 3

        button.reset();
        button.click();
        System.out.println(button.getClickCount()); // 1
    }
}