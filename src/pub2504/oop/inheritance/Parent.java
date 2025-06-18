package pub2504.oop.inheritance;

// 상속 해주는 클래스
// 상위(super) = 부모(parent) = 기본(base)
public class Parent /* extends Object */{
	
	private static int psi; // private 상속 불가
	private int pnsi; // private 상속 불가
	static int si; // 상속 가능
	int nsi; // 상속 가능
	
	// 생성자는 상속 불가
	public Parent() {
	}
	
	private static void psm() { // private 상속 불가
		System.out.println("psm()");
	}
	
	private void pm() { // private 상속 불가
		System.out.println("pnsm()");
	}
	
	static void sm() { // 상속 가능
		System.out.println("sm()");
	}
	
	void nsm() { // 상속 가능
		System.out.println("nsm()");
	}
	
}
