package pub2504.oop.inheritance;

public class Vehicle /* extends Object */{

	String name; // 탈것의 이름
	boolean hasEngine; // 탈것의 엔진 보유 여부
	
	// vehicle에 기본생성자를 안만들면
	// Car, Bicycle에서는 기본생성자가 없는 에러가 남 
	// 기본 생성자를 만들거나 Car, Bicycle에서 파라미터가 있는 생성자를 만든다
//	Vehicle() {
//	}
	
	Vehicle(String name, boolean hasEngine) {
		this.name = name;
		this.hasEngine = hasEngine;
	}
	
	String getInfo() {
		return "탈것 이름: " + name +", 탈것 엔진보유여부: " + hasEngine;
	}
	
	@Override
	public String toString() {
		return "탈것";
	}

	
	
}
