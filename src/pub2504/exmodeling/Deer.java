package pub2504.exmodeling;

public class Deer extends Animal implements Herbivore {

	// 사슴 클래스
	// 사슴은 초식하다 인터페이스를 구현함
	public Deer(String name, int age) {
		super(name, age);
	}

	@Override
	public void herbivore() {
		System.out.println(name + " 풀을 먹는다");
	}

}
