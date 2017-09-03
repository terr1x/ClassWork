import processing.sound.SoundFile;

PImage kek;
PImage ground;
PImage bullet;
SoundFile sound;

int angle = 90;
int pos = 0;
Boolean shooted=false;

void setup() {
  size(1000, 800, P3D);
  sound = new SoundFile(this, "shot_hand_gun.wav");
  kek = loadImage("кек.png");
  ground = loadImage("ground.png");
  bullet = loadImage("кек лол арбидол.png");
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
    if (pos==800) {
      shooted=false;
      pos=0;
    }
  }
  popMatrix();
}

void keyReleased() { 
  if (key==' ') {
    
    shooted=true;
    sound.play();
    pos=0;
  }
}