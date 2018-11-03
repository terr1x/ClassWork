package com.company;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class World {
    ArrayList<Tile> grounds = new ArrayList<>();

    int[][] grid = {
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    Tile[][] tileGrid = new Tile[22][32];
    PImage[] tiles = new PImage[3];

    PImage background;

    PApplet parent;

    KillerMLG killerMLG;

    HealthBar healthBar;

    ArrayList<Bot> bots;

    ArrayList<Character> characters;


    int time = 0;

    World(PApplet p) {
        parent = p;
        parent.noStroke();
        this.killerMLG = new KillerMLG(500, 600, new String[]{"стояние.png","движение.png"}, parent);
        this.healthBar = new HealthBar(parent);
        this.bots = new ArrayList<>();
        this.characters = new ArrayList<>();
        characters.add(killerMLG);
        background = parent.loadImage("background.png");
        tiles[0] = parent.loadImage("Прозрачный тайл.png");
        tiles[1] = parent.loadImage("ground.png");
        tiles[1].resize(64, 64);

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
        time = time + 1;
        if (time >= 200) {
            Bot bot = new Bot(1000, 200, new String[]{"enemy.png"}, parent);
            bots.add(bot);
            characters.add(bot);
            time = 0;
        }

        parent.imageMode(parent.CORNERS);
        parent.image(background, 0, 0);

        parent.pushMatrix();
        parent.translate(-killerMLG.x + 500, 0);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                tileGrid[i][j].draw();
            }
        }

        applyCollision();

        killerMLG.draw();
        killerMLG.shoot();

        for (Character character : characters) {
            character.update();
        }
        for (int i = 0; i < bots.size(); i++) {
            bots.get(i).draw();
            bots.get(i).move();
        }

        for (int i = 0; i < killerMLG.bullets.size(); i++) {
            killerMLG.bullets.get(i).draw();
            killerMLG.bullets.get(i).move();
        }

        parent.popMatrix();

        healthBar.draw(killerMLG.health);
    }

    void applyCollision() {
        killBots();

        collideWithBots();

        for (Character character : characters) {
            character.onGround = false;
        }
        for (Tile ground : grounds) {
            for (Character character : characters) {
                if (character.x + character.width / 2 > ground.x && character.x - character.width / 2 < ground.x + Tile.size && character.y + character.height / 2 > ground.y && character.y - character.height / 2 < ground.y + Tile.size) {
                    if (PApplet.abs(ground.x + Tile.size / 2 - character.x) > PApplet.abs(ground.y + Tile.size / 2 - character.y)) {
                        if(character instanceof Bot){
                            ((Bot) character).invertWay();
                        }
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
        for (int i = 0; i < killerMLG.bullets.size(); i++) {
            Bullet bullet = killerMLG.bullets.get(i);
            for (int j = 0; j < bots.size(); j++) {
                Bot bot = bots.get(j);
                if (bot.x - bot.width / 2 < bullet.x + bullet.size / 2 && bot.x + bot.width / 2 > bullet.x - bullet.size / 2 && bot.y - bot.height / 2 < bullet.y + bullet.size / 2 && bot.y + bot.height / 2 > bullet.y - bullet.size / 2) {
                    bot.takeDamage(killerMLG.damage);
                    killerMLG.bullets.remove(i);
                    bot.pushAway(killerMLG.way);
                    bot.makeWhite();
                    if (bot.health <= 0) {
                        bots.remove(j);
                    }
                    i = i - 1;
                    break;
                }
            }
        }
    }

    void collideWithBots() {
        for (int i = 0; i < bots.size(); i++) {
            Bot bot = bots.get(i);
            if (bot.x > killerMLG.x - killerMLG.width / 2 && bot.x < killerMLG.x + killerMLG.width / 2 && bot.y > killerMLG.y - killerMLG.height / 2 && bot.y < killerMLG.y + killerMLG.height / 2) {
                killerMLG.takeDamage(bot.damage);
            }
        }
    }
}
