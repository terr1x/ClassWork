package com.vector;

import processing.core.PApplet;

public class Apple {
    int x;
    int y;

    private PApplet parent;

    Apple(int x, int y, PApplet parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    void draw() {
        parent.fill(81, 224, 42);
        parent.rect(x, y, 20, 20);
    }
}
