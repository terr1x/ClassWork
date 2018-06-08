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

        killerMLG.draw();
        for (Character character : characters) {
            character.update();
        }
        for (int i = 0; i < bots.size(); i++) {
            bots.get(i).draw();
        }

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).draw();
            bullets.get(i).move();
        }
    }

    void applyCollision() {
        killBots();

        for (int i = 0; i < characters.size(); i++) {
            characters.get(i).onGround = false;
        }
        for (int i = 0; i < grounds.size(); i++) {
            for (int j = 0; j < characters.size(); j++) {
                Tile tile = grounds.get(i);
                if (characters.get(j).x + characters.get(j).width / 2 > tile.x && characters.get(j).x - characters.get(j).width / 2 < tile.x + tile.size && characters.get(j).y + characters.get(j).height / 2 > tile.y && characters.get(j).y - characters.get(j).height / 2 < tile.y + tile.size) {
                    if (characters.get(j).y < tile.y) {
                        characters.get(j).onGround = true;
                        characters.get(j).y = tile.y - characters.get(j).height / 2;
                        characters.get(j).speed *= -.1f;
                    } else if (characters.get(j).y > tile.y + tile.size) {
                        characters.get(j).y = tile.y + tile.size + characters.get(j).height / 2;
                        characters.get(j).speed = 0;
                    } else if (characters.get(j).x < tile.x) {
                        characters.get(j).x = tile.x - characters.get(j).width / 2;
                        characters.get(j).speed = 0;
                    } else if (characters.get(j).x > tile.x) {
                        characters.get(j).x = tile.x + tile.size + characters.get(j).width / 2;
                        characters.get(j).speed = 0;
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
