package pub2504.exmodeling;

public class OrganismMain {

	public static void main(String[] args) {

		Organism tiger = new Tiger("호랑이", 2);
		Organism lion = new Lion("사자", 2);
		Organism human = new Human("홍길동", 2);
		Organism cow = new Cow("소", 2);
		Organism deer = new Deer("사슴", 2);

		print(tiger);
		print(lion);
		print(human);
		print(cow);
		print(deer);

	}

	// 템플릿 메소드
	private static void print(Organism om) {
		om.breathe();
		if (om instanceof Animal) {
			((Animal) om).sleep();
			((Animal) om).eat();
		}
	}

}
