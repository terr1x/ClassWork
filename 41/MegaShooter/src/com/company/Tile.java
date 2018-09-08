package com.company;

import processing.core.PApplet;
import processing.core.PImage;

public class Tile {
    float x;
    float y;

    static int size = 64;

    PImage skin;

    PApplet parent;

    Tile(float x, float y, PImage skin, PApplet p) {
        parent = p;

        this.x = x;
        this.y = y;
        this.skin = skin;
    }

    void draw() {
        parent.image(skin, x, y);
    }
}
