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

    String GAME = "game";
    String GAME_OVER = "gameOver";

    String screen = GAME;

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

        if (screen == GAME) {
            game();
        } else if (screen == GAME_OVER) {
            gameOver();
        }
    }

    void game() {
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

        collision();
    }

    void gameOver() {
        background(50, 50, 50);
        textSize(40);
        text("GAME OVER | ◯ ‸ ◯ |", 190, 290);
        textSize(23);
        text("press 'r' to restart", 230, 350);
    }

    void collision() {
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).x < 0 || blocks.get(i).x > width - 20 || blocks.get(i).y < 0 || blocks.get(i).y > height - 20) {
                screen = GAME_OVER;
            }
        }
        for (int i = 0; i < blocks.size() - 1; i++) {
            if (blocks.get(blocks.size() - 1).x == blocks.get(i).x && blocks.get(blocks.size() - 1).y == blocks.get(i).y) {
                screen = GAME_OVER;
            }
        }
    }

    void restart() {
        blocks.clear();

        snake.reset();

        snake.side = right;
    }

    public void keyPressed() {
        if (key == 'w') {
            if (snake.side != down) {
                snake.side = up;
            }
        }

        if (key == 's') {
            if (snake.side != up) {
                snake.side = down;
            }
        }

        if (key == 'a') {
            if (snake.side != right) {
                snake.side = left;
            }
        }

        if (key == 'd') {
            if (snake.side != left) {
                snake.side = right;
            }
        }

        if (screen == GAME_OVER) {
            if (key == 'r') {
                restart();
                screen = GAME;
            }
        }
    }

}
