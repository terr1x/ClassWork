import processing.core.PApplet;

import java.util.ArrayList;

public class Program extends PApplet {

    Killer killer = new Killer();
    Bullet bullets = new Bullet();
    ArrayList<Square> squares;
    ArrayList<Debris> debris;

    Boolean move = false;

    String game = "GAME";
    String gameOver = "GAME_OVER";
    String state = game;

    int health = 1;
    int time = 0;

    public static void main(String[] args) {
        PApplet.main(Program.class);
    }

    public void settings() {
        size(700, 400);
    }

    public void setup() {
        noStroke();
        rectMode(CENTER);
        squares = new ArrayList<Square>();
        debris = new ArrayList<Debris>();
    }

    public void draw() {
        if (state == "GAME") {
            game();
        }
        if (state == "GAME_OVER") {
            gameOver();
        }
    }

    void game() {
        time = time + 1;

        background(127, 226, 118);
        killer.draw();
        killer.y = mouseY;

        if (time >= 100) {
            squares.add(new Square());
            time = 0;
        }

        for (int i = 0; i < squares.size(); i++) {
            squares.get(i).draw();
            squares.get(i).move();

            if (squares.get(i).collision()) {
                debris.add(new Debris(squares.get(i).x,squares.get(i).y));
                squares.remove(i);

            }

            if (squares.get(i).x < 0) {
                health = health - 1;
            }
        }



        for (int i = 0; i < debris.size(); i++) {
            debris.get(i).draw();
            debris.get(i).move();
            if(debris.get(i).time>70){
                debris.remove(i);
            }
        }


        if (health == 0) {
            print("game over");
            state = gameOver;
        }


        if (move == true) {
            bullets.draw();
            bullets.x = bullets.x + 3;
        }

        if (bullets.x > width) {
            move = false;
            bullets.reset();
        }
    }


    void gameOver() {
        background(0);
        fill(153, 161, 175);
        textSize(50);
        text("game over", width / 3, 100);
        textSize(35);
        text("press 'r' to restart", width / 3, 300);
    }

    void restart() {
        health = 1;
        bullets.reset();
        while (squares.size() >= 1) {
            squares.remove(0);
        }
        state = game;
    }

    public void keyPressed() {
        if (key == 'w') {
            bullets.y = killer.y;
            bullets.reset();
            move = true;

        }
        if (key == 'r') {
            restart();
        }
    }


    public class Killer {
        int y;
        int size = 26;

        void draw() {
            fill(255);
            rect(13, y, 26, 26);
        }
    }

    public class Bullet {
        int x = 10;
        int y;
        int size = 26;

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
        int size = 26;

        Square() {
            this.x = (int) random(width, width + 200);
            this.y = (int) random(height);
        }

        void draw() {
            rect(x, y, size, size);
        }

        boolean collision() {
            boolean check = bullets.x + bullets.size / 2 > x - size / 2 && bullets.x - bullets.size / 2 < x + size / 2 && bullets.y + bullets.size / 2 > y - size / 2 && bullets.y - bullets.size / 2 < y + size / 2;
            return check;
        }

        void move() {
            x = x - 2;
        }
    }

    public class Explosion {

    }

    public class Debris {
        int x;
        int y;
        int time = 0;

        Debris(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void draw() {
            time=time+1;
            fill(255,150);
            rect(x, y, 26, 26);
        }

        void move() {
            y = y + 2;
        }
    }
}
