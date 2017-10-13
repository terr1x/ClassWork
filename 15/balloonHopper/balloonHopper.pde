PImage hopper;

void setup() {
  size(400, 400);
  background(122, 224, 255);
  stroke(64, 117, 207);
  fill(196, 33, 255);
  hopper = loadImage("Hopper-Jumping.png");
  image(hopper, 208, 240);

  for (int i=50; i<=300; i=i+50) {
    drawBalloons(i);
  }
}

//добавить код рисования шаров
void drawBalloons(int x) {
  line(212, 305, x, 100);
  ellipse(x, 100, 40, 60);
}