void drawCar(int x, int y) {
  pushMatrix();
  translate(x, y);
  scale(scale);
  rotate(radians(-90));
  image(car, 0, 0);
  popMatrix();
}

void game() {

  background(#766050);
  drawLines();

  linesAreMoving(); 

  zloCar();

  drawCar(x, y);
  
  showGameOver();
}

void gameOver() {
  background(#C7C96C);
  fill(#030000);
  textSize(40);
  text("Lol GAMEOVER", 50, 450);
  speedOfMyCar=0;
  speedOfZloCar=0;

  if (isTouched) {
    restart();
  }
}

void restart() {
  x=200;
  for (int i=0; i<3; i++) {
    ys[i]=ysReset[i];
  }
  speedOfMyCar=7; 
  speedOfZloCar=9;
  state = GAME;
}

void checkDistance(int firstCar, int secondCar, int thirdCar) {
  int up;
  int down;
  if (ys[secondCar]<ys[thirdCar]) {
    up=ys[secondCar];
    down=ys[thirdCar];
  } else {
    up=ys[thirdCar];
    down=ys[secondCar];
  }

  if (ys[firstCar]>down+carSize*2.5) {
    return;
  }
  if (ys[firstCar]<up-carSize*2.5) {
    return;
  }

  ys[firstCar]=(int)(up-carSize*2.5);
}

void moveLeft() {
  x=x-135; 
  if (x<65) {
    x=65;
  }
}

void moveRight() {
  x=x+135;
  if (x>335) {
    x=335;
  }
}

void drawZloCar(int i) {
  pushMatrix();  //
  translate(zloCars[i], ys[i]);
  scale(scale);
  image(zloCar, 0, 0);
  popMatrix();
}

void zloCar() {
  for (int i=0; i<3; i++) {
    drawZloCar(i);

    regenerate(i);

    ys[i]=ys[i]+speedOfZloCar;
  }
}

void linesAreMoving() {
  for (int i=0; i<=4; i++) {
    noStroke();
    fill(#766050);
    rect(0, lines[i], 400, 100);
    if (lines[i]>=900) {
      lines[i]=-100;
    }
    lines[i]=lines[i]+speedOfMyCar;
  }
}

void drawLines() {
  for (int i=133; i<267; i=i+133) {  //
    stroke(0);
    strokeWeight(8);
    line(i, 0, i, 900);
  }
}

void showGameOver() {
  for (int i=0; i<3; i++) {  //
    if (abs(ys[i]-y)<=carSize && x==zloCars[i]) {
      state = GAME_OVER;
    }
  }
}

void moves() {

  if (isTouched) {  //
    if (mouseX<width/2) {
      moveLeft();
    } else {
      moveRight();
    }
  }
}

void regenerate(int car) {
  if (ys[car]>=1000) {  
    ys[car]=int(random(-1000, -150));
    if (car==0) {
      checkDistance(0, 1, 2);
    }
    if (car==1) {
      checkDistance(1, 0, 2);
    }
    if (car==2) {
      checkDistance(2, 0, 1);
    }
  }
}