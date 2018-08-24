using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpiritualWolf {
	class Program {
		static void Main(string[] args) {
			Wolf wolf = new Wolf(new string[] { "Омммм", "Поклонение восьмирукому и трёхглазому Победителю Смерти, сидящему в падмасане", "ОМ! О, Земля, Небо, Сварга!" });
			wolf.Sing();
			wolf.Sing();

			Console.ReadLine();
		}
	}
}
