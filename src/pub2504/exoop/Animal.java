package pub2504.exoop;

public abstract class Animal extends OrganismClass implements Organism {

	String food;
	
	public Animal(String name, int age, String food) {
		super(name, age);
		this.food = food;
	}
	
	@Override
	public void breathe() {
		System.out.println(name + "가(이) 숨을 쉰다");
	}
	
	public abstract void eat();
	
	public abstract void sleep();
	
}
