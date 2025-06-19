package pub2504.exoop;

public class OrganismMain {

	public static void main(String[] args) {
		
		Animal tiger = new Carnivore("호랑이", 3, "고기");
		Animal lion = new Carnivore("사자", 5, "고기");
		Animal cow = new Herbivore("소", 2, "풀");
		Animal deer = new Herbivore("사슴", 5, "풀");
		Animal human = new Human("사람", 20, "밥");
		
		tiger.breathe();
		tiger.eat();
		tiger.sleep();
		
		lion.breathe();
		lion.eat();
		lion.sleep();
		
		cow.breathe();
		cow.eat();
		cow.sleep();
		
		deer.breathe();
		deer.eat();
		deer.sleep();
		
		human.breathe();
		human.eat();
		human.sleep();
	
	}
}
