package com.company;

import processing.core.PApplet;

public class Bot extends Character {

    int damage=1;

    Bot(float x, float y, String appearance, PApplet p) {
        super(x, y, appearance, p);
    }

    void move(){
        way=left;
        x=x-7f;
    }
}
