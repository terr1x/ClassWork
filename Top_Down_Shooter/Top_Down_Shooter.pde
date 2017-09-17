import processing.sound.SoundFile;

PImage kek;
PImage ground;
PImage bullet;
PImage target;
SoundFile sound;

int angle = 90;
int pos = 0;
int xTarget = int(random(300, 930));
Boolean shooted=false;

void setup() {
  size(1000, 800, P3D);
  sound = new SoundFile(this, "shot_hand_gun.wav");
  kek = loadImage("кек.png");
  ground = loadImage("ground.png");
  bullet = loadImage("кек лол арбидол.png");
  target = loadImage("бэлка.png");
}

void draw() {
  image(ground, 0, 0);

  pushMatrix();
  //translate and rotate hero
  translate(250, height / 2 );
  rotate(radians(angle));

  image(kek, -260, -200, 520, 400 );

  if (keyPressed) {
    if (keyCode == LEFT) {
      angle--;
    } else if (keyCode == RIGHT) {
      angle++;
    }
  }
  if (shooted==true) {
    pos=pos+10;
    image(bullet, pos, 0);
    
    float x = modelX(pos, 0, 0);
    float y = modelY(pos, 0, 0);
    if (xTarget==x && yTarget==y) {
      xTarget = int(random(300, 930));
      yTarget = int(random(600));
    }
    
    if (pos==800) {
      shooted=false;
      pos=0;
    }
  }
  popMatrix();
  translate(xTarget, yTarget);
  scale(-0.5, 0.5);
  image(target, 0, 0);
}

void keyReleased() { 
  if (key==' ') {
    shooted=true;
    sound.play();
    pos=0;
  }
}