package com.company;

import processing.core.PApplet;
import processing.core.PImage;

public class KillerMLG extends Character {

    KillerMLG(float x, float y, String appearance, PApplet p) {
        super(x, y, appearance, p);
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
