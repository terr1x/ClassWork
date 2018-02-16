
void setup() {
  while (true) {
    int firstNumber = int(random(0, 2));
    int secondNumber = int(random(0, 2));
    int thirdNumber = int(random(0, 2));

    int answer = int(random(0, 6));

    println("Я останусь с тобой навечно, шучу пока не решишь задачу "+firstNumber+"+"+secondNumber+"+"+thirdNumber+"!");
    println(answer);

    if (firstNumber+secondNumber+thirdNumber == answer) {
      println("так и быть, иди!");
      break;
    } else {
      println("аххахах ну удачи!");
    }
    delay(5000);
  }
}