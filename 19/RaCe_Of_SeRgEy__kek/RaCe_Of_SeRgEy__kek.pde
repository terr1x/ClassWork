PImage car; //<>//
PImage zloCar;
int[] ys={int(random(-500, 0)), int(random(-500, 0)), int(random(-500, 0))};
int[] lines = {100, 300, 500, 700, 900};
int[] zloCars = {65, 200, 335};
int y=770;
int x=200;

void setup() {
  size(400, 900, P2D);
  imageMode(CENTER);
  smooth(10);
  car = loadImage("mashinka.png");
  zloCar = loadImage("zlo-mashinka.png");
}

void draw() {
  background(#766050);
  for (int i=133; i<267; i=i+133) {
    stroke(0);
    strokeWeight(8);
    line(i, 0, i, 900);
  }

  for (int i=0; i<=4; i++) {
    noStroke();
    fill(#766050);
    rect(0, lines[i], 400, 100);
    if (lines[i]>=900) {
      lines[i]=-100;
    }
    lines[i]=lines[i]+7;
  }

  drawCar(x, y);

  for (int i=0; i<3; i++) {
    pushMatrix();
    translate(zloCars[i], ys[i]);
    scale(0.098);
    image(zloCar, 0, 0);
    popMatrix();
    if (ys[i]>=1000) {
      ys[i]=int(random(-1000, 0));
      if (i==0) {
        checkDistance(0, 1, 2);
      }
      if (i==1) {
        checkDistance(1, 0, 2);
      }
      if (i==2) {
        checkDistance(2, 0, 1);
      }
    }
    ys[i]=ys[i]+9;
    if (abs(ys[i]-y)<=2400*0.098 && x==zloCars[i]) {
      println("game over");
    }
  }
}




void keyPressed() {  
  if (key=='a') {
    x=x-135;
    if (x<65) {
      x=65;
    }
  }
  if (key=='d') {
    x=x+135;
  }
  if (x>335) {
    x=335;
  }
}