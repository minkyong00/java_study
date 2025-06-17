package pub2504.oop;

public class Car2Main {

	public static void main(String[] args) {
		
		// Car2의 생성자가 private이라서 객체생성이 Car2 외부에서는 불가능
		// Car2 car2 = new Car2();
		
		// 객체를 3개까지만 생성을 허용
//		Car2 car2_1 = Car2.getInstance();
//		Car2 car2_2 = Car2.getInstance();
//		Car2 car2_3 = Car2.getInstance();
//		System.out.println(Car2.objCount);
//		
		// Car2 car2_4 = Car2.getInstance();
		
		// setter메소드를 통해 객체의 멤버변수 값 변경
		Car2 audi = Car2.getInstance();
		audi.setCompany("AUDI KOREA");
		audi.setModel("A8");
		audi.setName("AUDI");
		// setter메소드를 private으로 설정하면 외부에서 price 변경 불가
		// audi.setPrice(0);
		// Car2의 getter가 제공하는 값만 획득 가능
		System.out.println(audi.getPrice());
		
	}
}
