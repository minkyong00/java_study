package pub2504.oop.inheritance;

public class Car extends Vehicle {
// 자동차는 탈 것 중에 하나
	
	private int tireCount; // 자동차 타이어의 개수
	
	Car(String name, boolean hasEngine, int tireCount){
		// 상위 생성자 호출
		super(name, hasEngine);
		this.tireCount = tireCount;
	}
	
	// @Override Annotation (어노테이션)
	// 오버라이딩한 메소드인 지를 컴파일 단계에서 체크하기 위한 어노테이션
	// => 개발자의 실수 방지용
	@Override
	String getInfo() {
		return "자동차 이름: " + name +", 자동차 엔진보유여부: " + hasEngine 
				+ ", 자동차 바퀴 수: " + tireCount;
	}
	
	// vehicle에 있는 toString 오버라이딩함
	@Override
	public String toString() {
		return "자동차";
	}
	
}
