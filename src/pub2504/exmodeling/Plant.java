package pub2504.exmodeling;

public abstract class Plant extends Organism implements Breathe {
	// 식물 추상클래스
	// 식물은 생물 추상클래스를 상속받음
	// 식물은 숨쉬기 기능을 하는 인터페이스를 구현함

	public Plant(String name, int age) {
		super(name, age);
	}

}
