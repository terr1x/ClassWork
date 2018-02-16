import processing.core.PApplet;

public class Main extends PApplet {

    Puckman puckman = new Puckman(250, 250);

    public static void main(String[] args) {
        PApplet.main(Main.class);
    }

    public void settings(){
        size(500,500);
    }

    public void draw() {
        background(123,82,45);
        puckman.draw();
        if (keyPressed) {
            if (key == 'w') {
            puckman.y=puckman.y-1;
            }

            if (key == 's') {
                puckman.y=puckman.y+1;
            }

            if (key == 'd') {
                puckman.x=puckman.x+1;
            }

            if (key == 'a') {
                puckman.x = puckman.x - +1;
            }

        }
    }

    public class Puckman {
        int x;
        int y;
        int size = 20;

        Puckman(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void draw() {
            ellipse(x, y, size, size);
        }

        void move() {

        }
    }
}


