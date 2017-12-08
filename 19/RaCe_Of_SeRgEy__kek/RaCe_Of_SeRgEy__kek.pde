PImage car; //<>//
PImage zloCar;

int[] ys={-430, -100, -900};
int[] ysReset={-430, -100, -900};
int[] lines = {100, 300, 500, 700, 900};
int[] zloCars = {65, 200, 335};

int speedOfMyCar=7; //скорость моей машинки
int speedOfZloCar=9; //скорость злой машинки

int y=770;
int x=200;

final float scale = 0.098;
final float carSize = 2400 * scale;

String GAME = "game";
String GAME_OVER = "gameover";
String state = GAME;

boolean isTouched = false;

void setup() {
  size(400, 900, P2D);
  imageMode(CENTER);
  smooth(10);
  car = loadImage("mashinka.png");
  zloCar = loadImage("zlo-mashinka.png");
}

void draw() {
  if (state == GAME_OVER) {
    gameOver();
  } else if (state == GAME) {
    game();
  }
  isTouched = false;
}

void mousePressed() {
  isTouched = true;
}

void keyPressed() {
  if (key=='r') {
    restart();
  }
  if (key=='a') {
    moveLeft();
  }
  if (key=='d') {
    moveRight();
  }
}