package com.company;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class World {
    ArrayList<Tile> grounds = new ArrayList<>();

    int[][] grid = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},

    };

    Tile[][] tileGrid = new Tile[11][16];
    PImage[] tiles = new PImage[3];

    PImage background;

    PApplet parent;

    KillerMLG killerMLG;

    ArrayList<Bullet> bullets;

    ArrayList<Bot> bots;

    ArrayList<Character> characters;

    World(PApplet p) {
        parent = p;
        this.killerMLG = new KillerMLG(50, 50, "soldier.png", parent);
        this.bullets = new ArrayList<>();
        this.bots = new ArrayList<>();
        this.characters = new ArrayList<>();
        characters.add(killerMLG);
        bots.add(new Bot(400, 200, "enemy.png", parent));
        characters.addAll(bots);
        background = parent.loadImage("background.png");
        tiles[0] = parent.loadImage("Прозрачный тайл.png");
        tiles[1] = parent.loadImage("ground.png");

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Tile tile = new Tile(j * Tile.size, i * Tile.size, tiles[grid[i][j]], parent);
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

        killerMLG.draw();

        for (Character character : characters) {
            character.update();
        }
        for (int i = 0; i < bots.size(); i++) {
            bots.get(i).draw();
            bots.get(i).move();
        }

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).draw();
            bullets.get(i).move();
        }
    }

    void applyCollision() {
        killBots();

        for (Character character : characters) {
            character.onGround = false;
        }
        for (Tile ground : grounds) {
            for (Character character : characters) {
                if (character.x + character.width / 2 > ground.x && character.x - character.width / 2 < ground.x + Tile.size && character.y + character.height / 2 > ground.y && character.y - character.height / 2 < ground.y + Tile.size) {
                    if (PApplet.abs(ground.x + Tile.size / 2 - character.x) > PApplet.abs(ground.y + Tile.size / 2 - character.y)) {
                        if (character.x < ground.x) {
                            character.x = ground.x - character.width / 2;
                        } else {
                            character.x = ground.x + Tile.size + character.width / 2;
                        }
                    } else {
                        if (character.y < ground.y) {
                            character.onGround = true;
                            character.y = ground.y - character.height / 2;
                            character.speed *= -.1f;
                        } else {
                            character.y = ground.y + Tile.size + character.height / 2;
                            character.speed = 0;
                        }
                    }
                }
            }
        }
    }

    void killBots() {
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < bots.size(); j++) {
                if (bots.get(j).x - bots.get(j).width / 2 < bullets.get(i).x + bullets.get(i).size / 2 && bots.get(j).x + bots.get(j).width / 2 > bullets.get(i).x - bullets.get(i).size / 2 && bots.get(j).y - bots.get(j).height / 2 < bullets.get(i).y + bullets.get(i).size / 2 && bots.get(j).y + bots.get(j).height / 2 > bullets.get(i).y - bullets.get(i).size / 2) {
                    bots.remove(0);
                }
            }
        }
    }
}
