package pub2504.exoop;

public class Herbivore extends Animal {
	
	public Herbivore(String name, int age, String food) {
		super(name, age, food);
	}

	@Override
	public void eat() {
		System.out.println(name + "가(이)" + food + "을 먹는다");
	}

	@Override
	public void sleep() {
		System.out.println(name + "가(이) 잠을 잔다");
	}
	
	
	
}
