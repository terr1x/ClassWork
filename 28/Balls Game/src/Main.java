import processing.core.PApplet;

public class Main extends PApplet {
    int numBall = 5;

    boolean isMouseClicked = false;


    String START_SCREEN = "startScreen";
    String GAME_SCREEN = "gameScreen";
    String GAME_OVER = "gameOver";
    String state = START_SCREEN;

    int score = 0;
    int health = 5;

    Ball[] balls = new Ball[5];

    public static void main(String[] args) {
        PApplet.main(Main.class);
    }

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        noStroke();
        textSize(40);
        for (int i = 0; i < balls.length; i++) {
            balls[i] = new Ball();
        }
    }

    public void draw() {
        if (state == GAME_OVER) {
            showGameOver();
        } else if (state == START_SCREEN) {
            showStartScreen();
        } else if (state == GAME_SCREEN) {
            showGameScreen();
        }
        isMouseClicked = false;
    }

    void showGameScreen() {
        background(0x5457A0);
        textAlign(LEFT, TOP);
        text("score " + score, 10, 0);
        textAlign(RIGHT, TOP);
        text("health " + health, width, 0);
        if (health <= 0) {
            state = GAME_OVER;
        }
        for (int i = 0; i < numBall; i++) {
            fill(balls[i].color);
            ellipse(balls[i].x, balls[i].y, balls[i].size, balls[i].size);

            balls[i].y = balls[i].y - balls[i].speed;

            if (isMouseClicked == true && mouseX <= balls[i].x + balls[i].size / 2 && mouseX >= balls[i].x - balls[i].size / 2 && mouseY <= balls[i].y + balls[i].size / 2 && mouseY >= balls[i].y - balls[i].size / 2) {
                balls[i].reset();
                score = score + 1;
            }
            if (balls[i].y <= -45) {
                balls[i].reset();
                health = health - 1;
            }
        }
    }

    void showGameOver() {
        background(0x5F5A5A);
        textSize(50);
        fill(0xD82323);
        text("game over", 350, 100);
        textSize(30);
        fill(0xFFE308);
        text("press 'r' to restart the game", 450, 200);
        fill(0x17FF08);
        text("Score " + score, 250, 300);
        setupBalls();
    }

    void setupBalls() {
        for (int i = 0; i < numBall; i++) {
            balls[i].reset();
        }
    }

    void showStartScreen() {
        background(0x17FF08);
        text("made with Sergey industris", 20, 50);
        text("кликни пробел", 100, 400);
    }

    void resetGame() {
        health = 5;
        score = 0;
    }

    public void keyPressed() {
        if (state == GAME_OVER) {
            if (key == 'r') {
                resetGame();
                state = GAME_SCREEN;
            }
        }
        if (state == START_SCREEN) {
            if (key == ' ') {
                state = GAME_SCREEN;
            }
        }
    }

    public void mousePressed() {
        isMouseClicked = true;
    }

    class Ball {
        int x;
        int speed;
        int size;
        int y;
        int color;

        Ball() {
            reset();
        }

        void reset() {
            x = (int) (random(95, 405));
            color = color(random(255), random(255), random(255));
            size = (int) (random(40, 90));
            y = height + 45;
            speed = (int) (random(1, 5));
        }
    }
}
