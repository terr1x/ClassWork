using System;

namespace RobotFactory {
	class Program {
		static void Main(string[] args) {
			Robot[] robots = new Robot[5];
			// создаем роботов
			for (int i = 0; i < robots.Length; i++) {
				robots[i] = new Robot();
			}

			// считываем их идентификаторы
			foreach (Robot robot in robots) {
				Console.WriteLine(robot.GetID());
			}

			Console.ReadLine();
		}
	}
}
