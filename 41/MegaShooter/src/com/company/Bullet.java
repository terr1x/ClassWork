package com.company;

import processing.core.PApplet;

public class Bullet {
    float x;
    float y;
    float size = 3;

    float ySpeed;

    String way;

    PApplet parent;

    Bullet(float x, float y, String way, PApplet p) {
        parent = p;
        this.x = x;
        this.y = y;
        this.way = way;
        ySpeed=parent.random(-1,1);
    }

    void draw() {
        parent.fill(0);
        parent.ellipse(x, y, size, size);
    }

    void move() {
        if (way == KillerMLG.right) {
            x = x + 20;
        } else {
            x = x - 20;
        }
        y=y+ySpeed;
    }
}

