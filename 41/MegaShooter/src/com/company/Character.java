package com.company;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

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

    PApplet parent;

    Animation animation;

    Character(float x, float y, String[] appearance, PApplet p) {
        parent = p;
        this.x = x;
        this.y = y;
        ArrayList<PImage> skins = new ArrayList<>();
        for (int i = 0; i < appearance.length; i++) {
            skins.add(parent.loadImage(appearance[i]));
        }
        this.width = 32 * 2.5f;
        this.height = 37 * 2.5f;

        animation = new Animation(skins);
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
        if (isWhite) {
            PImage whiteClone = animation.frame.copy();
            whiteClone.filter(parent.THRESHOLD, 0);
            parent.image(whiteClone, 0, 0);
        } else {
            parent.image(animation.frame, 0, 0);
        }
        parent.popMatrix();
        isWhite = false;

        animation.update();
    }

    void takeDamage(int damage) {
        health = health - damage;
    }

    void makeWhite() {
        if (!wasWhite) {
            isWhite = true;
            wasWhite = true;
        } else {
            isWhite = false;
            wasWhite = false;
        }
    }
}
