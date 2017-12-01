boolean isMouseClicked = false;
int m = 0;

String GAME_SCREEN = "gameScreen";
String GAME_DELAY = "gameDelay";
String GAME_OVER = "gameOver";
String state = GAME_SCREEN;


void setup() {
  size(600, 600);
  textAlign(CENTER, CENTER);
  rectMode(CENTER);
  noStroke();
  fill(255);
}

void draw() {
  if (state == GAME_OVER) {
    showGameOver();
  } else if (state == GAME_SCREEN) {
    showGameScren();
  } else if (state == GAME_DELAY) {
    showGameDelay();
  }
  isMouseClicked = false;
}

void showGameScren() {
  textSize(40);
  background(#6633cc);
  text("Кликни по экрану", width / 2, height /2);

  if (isMouseClicked) {
    state = GAME_DELAY;
    m = millis();
  }
}

void showGameDelay() {
  background(#FFFFFF);
  fill(#000000);
  text("You are stupid!", width / 2, height /2); //<>//
  if (millis()-m>=3000) { //<>//
    state = GAME_OVER;
  }
}

void showGameOver() {
  textSize(40);
  background(#222222);
  text("Game over!", width / 2, height /2);

  int btnX = width / 2;
  int btnY = height / 2 + 65;
  int btnW = 180;
  int btnH = 50;
  textSize(30);
  fill(100);
  rect(btnX, btnY + 5, btnW, btnH);
  fill(255);
  text("Restart", btnX, btnY);

  boolean inRect = mouseX>btnX-btnW/2 && mouseX<btnX+btnW/2 && mouseY>btnY-btnH/2 && mouseY<btnY+btnH/2;
  if (inRect && isMouseClicked) {
    background(#92936E);
    state = GAME_SCREEN;
  }
}

void mouseClicked() {
  isMouseClicked = true;
}