package com.vector;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import shiffman.box2d.Box2DProcessing;

import java.util.ArrayList;

public class Explosion {
    int particles;
    private Box2DProcessing box2D;

    ArrayList<Body> bodies= new ArrayList<>();

    Explosion(int particles, Box2DProcessing box2D, Vec2 position) {
        this.particles = particles;
        this.box2D = box2D;

        for (int i = 0; i < particles; i++) {
            float angle = i * 2 * (float) Math.PI / particles;

            Vec2 direction = new Vec2((float) Math.cos(angle), (float) Math.sin(angle));

            BodyDef bd = new BodyDef();
            bd.linearVelocity = direction.mul(1000);
            bd.type = BodyType.DYNAMIC;
            bd.fixedRotation = true;
            bd.bullet = true;
            bd.linearDamping = 10;
            bd.gravityScale = 0;
            bd.position.set(position);

            Body body = box2D.createBody(bd);
            body.setUserData("particle");
            bodies.add(body);
            CircleShape shape = new CircleShape();
            shape.m_radius = 0.05f;

            FixtureDef fd = new FixtureDef();
            fd.shape = shape;
            fd.density = 1000000 / particles;
            fd.friction = 0;
            fd.restitution = 0.99f;
            fd.filter.groupIndex = -1;
            body.createFixture(fd);
        }
    }

    Boolean died(){
        if (bodies.get(0).getLinearVelocity().lengthSquared()<=50){
            for(int i=0;i<bodies.size();i++){
                box2D.destroyBody(bodies.get(i));
            }
            return true;
        }
        return false;
    }
}
