package pub2504.exmodeling;

public class Lion extends Animal implements Carnivore {

	// 사자 클래스
	// 사자는 육식하다 인터페이스를 구현함

	public Lion(String name, int age) {
		super(name, age);
	}

	@Override
	public void carnivore() {
		System.out.println(name + " 고기를 먹는다");
	}

}
