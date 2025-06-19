package pub2504.exoop;

public class Human extends Animal  {

	public Human(String name, int age, String food) {
		super(name, age, food);
	}

	@Override
	public void eat() {
		System.out.println(name + "이 " + food + "을 먹는다");
	}

	@Override
	public void sleep() {
		System.out.println(name + "이 잠을 잔다");
	}
	
	

	
}
