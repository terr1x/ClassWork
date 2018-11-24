package com.company;

import processing.core.PImage;

import java.util.ArrayList;

public class Animation {
    int time=0;

    ArrayList<PImage> frames;
    PImage frame;

    int frameNumber = 0;

    boolean running=true;

    Animation(ArrayList<PImage> frames) {
        this.frames = frames;
        frame = frames.get(0);
    }

    void update() {
        if(running) {
            time = time + 1;
            if (time > 7.5f) {
                if (frameNumber < frames.size()) {
                    frame = frames.get(frameNumber);
                    frameNumber = frameNumber + 1;
                } else {
                    frameNumber = 0;
                }
                time = 0;
            }
        }
    }

    void stop(int frameNumber){
        running=false;
        this.frameNumber=frameNumber;
        frame=frames.get(frameNumber);
    }
}
