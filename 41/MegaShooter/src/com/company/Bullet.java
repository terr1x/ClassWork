package com.company;

import processing.core.PApplet;

public class Bullet {
    float x;
    float y;
    float size = 5;

    String way;

    PApplet parent;

    Bullet(float x, float y, String way, PApplet p) {
        parent = p;
        this.x = x;
        this.y = y;
        this.way = way;
    }

    void draw() {
        parent.fill(0);
        parent.ellipse(x, y, size, size);
    }

    void move() {
        if (way == KillerMLG.right) {
            x = x + 10;
        } else {
            x = x - 10;
        }
    }
}

