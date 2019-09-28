package com.task;

public class Bell {
    String sound = "ding";

    public void sound() {
        if (sound == "ding") {
            System.out.println(sound);
            sound = "dong";
        } else {
            System.out.println(sound);
            sound = "ding";
        }
    }
}
