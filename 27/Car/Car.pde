color carColor = color(0);
float carX = 0;
float carY = 100;
float carSpeed = 1;

void setup() {
  size(200, 200);
}

void draw() {
  background(255);
  moveCar();
  displayCar();
}

void moveCar() {
  carX = carX + carSpeed;
  if (carX > width) {
    carX = 0;
  }
}

void displayCar() {
  fill(carColor);
  rect(carX, carY, 30, 10);
}