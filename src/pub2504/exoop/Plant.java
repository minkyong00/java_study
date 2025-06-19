package pub2504.exoop;

public abstract class Plant extends OrganismClass implements Organism {

	public Plant(String name, int age) {
		super(name, age);
	}
	
	@Override
	public void breathe() {
		System.out.println(name + "가(이) 숨을 쉰다");
	}

	
	
}
