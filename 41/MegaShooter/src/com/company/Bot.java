package com.company;

import processing.core.PApplet;

public class Bot extends Character {

    int damage = 1;

    Bot(float x, float y, String[] appearance, PApplet p) {
        super(x, y, appearance, p);
    }

    void move() {
        if (way == left) {
            x = x - 7f;
        }
        if (way == right) {
            x = x + 7f;
        }
    }

    void invertWay() {
        if (way == right) {
            way = left;
        } else if (way == left) {
            way = right;
        }
    }

    void pushAway(String way) {
        if (way == left) {
            x = x - 4f;
        }
        if (way == right) {
            x = x + 4f;
        }
    }
}
