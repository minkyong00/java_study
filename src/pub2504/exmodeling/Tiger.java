package pub2504.exmodeling;

public class Tiger extends Animal implements Carnivore {
	// 호랑이 클래스
	// 호랑이는 육식하다 인터페이스를 구현함
	// 먹는다, 육식한다 오버라이딩

	public Tiger(String name, int age) {
		super(name, age);
	}

	@Override
	public void carnivore() {
		System.out.println(name + " 고기를 먹는다");
	}
}
