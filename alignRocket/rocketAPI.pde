PImage earth;
PImage rocket;

float x;
float y;
int alpha = 180;

void init() {
  earth = loadImage("planet.png");
  rocket = loadImage("rocket.png");
  drawLevel();
  noStroke();
  x = 180 * cos(radians(alpha + 180));
  y = 180 * sin(radians(alpha + 180));
}

void drawLevel() {
  background(#3B5279);

  pushMatrix();
  translate(width / 2, height / 2);
  image(earth, -100, -100);
  popMatrix();
}

void drawRocket() {
  image(rocket, 0, 0);

  // иллюминаторы
  addBigWindow();
  addSmallWindow(10, 65);
  addSmallWindow(50, 70);
  addSmallWindow(50, 50);
  addSmallWindow(90, 65);
}

void drawBigWindow() {
  fill(#556080);
  ellipse(0, 0, 20, 20);
}

void drawSmallWindow() {
  fill(#8697CB);
  ellipse(0, 0, 12, 12);
}

void moveRocket() {
  x = 180 * cos(radians(alpha + 180));
  y = 180 * sin(radians(alpha + 180));
  alpha++;
}

void addBigWindow() {
  pushMatrix();
  translate(50, 25);
  drawBigWindow();
  popMatrix();
}

void addSmallWindow(int x, int y) {
  pushMatrix();
  translate(x, y);
  drawSmallWindow();
  popMatrix();
}