package pub2504.oop;

public class ConstructorMain {

	public static void main(String[] args) {
		
		// 각 멤버변수들의 타입의 기본값으로 초기화
		Person person1 = new Person();
		System.out.println(person1);
		
		Person person2 = new Person("홍길동");
		System.out.println(person2);
		
		Person person3 = new Person("홍길동", "산적");
		System.out.println(person3);
		
		Person person4 = new Person("홍길동", "산적", 20);
		System.out.println(person4);
		
		Person person5 = new Person("홍길동", "산적", 20, 160.5f);
		System.out.println(person5);
		
		
	}
}
