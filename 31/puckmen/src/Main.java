import processing.core.PApplet;

public class Main extends PApplet {

    int score = 0;

    String right = "right";
    String left = "left";
    String forward = "forward";
    String backward = "backward";

    String GAME = "game";
    String GAME_OVER = "gameOver";

    String screen = GAME;

    Puckman puckman = new Puckman(250, 250, 1, right);

    Fish fish = new Fish((int) random(10, width - 10), (int) random(10, width - 10));

    public static void main(String[] args) {
        PApplet.main(Main.class);
    }

    public void settings() {
        size(500, 500);
    }

    public void draw() {
        if (screen == GAME) {
            game();
        } else if (screen == GAME_OVER) {
            gameOver();
        }
    }

    void game() {
        background(50);

        fill(17, 143, 216);
        textSize(15);
        text("score " + score, 10, 12);

        puckman.draw();
        puckman.move();
        puckman.collision();

        fish.draw();

        if (keyPressed) {
            if (key == 'd') {
                puckman.side = right;
            }
            if (key == 'a') {
                puckman.side = left;
            }
            if (key == 'w') {
                puckman.side = forward;
            }
            if (key == 's') {
                puckman.side = backward;
            }
        }

        if (puckman.x < 0 || puckman.x > width || puckman.y < 0 || puckman.y > height) {
            screen = GAME_OVER;
        }
    }

    void gameOver() {
        background(0x3E3636);
        textSize(40);
        text("game over", width / 3, height / 3);
        textSize(20);
        text("press 'r' to restart", width / 3, height / 2);
        text("your score is " + score, width / 3, height - 100);

        if (keyPressed) {
            if (key == 'r') {
                restart();
            }
        }
    }

    void restart() {
        screen = GAME;
        puckman.reset();
    }

    public class Puckman {
        int x;
        int y;
        int resetX;
        int resetY;
        int size = 20;
        int speed;
        String side;

        Puckman(int x, int y, int speed, String side) {
            this.x = x;
            this.y = y;
            this.resetX = x;
            this.resetY = y;
            this.speed = speed;
            this.side = side;
        }

        void draw() {
            fill(69,200,252);
            ellipse(x, y, size, size);
        }

        void move() {
            if (side == right) {
                x = x + speed;
            }
            if (side == left) {
                x = x - speed;
            }
            if (side == forward) {
                y = y - speed;
            }
            if (side == backward) {
                y = y + speed;
            }
        }

        void collision() {
            if (fish.x > x - size / 2 && fish.x < x + size / 2 && fish.y > y - size / 2 && fish.y < y + size / 2) {
                fish.reset();
                score = score + 1;
            }
        }

        void reset() {
            x = resetX;
            y = resetY;
        }
    }

    public class Fish {
        int x;
        int y;
        int size = 10;

        Fish(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void draw() {
            fill(221,220,141);
            ellipse(x, y, size, size);
        }

        void reset() {
            fish.x = (int) random(10, width - 10);
            fish.y = (int) random(10, height - 10);
        }
    }
}


