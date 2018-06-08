package com.company;

import processing.core.PApplet;
import processing.core.PImage;

public class Character {
    float x;
    float y;
    float speed = 0;
    float width;
    float height;

    boolean onGround = false;

    static String right = "right";
    static String left = "left";
    String way = right;

    PImage skin;

    PApplet parent;

    Character(float x, float y, String appearance, PApplet p) {
        parent = p;
        this.x = x;
        this.y = y;
        this.skin = parent.loadImage(appearance);
        this.width = skin.width * 2.5f;
        this.height = skin.height * 2.5f;
    }

    void update() {
        y = y + speed;
        speed = speed + 0.1f;
    }

    void draw() {
        parent.imageMode(parent.CENTER);
        if (way == right) {
            parent.pushMatrix();
            parent.translate(x, y);
            parent.scale(2.5f, 2.5f);
            parent.image(skin, 0, 0);
            parent.popMatrix();
        } else {
            parent.pushMatrix();
            parent.translate(x, y);
            parent.scale(-2.5f, 2.5f);
            parent.image(skin, 0, 0);
            parent.popMatrix();
        }
    }
}
