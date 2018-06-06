package com.company;

import processing.core.PApplet;
import processing.core.PImage;

public class KillerMLG {
    float x = 500;
    float y = 50;
    float speed = 0;
    float width;
    float height;

    boolean onGround = false;

    static String right = "right";
    static String left = "left";
    String way = right;

    PImage soldier;

    PApplet parent;

    KillerMLG(PApplet p) {
        parent = p;
        soldier = parent.loadImage("soldier.png");
        width = soldier.width * 2.5f;
        height = soldier.height * 2.5f;
    }

    void draw() {
        parent.imageMode(parent.CENTER);
        if (way == right) {
            parent.pushMatrix();
            parent.translate(x, y);
            parent.scale(2.5f, 2.5f);
            parent.image(soldier, 0, 0);
            parent.popMatrix();
        } else {
            parent.pushMatrix();
            parent.translate(x, y);
            parent.scale(-2.5f, 2.5f);
            parent.image(soldier, 0, 0);
            parent.popMatrix();
        }
    }

    void update() {
        y = y + speed;
        speed = speed + 0.1f;
    }

    void jump() {
        if (onGround == true) {
            speed = -6.4f;
        }
    }

    Bullet createBullet() {
        if (way == right) {
            return new Bullet(x+40, y - 24, way, parent);
        }else {
            return new Bullet(x-40, y - 24, way, parent);
        }
    }
}
