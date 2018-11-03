package com.company;

import processing.core.PImage;

import java.util.ArrayList;

public class Animation {
    ArrayList<PImage> frames;
    PImage frame;

    Animation(ArrayList<PImage> frames){
        this.frames=frames;
        frame=frames.get(0);
    }
}
