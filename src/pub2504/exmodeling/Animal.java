package pub2504.exmodeling;

public abstract class Animal extends Organism implements Eat, Sleep {
	// 동물 추상클래스
	// 동물은 생물 추상클래스를 상속받음
	// 동물은 먹는다, 잠을 잔다 기능인 인터페이스를 구현함
	public Animal(String name, int age) {
		super(name, age);
	}

	@Override
	public void sleep() {
		System.out.println(name + " 잠을 잔다!");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println(name + " 먹는다");
	}

}
