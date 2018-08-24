using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RobotFactory {
	class Robot {
        int id;
		private static int lastID = 0;
		public Robot() {
			lastID = lastID + 1;
            id = lastID;
		}

		public int GetID() {
			return id;
		}
	}
}