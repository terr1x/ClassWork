namespace CatFactory {
	class Cat {
        int score;
		public string name;
		public double age;
		public double weight;
		public double strenght;

        public Cat(string name,double age,double weight,double strenght) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strenght = strenght;
        }

        public string Fight(Cat enemyCat) {
            score = 0;
            enemyCat.score = 0;

            if (age > enemyCat.age) {
                score = score + 1;
            } else {
                enemyCat.score = enemyCat.score + 1;
            }

            if (weight > enemyCat.weight) {
                score = score + 1;
            } else {
                enemyCat.score = enemyCat.score + 1;
            }

            if (strenght > enemyCat.strenght) {
                score = score + 1;
            } else {
                enemyCat.score = enemyCat.score + 1;
            }

            if (score > enemyCat.score) {
                return name;
            } else {
                return enemyCat.name;
            }
        }        
	}
}
