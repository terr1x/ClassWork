package com.company;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class World {
    ArrayList<Tile> grounds = new ArrayList<>();

    int[][] grid = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    Tile[][] tileGrid = new Tile[11][16];
    PImage[] tiles = new PImage[3];

    PImage background;

    PApplet parent;

    KillerMLG killerMLG;

    World(PApplet p, KillerMLG killerMLG) {
        parent = p;
        this.killerMLG = killerMLG;
        background = parent.loadImage("background.png");
        tiles[0] = parent.loadImage("Прозрачный тайл.png");
        tiles[1] = parent.loadImage("ground.png");

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Tile tile = new Tile(j * 64, i * 64, tiles[grid[i][j]], parent);
                tileGrid[i][j] = tile;
                if (grid[i][j] == 1) {
                    grounds.add(tile);
                }
            }
        }
    }

    void draw() {
        parent.imageMode(parent.CORNERS);
        parent.image(background, 0, 0);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                tileGrid[i][j].draw();
            }
        }
        applyCollision();
    }

    void applyCollision() {
        killerMLG.onGround = false;
        for (int i = 0; i < grounds.size(); i++) {
            Tile tile = grounds.get(i);
            if (killerMLG.x + killerMLG.width / 2 > tile.x && killerMLG.x - killerMLG.width / 2 < tile.x + tile.size && killerMLG.y + killerMLG.height / 2 > tile.y && killerMLG.y - killerMLG.height / 2 < tile.y + tile.size) {
                if (killerMLG.y < tile.y) {
                    killerMLG.onGround = true;
                    killerMLG.y=tile.y-killerMLG.height/2;
                    killerMLG.speed *= -.1f;
                }
                else if (killerMLG.y > tile.y + tile.size) {
                    killerMLG.y=tile.y+tile.size+killerMLG.height/2;
                    killerMLG.speed=0;
                }
                else if (killerMLG.x < tile.x) {
                    killerMLG.x=tile.x-killerMLG.width/2;
                    killerMLG.speed=0;
                }
                else if (killerMLG.x > tile.x) {
                    killerMLG.x=tile.x+tile.size+killerMLG.width/2;
                    killerMLG.speed=0;
                }
            }
        }
    }
}
