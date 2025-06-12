package pub2504.api;

// clone 조건 1 : 복제할 객체의 클래스는 Cloneable 인터페이스를 구현해야 함
public class Person implements Cloneable {
	
	String name;
	int age;
	
	public Person() {
		
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
// clone 조건 2 : 복제할 객체의 클래스는 Object의 clone메소드를 오버라이딩 해야 함
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
