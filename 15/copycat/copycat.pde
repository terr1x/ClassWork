PImage sheet;

void setup(){
  size(400, 400);
  sheet = loadImage("cats.png");
  
  drawCat();
}

void drawCat(){
  int catX = (int)random(12) * 48;
  int catY = (int)random(8) * 48;
  int posX = (int)random(width - 48);
  int posY = (int)random(height - 48);
  image(sheet.get(catX, catY, 48, 48), posX, posY);
}