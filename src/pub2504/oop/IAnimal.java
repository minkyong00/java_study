package pub2504.oop;

public interface IAnimal {

	public abstract void breath();
	
	public abstract void sound();
	
	// run 메소드를 추가하면?
	// IAnimalAdapter에 run메소드에 대한 정의가 없으므로 
	// IAnimalAdapter를 상속받은 모든 클래스에 문제가 발생!
	// public abstract void run();
	
	// 디폴트 메서드
	// 인터페이스 단계에서 추상메소드를 기본구현 하도록 추가된 문법
	// => 인터페이스에 추상메소드 추가/변경이 용이해 짐
	// => 인터페이스를 구현하고 있는 하위 클래스에게 구현의무를 주지 않게됨
	default void run() {};
	
}
