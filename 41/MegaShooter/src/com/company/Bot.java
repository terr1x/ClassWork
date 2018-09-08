package com.company;

import processing.core.PApplet;

public class Bot extends Character {
    int health=10;

    Bot(float x, float y, String appearance, PApplet p) {
        super(x, y, appearance, p);
    }

    void move(){
        way=left;
        x=x-7f;
    }

    void takeDamage(){
        health=health-1;
    }
}
