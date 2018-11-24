package com.vector;

import org.jbox2d.dynamics.Body;
import processing.core.PApplet;

public class Box {
    int size = 20;
    int x;
    int y;

    Body body;

    PApplet parent;

    Box(int x, int y, PApplet p) {
        parent = p;
        this.x = x;
        this.y = y;
    }

    void draw() {
        parent.rect(x, y, size, size);
    }
}
