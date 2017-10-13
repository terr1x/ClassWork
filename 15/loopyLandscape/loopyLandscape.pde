PImage grass;
PImage tree;
void setup() {
  size(400, 400);
  background(144, 240, 234);

  grass = loadImage("GrassBlock.png");
  tree = loadImage("TreeUgly.png");

  // рисуем солнце
  noStroke();
  fill(255, 140, 0);
  ellipse(335, 66, 70, 70);

  // рисуем траву и куст
  for (int i=0; i<400; i=i+100) {
    drawGrassTree(i);
  }
}
void drawGrassTree(int x) {
  image(grass, x, 270);
  image(tree, x, 200);
}