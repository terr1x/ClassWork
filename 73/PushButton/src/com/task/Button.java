package com.task;

public class Button {
    int clicks = 0;

    public void click(){
        clicks=clicks+1;
    }

    public int getClickCount(){
        return clicks;
    }

    public void reset(){
        clicks=0;
    }
}
