int amount;

void setup() {
  while (true) {
    int randomNumber;

    randomNumber = int(random(0, 200));
    amount = amount+randomNumber;
    println(randomNumber);
    println("сумма "+ amount);
    delay(1000);
  }
}