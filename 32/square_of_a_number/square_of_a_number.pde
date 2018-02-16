int n = int(random(0, 50));
int number = 1;
int numberInSquare;

void setup() {
  println("Эй!Бот, найди квадраты чисел, которые мешьше: "+n);
  while (true) {

    numberInSquare = number*number;
    
    if (numberInSquare>n) {
      break;
    }

    println(numberInSquare);

    number = number+1;

    delay(2000);
  }
}