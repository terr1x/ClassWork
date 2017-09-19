void setup() {
  size(400, 400);
  background(52, 168, 83); // трава
  fill(0, 0, 0);
  ellipse(200, 200, 100, 30); // норы!
  ellipse(70, 119, 100, 30);
  ellipse(300, 60, 100, 30);
  ellipse(297, 350, 100, 30);
}

void drawMole() {
  int moleX = 248;
  int moleY = 185;

  noStroke();
  fill(125, 93, 43);
  ellipse(moleX, moleY, 60, 60); // морда
  fill(255, 237, 209);
  ellipse(moleX, moleY+10, 33, 28); 
  fill(0, 0, 0);
  ellipse(moleX-10, moleY-15, 10, 10); // глаза
  ellipse(moleX+10, moleY-15, 10, 10);
  ellipse(moleX, moleY-5, 10, 10); // нос
  ellipse(moleX, moleY+10, 20, 5); // рот
}