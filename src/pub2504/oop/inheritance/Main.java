package pub2504.oop.inheritance;

public class Main {

	public static void main(String[] args) {
		
		// Child 객체 생성
		// 상위타입이 존재하면 상위타입 참조변수에 하위타입 객체의
		// 참조값을 저장한다 => 타입 일원화를 목적으로
		//  child는 Parent타입이지만 가지고 있는 참조는 Child타입의 참조값
		// Parent의 상위인 Object로 안받는 이유는 Object에는 아무값도 없음
		Parent child = new Child();
		
		// Parent에서 private이 아닌 변수들만 접근 가능
		System.out.println(child.si);
		System.out.println(child.nsi);

		// Parent에서 private이 아닌 메소드들만 접근 가능
		child.sm();
		child.nsm();
		
	}
}
