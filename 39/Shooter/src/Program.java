import processing.core.PApplet;

public class Program extends PApplet {

    Killer killer = new Killer();
    Bullet bullet = new Bullet();
    Square square = new Square((int) random(width + 50, 200), (int) random(height));

    Boolean move = false;

    public static void main(String[] args) {
        PApplet.main(Program.class);
    }

    public void settings() {
        size(700, 400);
    }

    public void setup() {
        noStroke();
        rectMode(CENTER);
    }

    public void draw() {
        background(127, 226, 118);
        square.draw();
        killer.draw();
        killer.y = mouseY;

        square.x = square.x -2;

        if (move == true) {
            bullet.draw();
            bullet.x = bullet.x + 3;
        }

        if (bullet.x > width) {
            move = false;
            bullet.reset();
        }

    }

    public class Killer {
        int y;

        void draw() {
            fill(255);
            rect(13, y, 26, 26);
        }
    }

    public class Bullet {
        int x = 10;
        int y;

        void draw() {
            ellipse(x, y, 26, 26);
        }

        void reset() {
            x = 0;
        }
    }

    public class Square {
        int x;
        int y;

        Square(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void draw() {
            rect(x, y, 26, 26);
        }
    }

    public void keyPressed() {
        if (key == 'w') {
            bullet.y = killer.y;
            bullet.reset();
            move = true;
        }
    }
}
