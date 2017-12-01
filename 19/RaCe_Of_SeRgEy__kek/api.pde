void drawCar(int x, int y) {
  pushMatrix();
  translate(x, y);
  scale(0.098);
  rotate(radians(-90));
  image(car, 0, 0);
  popMatrix();
}

void game() {
  if (isTouched) {
    if (mouseX<width/2) {
      moveLeft();
    } else {
      moveRight();
    }
  }

  background(#766050);
  for (int i=133; i<267; i=i+133) {
    stroke(0);
    strokeWeight(8);
    line(i, 0, i, 900);
  }

  for (int i=0; i<=4; i++) {
    noStroke();
    fill(#766050);
    rect(0, lines[i], 400, 100);
    if (lines[i]>=900) {
      lines[i]=-100;
    }
    lines[i]=lines[i]+speedOfMyCar;
  }

  drawCar(x, y);

  for (int i=0; i<3; i++) {
    pushMatrix();
    translate(zloCars[i], ys[i]);
    scale(0.098);
    image(zloCar, 0, 0);
    popMatrix();
    if (ys[i]>=1000) {
      ys[i]=int(random(-1000, 0));
      if (i==0) {
        checkDistance(0, 1, 2);
      }
      if (i==1) {
        checkDistance(1, 0, 2);
      }
      if (i==2) {
        checkDistance(2, 0, 1);
      }
    }
    ys[i]=ys[i]+speedOfZloCar;
  }

  for (int i=0; i<3; i++) {
    if (abs(ys[i]-y)<=2400*0.098 && x==zloCars[i]) {
      state = GAME_OVER;
    }
  }
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
  if (abs(ys[firstCar]-ys[secondCar])<=352 && abs(ys[firstCar]-ys[thirdCar])<=352) {
    ys[firstCar]=ys[firstCar]-800;
  }
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