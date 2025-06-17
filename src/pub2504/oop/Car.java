package pub2504.oop;

// 자동차를 추상화한 Car 클래스 설계
public class Car /* extends Object */ {

	// static member variable
	// 1. 객체 생성 없이 클래스를 통해서 사용 가능
	// 2. 클래스를 통해서 생성되는 객체들이 값을 공유
	// 3. static 접근, non-static 접근 모두 가능
	static int carCount = 0;
	
	// non-static member variable
	// 1. 객체를 생성한 후 객체를 통해서 사용 가능
	// 2. 객체마다 각각 다른 값을 저장
	// 3. non-static 접근만 가능
	String company; // 제조사명
	String model; // 모델명
	String name; // 이름
	int price; // 가격
	
	// static member method
	// 1. 객체 생성없이 클래스를 통해 사용 가능
	public static int getCarCount() {
		// static 블럭이므로
		// 1. static
		// 2. local
		// carCount앞에 Car.이 생략됨
		return carCount;
	}
	
	// non-static member method
	// 1. 객체 생성 후 사용 가능
	public int getPrice() {
		// non-static 블럭이므로 
		// 1. static
		// 2. non-static
		// 3. local
		return price;
	}
	
}
