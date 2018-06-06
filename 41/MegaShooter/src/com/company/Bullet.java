package com.company;

import processing.core.PApplet;

public class Bullet {
    float x;
    float y;

    String way;

    PApplet parent;

    Bullet(float x, float y, String way, PApplet p) {
        this.x = x;
        this.y = y;
        this.way = way;
        parent = p;
    }

    void draw() {
        parent.fill(0);
        parent.ellipse(x, y, 5, 5);
    }

    void move() {
        if (way == KillerMLG.right) {
            x = x + 10;
        } else {
            x = x - 10;
        }
    }
}

