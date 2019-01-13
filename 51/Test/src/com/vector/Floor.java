package com.vector;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import shiffman.box2d.Box2DProcessing;

public class Floor {
    Body body;

    int x;
    int y;

    int width;
    int height;

    Floor(int x, int y, int width, int height, Box2DProcessing box2D) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        BodyDef bd = new BodyDef();
        bd.position.set(box2D.coordPixelsToWorld(x, y));
        bd.type = BodyType.STATIC;
        body = box2D.createBody(bd);
        body.setLinearVelocity(new Vec2(0, 0));

        PolygonShape ps = new PolygonShape();
        ps.setAsBox(box2D.scalarPixelsToWorld(width / 2), box2D.scalarPixelsToWorld(height / 2));

        FixtureDef fd = new FixtureDef();
        fd.shape = ps;
        fd.density = 7800;
        fd.restitution = 0;
        body.createFixture(fd);
    }
}
