int x1 = 200;
int x2 = 370;
int x3 = 0;
int x4 = -200;
int frogY = 210;

void setup() { 
  size(200, 250); 
  noStroke();
} 

void draw() { 
  background(#EAF09D);
  stroke(100);

  // автомобильные полосы
  line(0, 40, 200, 40);
  line(0, 80, 200, 80);
  line(0, 120, 200, 120);
  line(0, 160, 200, 160);
  line(0, 200, 200, 200);

  // машины
  noStroke();
  fill(#F0623A);
  rect(x1, 50, 60, 20);
  x1 = x1 - 1;

  fill(#C13914);
  rect(x2, 50, 60, 20);
  x2 = x2 - 1;

  fill(#447CB2);
  rect(x3, 130, 60, 20);
  x3 = x3 + 1;

  fill(#6653D3);
  rect(x4, 130, 60, 20);
  x4 = x4 + 1;

  // лягушка
  fill(#58C62E);
  rect(90, frogY, 20, 20);
  if (frogY==x1||frogY==x2||frogY==x3||frogY==x4) {
    
    println("game over");
  }
}

void keyPressed() {
  frogY = frogY - 40;
}