package com.vector;

import processing.core.PApplet;

public class Block {

    private PApplet parent;

    public int x;
    public int y;

    Block(int x, int y, PApplet parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    void draw() {
        parent.fill(255);
        parent.rect(x, y, 20, 20);
    }
}
