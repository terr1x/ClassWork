package com.vector;

import org.jbox2d.callbacks.DebugDraw;
import org.jbox2d.common.Color3f;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.jbox2d.particle.ParticleColor;
import processing.core.PConstants;
import processing.core.PGraphics;
import shiffman.box2d.Box2DProcessing;

/**
 * Created by doekewartena on 6/30/15.
 */
public class Box2dDebugDraw extends DebugDraw {

    Box2DProcessing box2d;
    PGraphics g;

    public void drawPoint(Vec2 center, float radius, Color3f c) {
        drawCircle(center, radius, c);
    }

    public void drawSolidPolygon(Vec2[] vertices, int vertexCount, Color3f c) {
        g.noStroke();
        g.fill(c.x, c.y, c.z);

        g.beginShape();
        for (int i = 0; i < vertexCount; i++) {
            Vec2 pixelVec = box2d.coordWorldToPixels(vertices[i]);
            g.vertex(pixelVec.x, pixelVec.y);
        }
        g.endShape();
    }

    public void drawCircle(Vec2 center, float radius, Color3f c) {
        center = box2d.coordWorldToPixels(center);
        radius = box2d.scalarWorldToPixels(radius);

        g.ellipseMode(PConstants.CENTER);
        g.stroke(c.x, c.y, c.z);
        g.noFill();
        g.ellipse(center.x, center.y, radius * 2, radius * 2);
    }

    public void drawSolidCircle(Vec2 center, float radius, Vec2 axis, Color3f c) {

        center = box2d.coordWorldToPixels(center);
        radius = box2d.scalarWorldToPixels(radius);

        g.ellipseMode(PConstants.CENTER);
        g.fill(c.x, c.y, c.z);
        g.noStroke();
        g.ellipse(center.x, center.y, radius * 2, radius * 2);
    }

    public void drawSegment(Vec2 p1, Vec2 p2, Color3f c) {
        Vec2 v1 = box2d.coordWorldToPixels(p1);
        Vec2 v2 = box2d.coordWorldToPixels(p2);
        g.stroke(c.x, c.y, c.z);
        g.line(v1.x, v1.y, v2.x, v2.y);
    }

    public void drawTransform(Transform xf) {
        float k_axisScale = 0.4f;
        Vec2 p1 = xf.p;
        Vec2 p2 = new Vec2();
        p2.setZero();
        p2.x = p1.x + k_axisScale * xf.q.c;
        p2.y = p1.y + k_axisScale * xf.q.s;
        Vec2 v1 = box2d.coordWorldToPixels(p1);
        Vec2 v2 = box2d.coordWorldToPixels(p2);
        g.stroke(1, 0, 0);
        g.line(v1.x, v1.y, v2.x, v2.y);

        g.stroke(0, 1, 0);
        p2.x = xf.p.x + -k_axisScale * xf.q.s;
        p2.y = xf.p.y + k_axisScale * xf.q.c;
        v2 = box2d.coordWorldToPixels(p2);
        g.line(v1.x, v1.y, v2.x, v2.y);
    }

    public void drawString(float x, float y, String s, Color3f color_) {
        Vec2 v1 = box2d.coordWorldToPixels(x, y);
        g.fill(color_.x, color_.y, color_.z);
        g.text(s, v1.x, v1.y);
    }

    public void drawParticles(Vec2[] centers, float radius, ParticleColor[] colors, int count) {
        System.out.println("drawParticles");
    }

    public void drawParticlesWireframe(Vec2[] centers, float radius, ParticleColor[] colors, int count) {
        System.out.println("drawParticlesWireframe");
    }
}