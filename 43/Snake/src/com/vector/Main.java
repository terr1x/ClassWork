package com.vector;

import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {

    //переменные и классы

    static int time = 0;

    static String up = "up";
    static String down = "down";
    static String left = "left";
    static String right = "right";

    ArrayList<Block> blocks;
    Snake snake;
    ArrayList<Apple> apples;

    public static void main(String[] args) {
        PApplet.main(Main.class);
    }

    public void settings() {
        size(700, 700);

        blocks = new ArrayList<>();
        apples = new ArrayList<>();
        snake = new Snake(blocks, apples, this);

        blocks.add(new Block(0, 0, this));
        blocks.add(new Block(20, 0, this));
    }

    public void setup() {
        stroke(66, 22, 96);
    }

    public void draw() {
        time = time + 1;
        background(66, 22, 96);

        if (apples.size() < 4) {
            apples.add(new Apple((int) random(35) * 20, (int) random(35) * 20, this));
        }

        for (int i = 0; i < apples.size(); i++) {
            apples.get(i).draw();
        }

        snake.move();
        snake.eatingApples();

        for (int i = 0; i < blocks.size(); i++) {
            blocks.get(i).draw();
        }
    }

    public void keyPressed() {
        if (key == 'w') {
            snake.side = up;
        }

        if (key == 's') {
            snake.side = down;
        }

        if (key == 'a') {
            snake.side = left;
        }

        if (key == 'd') {
            snake.side = right;
        }
    }

}
