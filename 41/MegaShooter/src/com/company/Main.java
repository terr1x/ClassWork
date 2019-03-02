package com.company;

import processing.core.PApplet;

import java.io.IOException;
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
        try {
            world = new World(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw() {
        background(192, 197, 206);
        world.draw();
        handleKeys();
    }

    private void handleKeys() {
        world.killerMLG.isMoving=false;
        if (isKeyPressed('d')) {
            world.killerMLG.moveRight();
            world.killerMLG.isMoving=true;
        }
        if (isKeyPressed('a')) {
            world.killerMLG.moveLeft();
            world.killerMLG.isMoving=true;
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
        world.killerMLG.isShooting = true;
    }

    public void mouseReleased() {
        world.killerMLG.isShooting = false;
    }
}
