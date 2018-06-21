package com.company;

import processing.core.PApplet;

public class Main extends PApplet {
    World world;

    public static void main(String[] args) {
        PApplet.main(Main.class);
    }

    public void settings() {
        size(1000, 700);
        smooth(0);
    }

    public void setup() {
        world = new World(this);
    }

    public void draw() {
        background(192, 197, 206);
        world.draw();
    }


    public void keyPressed() {
        if (key == 'd') {
            world.killerMLG.moveRight();
        }
        if (key == 'a') {
            world.killerMLG.moveLeft();
        }
        if (key == ' ') {
            world.killerMLG.jump();
        }
    }

    public void mousePressed() {
        world.bullets.add(world.killerMLG.createBullet());
    }
}
