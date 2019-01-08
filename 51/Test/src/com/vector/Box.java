package com.vector;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import processing.core.PApplet;
import shiffman.box2d.Box2DProcessing;

public class Box {
    int size = 20;
    float x;
    float y;

    Body body;

    PApplet parent;

    Box(float x, float y, PApplet p, Box2DProcessing box2D) {
        parent = p;
        this.x = x;
        this.y = y;

        BodyDef bd = new BodyDef();
        bd.position.set(box2D.coordPixelsToWorld(x,y));
        bd.type = BodyType.DYNAMIC;
        body = box2D.createBody(bd);
        //body.setLinearVelocity(new Vec2(0, 0));

        PolygonShape ps = new PolygonShape();
        float size = box2D.scalarPixelsToWorld(20);
        ps.setAsBox(size / 2, size / 2);

        FixtureDef fd = new FixtureDef();
        fd.shape = ps;
        fd.density = 7800;
        fd.restitution = 0.5f;
        body.createFixture(fd);
    }

    void draw() {
        parent.rect(x, y, size, size);
    }
}
