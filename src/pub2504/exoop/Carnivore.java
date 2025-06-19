package pub2504.exoop;

public class Carnivore extends Animal {
	
	public Carnivore(String name, int age, String food) {
		super(name, age, food);
	}

	@Override
	public void eat() {
		System.out.println(name + "가(이)" + food + "를 먹는다");
	}

	@Override
	public void sleep() {
		System.out.println(name + "가(이) 잠을 잔다");
	}

}
