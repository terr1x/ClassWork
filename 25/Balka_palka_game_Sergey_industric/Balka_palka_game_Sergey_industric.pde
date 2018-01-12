int numBall = 5;

boolean isMouseClicked = false;


String START_SCREEN = "startScreen";
String GAME_SCREEN = "gameScreen";
String GAME_OVER = "gameOver";
String state=START_SCREEN;

int score=0;
int health=5;

int[] xesOfball = new int[numBall];
int[] speedsOfBalls = new int[numBall];
int[] ballSizes = new int[numBall];
int[] yOfBalls = new int[numBall];

color[]colorsOfBalls = new color[numBall];

void setup() {
  size(500, 500);
  noStroke();
  textSize(40);
  setupBalls();
}
void draw() {
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
  background(#5457A0);
  textAlign(LEFT, TOP);
  text("score " + score, 10, 0);
  textAlign(RIGHT, TOP);
  text("health "+health, width, 0);
  if (health<=0) {
    state=GAME_OVER;
  }
  for (int i = 0; i<numBall; i++) {
    fill(colorsOfBalls[i]);
    ellipse(xesOfball[i], yOfBalls[i], ballSizes[i], ballSizes[i]);

    yOfBalls[i] = yOfBalls[i]-speedsOfBalls[i];

    if (isMouseClicked==true && mouseX<=xesOfball[i] + ballSizes[i]/2 && mouseX>=xesOfball[i] - ballSizes[i]/2 && mouseY<=yOfBalls[i] + ballSizes[i]/2 && mouseY>=yOfBalls[i] - ballSizes[i]/2) {                                                                                             
      resetOfBall(i);
      score=score+1;
    }
    if (yOfBalls[i]<=-45) {
      resetOfBall(i);
      health=health-1;
    }
  }
}

void  showGameOver() {
  background(#5F5A5A);
  textSize(50);
  fill(#D82323);
  text("game over", 350, 100);
  textSize(30);
  fill(#FFE308);
  text("press 'r' to restart the game", 450, 200);
  fill(#17FF08);
  text("Score "+score, 250, 300);
  setupBalls();
}

void setupBalls() {
  for (int i = 0; i<numBall; i++) {
    resetOfBall(i);
  }
}

void resetOfBall(int ball) {
  xesOfball[ball] = int(random(95, 405));
  colorsOfBalls[ball] = color(random(255), random(255), random(255));
  ballSizes[ball] = int(random(40, 90));
  yOfBalls[ball] = height+45;
  speedsOfBalls[ball] = int(random(1, 5));
}

void  showStartScreen() {
  background(#17FF08);
  text("made with Sergey industris", 20, 50);
  text("кликни пробел", 100, 400);
}

void resetGame() {
  health=5;
  score=0;
}

void keyPressed() {
  if (state==GAME_OVER) {
    if (key=='r') {
      resetGame();
      state=GAME_SCREEN;
    }
  }
  if (state==START_SCREEN) {
    if (key==' ') {
      state=GAME_SCREEN;
    }
  }
}

void mousePressed() {
  isMouseClicked=true;
}