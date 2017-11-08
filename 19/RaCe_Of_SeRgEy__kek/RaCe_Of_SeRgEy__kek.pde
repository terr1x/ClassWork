PImage car;

void setup() {
  size(400, 900, P2D);
  imageMode(CENTER);
  smooth(8);
  car = loadImage("mashinka.png");
}

void draw() {
  background(#766050);
  for (int i=133; i<267; i=i+133) {
    stroke(0);
    strokeWeight(8);
    line(i, 0, i, 900);
  }
  for (int i=100; i<901; i=i+200) {
    noStroke();
    fill(#766050);
    rect(0, i, 400, 100);
  }
  pushMatrix();
  translate(200, 450);
  scale(0.098);
  rotate(radians(-90));
  image(car, 0, 0);
  popMatrix();
}