void setup() {
  background(#F2FA9C);
  int toothLen = int(random(60));
  size(400, 400);

  ellipse(150, 70, 60, 120);  // левое ухо
  ellipse(240, 70, 60, 120);  // правое ухо

  ellipse(200, 170, 150, 150);    // морда

  fill(0);
  ellipse(170, 150, 10, 10);  // левый глаз
  ellipse(230, 150, 10, 10);  // правый глаз

  line(150, 200, 250, 200);   // рот

  fill(255);
  rect(185, 200, 15, toothLen); // левый зуб
  rect(200, 200, 15, toothLen); // правый зуб
}