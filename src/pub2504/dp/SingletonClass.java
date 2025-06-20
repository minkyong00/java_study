package pub2504.dp;

/*
 	[디자인패턴 중 싱글턴패턴]
 	- 목적 : 객체를 하나만 생성할 목적으로 클래스를 설계하는 디자인 패턴
 	- 방식 
 	  1) private static 멤버변수에 객체를 생성해서 할당 => 메모리에 하나만 생성 되도록
 	  2) private 생성자 => 클래스 외부에서 객체 생성을 못하도록
 	  3) public static 생성된 객체를 반환하는 메소드((ex)getInstance 메소드) => 외부에서 생성된 객체를 사용할 수 있도록
*/

public class SingletonClass {

	private static SingletonClass singletonObj
		= new SingletonClass();
	
	private SingletonClass() {
	}

	public static SingletonClass getInstance() {
		return singletonObj;
	}
	
} // class
