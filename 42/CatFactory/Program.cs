using System;

namespace CatFactory {
	class Program {
		static void Main(string[] args) {
			Cat barsik = new Cat("Барсик", 3, 2.5, 10);
			Cat kuzya = new Cat("Кузя", 2.5, 4, 5);
			Cat ryzhik = new Cat("Рыжик", 5, 3, 6);

			Console.WriteLine(barsik.Fight(kuzya));
			Console.WriteLine(kuzya.Fight(ryzhik));
            Console.WriteLine(ryzhik.Fight(barsik));

			Console.ReadLine();
		}
	}
}
