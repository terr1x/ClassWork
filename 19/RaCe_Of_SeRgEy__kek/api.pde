void drawCar(int x, int y) {
  pushMatrix();
  translate(x, y);
  scale(0.098);
  rotate(radians(-90));
  image(car, 0, 0);
  popMatrix();
}

void gameOver() {
  background(#C7C96C);
  fill(#030000);
  textSize(40);
  text("Lol GAMEOVER",50,450);
  speedOfMyCar=0;
  speedOfZloCar=0;
  println("game over");
}

void checkDistance(int firstCar, int secondCar, int thirdCar) {
  if (abs(ys[firstCar]-ys[secondCar])<=352 && abs(ys[firstCar]-ys[thirdCar])<=352) {
    ys[firstCar]=ys[firstCar]-800;
  }
}