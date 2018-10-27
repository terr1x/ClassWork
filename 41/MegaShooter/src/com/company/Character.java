package com.company;

import processing.core.PApplet;
import processing.core.PImage;

public class Character {
    float x;
    float y;
    float speed = 0;
    float width;
    float height;

    int health = 200;


    boolean onGround = false;
    boolean isWhite = false;
    boolean wasWhite = false;

    static String right = "right";
    static String left = "left";
    String way = left;

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
        speed = speed + 0.3f;
    }

    void draw() {
        parent.imageMode(parent.CENTER);
        parent.pushMatrix();
        parent.translate(x, y);
        if (way == right) {
            parent.scale(2.5f, 2.5f);
        } else {
            parent.scale(-2.5f, 2.5f);
        }
        if (isWhite == true) {
            PImage whiteClone = skin.copy();
            whiteClone.filter(parent.THRESHOLD, 0);
            parent.image(whiteClone, 0, 0);
        } else {
            parent.image(skin, 0, 0);
        }
        parent.popMatrix();
        isWhite = false;
    }

    void takeDamage(int damage) {
        health = health - damage;
    }

    void makeWhite() {
        if (wasWhite == false) {
            isWhite = true;
            wasWhite = true;
        } else {
            isWhite = false;
            wasWhite = false;
        }
    }
}
