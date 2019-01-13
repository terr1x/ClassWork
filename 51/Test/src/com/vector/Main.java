package com.vector;

import org.jbox2d.callbacks.DebugDraw;

import org.jbox2d.common.Vec2;
import processing.core.PApplet;

import shiffman.box2d.Box2DProcessing;

import java.util.ArrayList;

public class Main extends PApplet {

    Box2DProcessing box2D;

    ArrayList<Box> boxes = new ArrayList<>();

    Floor floor;

    Doll doll;

    Bazooka bazooka;

    public static void main(String[] args) {
        PApplet.main(Main.class);
    }

    public void settings() {
        size(1900, 1000);
    }

    public void setup() {
        box2D = new Box2DProcessing(this);

        box2D.createWorld();

        floor = new Floor(width / 2, height - 100, 1920, 30, box2D);

        doll = new Doll(0, 0, this, box2D);

        bazooka = new Bazooka(this, box2D, doll, 100, 30);

        Box2dDebugDraw debugDraw = new Box2dDebugDraw();
        debugDraw.box2d = box2D;
        debugDraw.g = g;

        debugDraw.setFlags(
                DebugDraw.e_shapeBit + DebugDraw.e_jointBit + DebugDraw.e_centerOfMassBit
        );
        box2D.world.setDebugDraw(debugDraw);
    }

    public void draw() {
        background(0);
        box2D.step();

        colorMode(RGB, 1, 1, 1);
        box2D.world.drawDebugData();

        if (mousePressed) {
            if (mouseButton == RIGHT) {
                boxes.add(new Box(mouseX, mouseY, this, box2D));
            }

        }

        if (keyPressed) {
            if (key == 'w') {
                doll.body.setAwake(true);
                doll.body.m_linearVelocity.y = 200;
            }

            if (key == 's') {
                doll.body.setAwake(true);
                doll.body.m_linearVelocity.y = -200;
            }

            if (key == 'a') {
                doll.body.setAwake(true);
                doll.body.m_linearVelocity.x = -200;
            }

            if (key == 'd') {
                doll.body.setAwake(true);
                doll.body.m_linearVelocity.x = 200;
            }
        }

        bazooka.draw();
    }

    @Override
    public void mousePressed() {
        if (mouseButton == LEFT) {
            Box box = new Box(bazooka.muzzleX, bazooka.muzzleY, this, box2D);
            Vec2 direction = new Vec2(cos((float) -bazooka.angle), sin((float) -bazooka.angle)).mul(100);
            box.body.applyLinearImpulse(direction.add(doll.body.getLinearVelocity()), box.body.getWorldCenter(), true);
            boxes.add(box);
        }
    }
}


