Button btn1 = new Button(10, 10, 100, 30);
Button btn2 = new Button(200, 10, 100, 30);
TextField tf = new TextField(120, 10, "0");

void setup() {
  size(400, 400);
  fill(0);
  textSize(20);
  textAlign(LEFT, TOP);
}
void draw() {
  background(255);
  btn1.draw();
  btn2.draw();
  tf.draw();
}

class Button {
  int x = 0;
  int y = 0;
  int width = 0;
  int height = 0;
  Button(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }
  void draw() {
    rect(x, y, width, height);
  }
}

class TextField {
  int x = 0;
  int y = 0;
  String text;

  TextField(int x, int y, String text) {
    this.x = x;
    this.y = y;
    this.text = text;
  }

  void draw() {
    text(text, x, y);
  }
}