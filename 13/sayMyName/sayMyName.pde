void setup() {
  size(400, 400);
  sayHello(40, 50);
  sayHello(100, 100);
  sayHello(40, 150);
  sayHello(100, 200);
}

void sayHello(float textX, float textY) {
  String myName = "Александр";
  fill(255, 0, 0);
  textSize(30);
  text("Привет, " + myName, textX, textY);
}