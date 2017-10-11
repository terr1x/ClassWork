int carX = 350;
PImage car;

void setup() {
  size(400, 400);
  car = loadImage("car.png");
}

void draw() {
  background(30);
  
  handleMotionKeys();
  
  for(int i = 0; i < 5; i++){
    image(car, carX, 100 + i * 40);
  }
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