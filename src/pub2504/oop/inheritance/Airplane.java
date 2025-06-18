package pub2504.oop.inheritance;

public class Airplane extends Vehicle {


	private boolean isFlight; // 비행여부
	
	Airplane(String name, boolean hasEngine, boolean isFlight) {
		super(name, hasEngine);
		this.isFlight = isFlight;
	}
	
	@Override
	String getInfo() {
		return "비행기 이름: " + name + ", 비행기 엔진여부: " + hasEngine + ", 비행 여부: " + isFlight;
	}
	
	@Override
	public String toString() {
		return "비행기";
	}
	
}
