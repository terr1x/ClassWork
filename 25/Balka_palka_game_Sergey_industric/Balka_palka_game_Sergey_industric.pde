int numBall = 5;

int[] xOfball = new int[numBall];
int yOfBall = -100;
int speedOfBall = int(random(1, 3));
int ballSize = int(random(40, 90));


color colorOfBall = color(random(255), random(255), random(255));

void setup() {
  size(500, 500);
  noStroke();
  setupBall();
}
void draw() {
  background(#5457A0);
  fill(colorOfBall);
  for (int i = 0; i<numBall; i++) {
    ellipse(xOfball[i], 200, ballSize, ballSize);
  }
}

void setupBall() {
  for (int i = 0; i<numBall; i++) {
    xOfball[i] = int(random(95, 405));
  }
}