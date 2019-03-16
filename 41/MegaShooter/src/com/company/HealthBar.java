package com.company;

import processing.core.PApplet;

public class HealthBar {

    private PApplet parent;

    HealthBar(PApplet parent) {
        this.parent = parent;
    }

    void draw(int health) {
        parent.fill(64, 66, 68);
        parent.rect(10, 10, 200, 30);
        parent.fill(216, 95, 30);
        parent.rect(10, 10, health * 2, 30);
        parent.textSize(22);
        parent.fill(255, 255, 255);
        parent.text(health, 89, 33);
    }
}
