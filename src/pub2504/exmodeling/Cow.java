package pub2504.exmodeling;

public class Cow extends Animal implements Herbivore {

	// 소 클래스
	// 소는 초식하다 인터페이스를 구현함
	public Cow(String name, int age) {
		super(name, age);
	}

	@Override
	public void herbivore() {
		System.out.println(name + " 풀을 먹는다");
	}

}
