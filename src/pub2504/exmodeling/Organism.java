package pub2504.exmodeling;

public abstract class Organism implements Breathe {
	// 생물 추상 클래스
	// 생물은 숨을 쉬는 인터페이스를 구현함
	// 생물은 이름과 나이를 가짐

	String name;
	int age;

	public Organism() {
	}

	public Organism(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "생물 [이름: " + name + ", 나이: " + age + "]";
	}

	@Override
	public void breathe() {
		System.out.println(name + " 숨을 쉰다");
	}

}
