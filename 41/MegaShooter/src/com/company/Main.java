package com.company;

import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {

    KillerMLG killerMLG;
    World world;
    ArrayList<Bullet> bullets;
    ArrayList<Bot> bots;

    public static void main(String[] args) {
        PApplet.main(Main.class);
    }

    public void settings() {
        size(1000, 700);
        smooth(0);
    }

    public void setup() {
        killerMLG = new KillerMLG(this);
        bullets = new ArrayList<>();
        world = new World(this, killerMLG);
        bots = new ArrayList<>();
    }

    public void draw() {
        background(192, 197, 206);
        world.draw();
        killerMLG.draw();
        killerMLG.update();
        bots.add(new Bot(400,200,this));
        bots.get(0).draw();
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).draw();
            bullets.get(i).move();
        }
    }


    public void keyPressed() {
        if (key == 'd') {
            killerMLG.x = killerMLG.x + 6;
            killerMLG.way = KillerMLG.right;
        }
        if (key == 'a') {
            killerMLG.x = killerMLG.x - 6;
            killerMLG.way = KillerMLG.left;
        }
        if (key == ' ') {
            killerMLG.jump();
        }
    }

    public void mousePressed() {
        bullets.add(killerMLG.createBullet());
    }
}
