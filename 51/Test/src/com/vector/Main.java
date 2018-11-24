package com.vector;

import org.jbox2d.callbacks.DebugDraw;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import processing.core.PApplet;

import shiffman.box2d.Box2DProcessing;

public class Main extends PApplet {

    Box2DProcessing box2D;

    public static void main(String[] args) {
        PApplet.main(Main.class);
    }

    public void settings() {
        size(600, 600);

    }

    public void setup() {
        box2D = new Box2DProcessing(this);
        box2D.createWorld();

        BodyDef bd = new BodyDef();
        bd.position.set(0, 0);
        bd.type = BodyType.DYNAMIC;
        Body body = box2D.createBody(bd);
        body.setLinearVelocity(new Vec2(0, 19));

        PolygonShape ps = new PolygonShape();
        float size = box2D.scalarPixelsToWorld(50);
        ps.setAsBox(size / 2, size / 2);

        FixtureDef fd = new FixtureDef();
        fd.shape = ps;
        fd.density = 7800;
        fd.restitution = 0.5f;
        body.createFixture(fd);

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
    }
}
