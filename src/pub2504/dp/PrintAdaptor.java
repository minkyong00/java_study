package pub2504.dp;

// [디자인패턴 중 어뎁터 패턴]
// 어뎁터 패턴의 예)
// 인터페이스와 클래스 중간에 추상클래스를 생성해서 
// 클래스가 강제적으로 구현해야할 메소드들을 추상클래스에서 기본 구현하도록 하고
// 클래스가 인터페이스를 직접 구현하는 것이 아니라 인터페이스를 구현한 추상클래스를
// 상속받도록 만듦 => 클래스는 원하는 오버라이딩만 할 수 있음

// 어뎁터 추상클래스는 구현한 인터페이스의 모든 추상메소드를 기본 구현만 해 놓는다.

public abstract class PrintAdaptor implements Print {

	@Override
	public void turnOn() {
	}
	
	@Override
	public void print() {
	}
	
	@Override
	public void turnOff() {
	}
	
}
