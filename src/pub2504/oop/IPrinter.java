package pub2504.oop;

//	역할 : 프린터라면 공통적으로 가지고 있는 기능들에 대한 설계 
public interface IPrinter {

	// 프린터 켜기
	public abstract void turnOn();
	
	// 출력
	public abstract void print();
	
	// 프린터 끄기
	public abstract void turnOff();
	
}
