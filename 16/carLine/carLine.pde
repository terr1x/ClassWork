int carX = 200;
PImage car;

void setup() {
  size(400, 400);
  car = loadImage("car.png");
}

void draw() {
  background(30);
  
  handleMotionKeys();
  image(car, carX, 200);
}

void handleMotionKeys(){
  if (keyPressed) {
    if (key == 'a') {
      carX -= 2;
    } else if (key == 'd') {
      carX += 2;
    }
  }
}