package pub2504.exmodeling;

public class Human extends Animal implements Herbivore, Carnivore {

	// 사람 클래스
	// 사람은 초식, 육식을 포함하므로
	// 육식하다, 초식하다 인터페이스 구현함
	public Human(String name, int age) {
		super(name, age);
	}

	@Override
	public void carnivore() {
		System.out.println(name + " 고기를 먹는다");
	}

	@Override
	public void herbivore() {
		System.out.println(name + " 풀을 먹는다");
	}

}
