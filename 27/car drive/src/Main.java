import processing.core.PApplet;

public class Main extends PApplet {
    Car[] cars = new Car[5];

    public static void main(String[] args) {
        PApplet.main(Main.class);
    }

    public void settings() {
        size(200, 200);
    }

    public void setup() {
        for (int i = 0; i < cars.length; i++){
            cars[i] = new Car(0, random(0, 200), 100, 2);
        }

    }

    public void draw() {
        background(255);
        for (int i = 0; i < cars.length; i++) {
            cars[i].move();
            cars[i].display();
        }
    }

    class Car {
        int color;
        float x;
        float y;
        float speed;

        Car(int color, float x, float y, float speed){
            this.color = color;
            this.x = x;
            this.y = y;
            this.speed = speed;
        }

        void move() {
            x = x + speed;
            if (x > width) {
                x = 0;
            }
        }

        void display() {
            fill(color);
            rect(x, y, 30, 10);
        }
    }
}
