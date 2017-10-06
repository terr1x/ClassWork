PImage sheet;

void setup() {
  size(1800, 920);
  smooth(0);
  sheet = loadImage("cats.png");

  for (int i = 0; i < 30; i++) {
    drawCat();
  }
}

void drawCat() {
  int catX = (int)random(12) * 48;
  int catY = (int)random(8) * 48;
  int posX = (int)random(width - 96);
  int posY = (int)random(-10, height - 96);
  image(sheet.get(catX, catY, 48, 48), posX, posY, 96, 96);
}