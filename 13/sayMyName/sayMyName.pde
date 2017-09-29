void setup() {
  size(400, 400);
  sayHello();
  sayHello();
  sayHello();
  sayHello();
}

void sayHello() {
  float textX = random(0, 200);
  float textY = random(0, 300);
  String myName = "Александр";
  fill(255, 0, 0);
  textSize(30);
  text("Привет, " + myName, textX, textY);
}