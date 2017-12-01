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

String GAME = "game";
String GAME_OVER = "gameover";
String state = GAME;

boolean isMouseClicked = false;

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
}

void mousePressed() {
  isMouseClicked = true;
}

void mouseReleased() {
  isMouseClicked = false;
}

void keyPressed() {
  if (key=='r') {
    for (int i=0; i<3; i++) {
      ys[i]=ysReset[i];
    }
    speedOfMyCar=7; 
    speedOfZloCar=9;
    state = GAME;
  }
  if (key=='a') {
    moveLeft();
  }
  if (key=='d') {
    moveRight();
  }
}