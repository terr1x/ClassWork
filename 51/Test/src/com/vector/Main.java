package com.vector;

import org.jbox2d.callbacks.DebugDraw;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.contacts.Contact;
import processing.core.PApplet;

import shiffman.box2d.Box2DProcessing;

import java.util.ArrayList;

public class Main extends PApplet {

    Box2DProcessing box2D;

    ArrayList<Box> boxes = new ArrayList<>();

    Floor floor;

    Doll doll;

    Bazooka bazooka;

    Vec2 explosionPoint;

    Body bullet;

    ArrayList<Explosion> explosions = new ArrayList<>();

    int time;

    public static void main(String[] args) {
        PApplet.main(Main.class);
    }

    public void settings() {
        size(1920, 1000);
    }

    public void setup() {
        box2D = new Box2DProcessing(this);

        box2D.createWorld();
        box2D.listenForCollisions();

        floor = new Floor(width / 2, height - 100, 1920, 30, box2D);

        doll = new Doll(0, 0, this, box2D);

        bazooka = new Bazooka(this, box2D, doll, 100, 30);

        Box2dDebugDraw debugDraw = new Box2dDebugDraw();
        debugDraw.box2d = box2D;
        debugDraw.g = g;

        debugDraw.setFlags(
                DebugDraw.e_shapeBit + DebugDraw.e_jointBit
        );
        box2D.world.setDebugDraw(debugDraw);
    }

    public void draw() {
        time = time + 1;

        background(0);
        box2D.step();

        colorMode(RGB, 1, 1, 1);
        box2D.world.drawDebugData();

        if (mousePressed) {
            if (mouseButton == RIGHT) {
                boxes.add(new Box(mouseX, mouseY, this, box2D));
            }
            if (mouseButton == LEFT && time >= 5) {
                Box box = new Box(bazooka.muzzleX, bazooka.muzzleY, this, box2D);
                Vec2 direction = new Vec2(cos((float) -bazooka.angle), sin((float) -bazooka.angle)).mul(100);
                box.body.applyLinearImpulse(direction.add(doll.body.getLinearVelocity()), box.body.getWorldCenter(), true);
                box.body.setUserData("bullet");
                boxes.add(box);

                time = 0;
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

        if (explosionPoint != null) {
            bullet.getWorld().destroyBody(bullet);
            explosions.add(new Explosion(10, box2D, explosionPoint));
            explosionPoint = null;
        }

        for (int i = 0; i < explosions.size(); i++) {
            if (explosions.get(i).died()) {
                explosions.remove(i);
                i--;
            }
        }
    }

    public void beginContact(Contact cp) {
        Body a = cp.getFixtureA().getBody();
        Body b = cp.getFixtureB().getBody();
        if (a.getUserData() == "bullet" && b.getUserData() != "particle") {
            explosionPoint = a.getPosition();
            bullet = a;
        }
        if (b.getUserData() == "bullet" && a.getUserData() != "particle") {
            explosionPoint = b.getPosition();
            bullet = b;
        }
    }
}


