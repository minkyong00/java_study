package pub2504.oop;

public class PhoneFactoryMain {

	public static void main(String[] args) {
		
		// PhoneFactory를 통해서 전화를 생산하세요
		// PhoneFactory 인터페이스타입의 객체를 
		// 익명이너클래스로 통해서 생성할 수 있다
		// 이때 생성된 익명이너클래스는 PhoneFactory 인터페이스 타입이다
		// phone변수의 타입은 PhoneFactory
		// phone변수가 가지고 있는 참조는 생성된 PhoneFactory타입의 객체의 참조
		PhoneFactory phone1 = new PhoneFactory() {
			@Override
			public void makePhone() {
				System.out.println("핸드폰 생산 완료");
			}
		};
		phone1.makePhone();
	}
}
