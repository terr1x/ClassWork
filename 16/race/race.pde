int[] speeds = {1,2,3,4,5};
int[] carXes = {120, 190, 260, 330, 400};
PImage car;

void setup() {
  size(400, 400);
  car = loadImage("car.png");
}

void draw() {
  background(30);

  handleMotionKeys();

  for (int i = 0; i < 5; i++) {
    image(car, carXes[i], 100 + i * 40);
  }
}

void handleMotionKeys() {
  if (keyPressed) {
    if (key == 'a') {
      for (int i = 0; i < 5; i++) {
        carXes[i] -= speeds[i];
      }
    } else if (key == 'd') {
      for (int i = 0; i < 5; i++) {
        carXes[i] += speeds[i];
      }
    }
  }
}