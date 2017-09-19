size(400, 400);

float textX = random(0, 200);
float textY = random(0, 300);
String myName = "Твое имя";

fill(255, 0, 0);
textSize(30);
text("Привет, " + myName, textX, textY);