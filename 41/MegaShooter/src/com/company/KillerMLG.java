package com.company;

import processing.core.PApplet;

import java.util.ArrayList;

public class KillerMLG extends Character {

    boolean isShooting = false;
    boolean isMoving = false;

    int damage = 5;

    ArrayList<Bullet> bullets;

    KillerMLG(float x, float y, String[] appearance, PApplet p) {
        super(x, y, appearance, p);
        this.bullets = new ArrayList<>();
        health = 100;
    }

    void draw() {
        super.draw();
        if (!onGround) {
            animation.stop(1);
        } else if (isMoving) {
            animation.play();
        } else {
            animation.stop(0);
        }
    }

    void jump() {
        if (onGround) {
            speed = -11f;
            y--;
        }
    }

    void moveRight() {
        x = x + 6;
        way = right;
    }

    void moveLeft() {
        x = x - 6;
        way = left;
    }

    Bullet createBullet() {
        if (way == right) {
            return new Bullet(x + 40, y - 24, way, parent);
        } else {
            return new Bullet(x - 40, y - 24, way, parent);
        }
    }

    void shoot() {
        if (isShooting) {
            bullets.add(createBullet());
        }
    }
}
