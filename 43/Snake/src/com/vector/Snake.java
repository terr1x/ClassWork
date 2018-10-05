package com.vector;

import processing.core.PApplet;

import java.util.ArrayList;

import static com.vector.Main.*;

public class Snake {
    ArrayList<Block> blocks;

    ArrayList<Apple> apples;

    String side;

    private PApplet parent;

    Snake(ArrayList<Block> blocks, ArrayList<Apple> apples, PApplet parent) {
        this.blocks = blocks;
        this.apples = apples;
        this.parent = parent;
    }

    void moveUp() {
        if (time >= 15) {
            blocks.remove(0);
            blocks.add(new Block(blocks.get(blocks.size() - 1).x, blocks.get(blocks.size() - 1).y - 20, parent));
            time = 0;
        }
    }

    void moveDown() {
        if (time >= 15) {
            blocks.remove(0);
            blocks.add(new Block(blocks.get(blocks.size() - 1).x, blocks.get(blocks.size() - 1).y + 20, parent));
            time = 0;
        }
    }

    void moveRight() {
        if (time >= 15) {
            blocks.remove(0);
            blocks.add(new Block(blocks.get(blocks.size() - 1).x + 20, blocks.get(blocks.size() - 1).y, parent));
            time = 0;
        }
    }

    void moveLeft() {
        if (time >= 15) {
            blocks.remove(0);
            blocks.add(new Block(blocks.get(blocks.size() - 1).x - 20, blocks.get(blocks.size() - 1).y, parent));
            time = 0;
        }
    }

    void move() {
        if (side == up) {
            moveUp();
        }
        if (side == down) {
            moveDown();
        }
        if (side == left) {
            moveLeft();
        }
        if (side == right) {
            moveRight();
        }
    }

    void eatingApples() {
        for (int i = 0; i < apples.size(); i++) {
            if (blocks.get(blocks.size() - 1).x == apples.get(i).x && blocks.get(blocks.size() - 1).y == apples.get(i).y) {
                apples.remove(i);

                if (side == up) {
                    blocks.add(new Block(blocks.get(blocks.size() - 1).x, blocks.get(blocks.size() - 1).y - 20, parent));
                }

                if (side == down) {
                    blocks.add(new Block(blocks.get(blocks.size() - 1).x, blocks.get(blocks.size() - 1).y + 20, parent));
                }

                if (side == right) {
                    blocks.add(new Block(blocks.get(blocks.size() - 1).x + 20, blocks.get(blocks.size() - 1).y, parent));
                }

                if (side == left) {
                    blocks.add(new Block(blocks.get(blocks.size() - 1).x - 20, blocks.get(blocks.size() - 1).y, parent));
                }
            }
        }
    }
}
