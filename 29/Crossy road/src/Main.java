import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {

    Car[] cars;

    Frog frog = new Frog(220);

    public static void main(String[] args) {
        PApplet.main(Main.class);
    }

    public void settings() {
        size(200, 250);
    }

    public void setup() {
        noStroke();
        rectMode(CENTER);
        imageMode(CENTER);
        cars = new Car[]{new Car(230, 180, "Инкасатарский корабль Александра Сергеевича.png", -2), new Car(200, 140, "Машина Серёги.png", -4), new Car(-140, 100, "Хрузовиr Володьки.png", 2), new Car(-20, 60, "Хрузовиr Володьки.png", 5)};
    }

    public void draw() {
        background(0xEAF09D);
        stroke(100);

        // автомобильные полосы
        for (int i = 40; i <= 200; i = i + 40) {
            drawLine(i, i);
        }

        // машины

        noStroke();
        drawCars();
        // лягушка
        frog.draw();
    }

    public void keyPressed() {
        if (key == 'r') {
            frog.y = 220;
            for (int i = 0; i < 4; i++) {
                cars[i].reset();
            }
        } else if (key == ' ') {
            frog.y = frog.y - 40;
        }
    }

    void drawLine(int y, int y2) {
        line(0, y, 200, y2);
    }

    void drawCars() {
        for (int i = 0; i < 4; i++) {
            cars[i].draw();
        }
    }


    class Car {
        PImage skin;
        int x;
        int y;
        int xReset;
        int speed;
        int speedReset;

        Car(int x, int y, String image, int speed) {
            this.x = x;
            this.y = y;
            this.xReset = x;
            this.speed = speed;
            this.speedReset = speed;

            skin = loadImage(image);
        }

        void draw() {
            pushMatrix();
            translate(x,y);
            scale(2);
            image(skin, 0, 0);
            x = x + speed;
            if (speed < 0) {
                if (x <= -30) {
                    x = 230;
                }
            } else {
                if (x >= 230) {
                    x = -30;
                }
            }
            popMatrix();
        }

        public void reset() {
            x = xReset;
            speed = speedReset;
        }
    }

    class Frog {
        int y;
        int index;

        Frog(int y) {
            this.y = y;
        }

        void draw() {
            fill(38, 226, 79);
            rect(100, y, 20, 20);

            index = 0;
            for (int i = 180; i >= 60; i = i - 40) {
                boolean collisionCar = y == i && abs(100 - cars[index].x) <= 40;
                index = index + 1;
                if (collisionCar) {
                    background(0x363030);
                    for (int j = 0; j < 4; j++) {
                        cars[j].speed = 0;
                    }

                    text("Тебя сбила машина и ты улетел", 5, 125);
                    text("в мусорный бак!!!", 7, 140);
                }
            }
        }
    }
}
