package com.company;

import processing.core.PApplet;

import java.util.HashMap;

public class Main extends PApplet {
    World world;
    HashMap<java.lang.Character, Boolean> keys = new HashMap<>();

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
        handleKeys();
    }

    private void handleKeys() {
        if (isKeyPressed('d')) {
            world.killerMLG.moveRight();
        }
        if (isKeyPressed('a')) {
            world.killerMLG.moveLeft();
        }
        if (isKeyPressed(' ')) {
            world.killerMLG.jump();
        }
    }

    private boolean isKeyPressed(char key) {
        return keys.containsKey(key) && keys.get(key);
    }

    public void keyPressed() {
        keys.put(key, true);
    }

    public void keyReleased() {
        keys.put(key, false);
    }

    public void mousePressed() {
        world.bullets.add(world.killerMLG.createBullet());
    }
}
