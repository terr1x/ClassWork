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
            world.killerMLG.x = world.killerMLG.x + 6;
            world.killerMLG.way = KillerMLG.right;
        }
        if (key == 'a') {
            world.killerMLG.x = world.killerMLG.x - 6;
            world.killerMLG.way = KillerMLG.left;
        }
        if (key == ' ') {
            world.killerMLG.jump();
        }
    }

    public void mousePressed() {
        world.bullets.add(world.killerMLG.createBullet());
    }
}
