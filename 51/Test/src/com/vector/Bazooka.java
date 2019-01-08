package com.vector;

import processing.core.PApplet;
import shiffman.box2d.Box2DProcessing;

public class Bazooka {
    PApplet parent;

    Box2DProcessing box2D;

    Doll doll;

    float x;
    float y;

    float muzzleX;
    float muzzleY;

    int width;
    int height;

    Bazooka(PApplet p, Box2DProcessing box2D, Doll doll, int width, int height) {
        parent = p;

        this.box2D = box2D;

        this.doll = doll;

        this.width = width;
        this.height = height;
    }

    void draw() {
        x = box2D.coordWorldToPixelsPVector(doll.body.getPosition()).x;
        y = box2D.coordWorldToPixelsPVector(doll.body.getPosition()).y;
        double angle = Math.atan2(parent.mouseY - y, parent.mouseX - x);

        muzzleX = x + width * (float)Math.cos(angle);
        muzzleY = y + width * (float)Math.sin(angle);

        parent.pushMatrix();
        parent.translate(x, y);
        parent.rotate((float) angle);
        parent.rect(-width / 6, -height / 2, width, height);
        parent.popMatrix();
    }
}
