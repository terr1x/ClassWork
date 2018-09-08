package com.company;

import processing.core.PApplet;

import java.util.ArrayList;

public class KillerMLG extends Character {

    boolean isShooting = false;


    ArrayList<Bullet> bullets;


    KillerMLG(float x, float y, String appearance, PApplet p) {
        super(x, y, appearance, p);
        this.bullets = new ArrayList<>();
    }

    void jump() {
        if (onGround == true) {
            speed = -11f;
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
        if (isShooting == true) {
            bullets.add(createBullet());
        }
    }
}
