package pub2504.oop.inheritance;

public class Ship extends Vehicle {


	private boolean isSwim;
	
	Ship(String name, boolean hasEngine, boolean isSwim) {
		super(name, hasEngine);
		this.isSwim = isSwim;
	}
	
	@Override
	String getInfo() {
		return "배 이름: " + name + ", 배 엔진여부: " + ", 배 수영여부: " + isSwim;
	}
	
	@Override
	public String toString() {
		return "배";
	}
	
}
