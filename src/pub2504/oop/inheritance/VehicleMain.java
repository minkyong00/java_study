package pub2504.oop.inheritance;

public class VehicleMain {

	public static void main(String[] args) {
		
		// v1변수는 Vehicle타입, 가지고 있는 참조는 Vehicle타입
		Vehicle v1 = new Vehicle("탈것", false);
		System.out.println(v1); // Vehicle.toString() 호출됨
		System.out.println(v1.getInfo()); // Vehicle.getInfo() 호출됨
		
		// v2변수는 Vehicle타입, 가지고 있는 참조는 Car타입
		Vehicle v2 = new Car("BMW", true, 4);
		System.out.println(v2); // Car toString() 호출됨
		System.out.println(v2.getInfo()); // Car getInfo() 호출됨

		// v3변수는 Vehicle타입, 가지고 있는 참조는 Bicycle타입
		Vehicle v3 = new Bicycle("자전거", false, true);
		System.out.println(v3); // Bicycle toString() 호출됨
		System.out.println(v3.getInfo()); // Bicycle getInfo() 호출됨
		
		// 실습
		// Airplane 클래스를 생성하고 Vehicle을 상속받아 toString과 getInfo를
		// 오버라이딩한 후 Airplane객체를 하나 생성해서 toString과 getInfo를 호출/출력
		Vehicle v4 = new Airplane("아시아나 비행기", true, true);
		System.out.println(v4); // Airplane toString() 호출됨
		System.out.println(v4.getInfo()); // Airplane getInfo() 호출됨
		
		// 실습
		// Bentz1 ~ Bentz1000까지 1000개의 Car 객체를 생성
		// 씽씽이1 ~ 씽씽이1000까지 1000개의 Bicycle 객체를 생성
		// 잘날어1 ~ 잘날어1000까지 1000개의 Airplane 객체를 생성
		// 3000개의 정보를 출력
		
		// 덜 좋은 코드
//		int count = 1000;
//		Car[] cArr = new Car[count];
//		Bicycle[] bArr = new Bicycle[count];
//		Airplane[] aArr = new Airplane[count];
//		
//		for(int i=0; i<count; i++) {
//			cArr[i] = new Car("Bentz"+(i+1), true, 4);
//			bArr[i] = new Bicycle("씽씽이"+(i+1), false, true);
//			aArr[i] = new Airplane("잘날어"+(i+1), true, true);
//			System.out.println(cArr[i].getInfo());
//			System.out.println(bArr[i].getInfo());
//			System.out.println(aArr[i].getInfo());
//		}
		
		// 좀 더 좋은 코드
		int count = 3000;
		
		// Car, Bicycle, Airplane은 모두 Vehicle이다
		Vehicle[] vArr = new Vehicle[count];
		
		for(int i=0; i<count; i+=3) {
			vArr[i] = new Car("Bentz"+(i/3+1), true, 4);
			vArr[i+1] = new Bicycle("씽씽이"+(i/3+1), false, true);
			vArr[i+2] = new Airplane("잘날어"+(i/3+1), true, true);
		}
		
		for(Vehicle v : vArr) {
			// 오버라이딩을 활용하여 메소드 호출을 일원화한다
			System.out.println(v.getInfo());
		}
	}
}