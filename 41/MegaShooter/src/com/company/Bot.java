package com.company;

import processing.core.PApplet;
import processing.core.PImage;

public class Bot {
    int x;
    int y;

    static String right = "right";
    static String left = "left";
    String way = left;

    PImage bot;

    PApplet parent;

    Bot(int x,int y,PApplet p) {
        parent = p;
        bot = parent.loadImage("enemy.png");
        this.x=x;
        this.y=y;
    }

    void draw() {
        parent.imageMode(parent.CENTER);
        if (way == right) {
            parent.pushMatrix();
            parent.translate(x, y);
            parent.scale(2.5f, 2.5f);
            parent.image(bot, 0, 0);
            parent.popMatrix();
        } else {
            parent.pushMatrix();
            parent.translate(x, y);
            parent.scale(-2.5f, 2.5f);
            parent.image(bot, 0, 0);
            parent.popMatrix();
        }
    }
}
