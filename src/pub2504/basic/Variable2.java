package pub2504.basic;

// 자바의 변수는 선언 위치에 따라서 3가지 중 하나
// 1. static member variable : 클래스 내부, 메소드 외부에서 static 키워드로 선언된 변수
// 							   프로그램 실행 시에 최초 한번 메모리에 생성되고 종료시까지 유지
//							   class loading time에 메모리에 생성됨
// 2. non-static member variable : 클래스 내부, 메소드 외부에서 static 키워드 없이 선언된 변수
//								   객체가 생성되면 메모리에 생성되었다가 객체가 소멸되면 메모리에서 삭제됨
// 								   객체 생성시 메모리에 생성됨
// 3. local variable : 메소드 내부에서 선언한 변수
// 					   메소드가 호출되면 메모리에 생성되었다가 메소드가 반환하면 메모리에서 삭제됨(생명주기 가장 짧음)
//					   메소드 생성시 메모리에 생성됨

public class Variable2 {
	
	// 맨 먼저 생기고 한개만 생김
	// static member variable
	// Variable2 클래스가 실행되는 동안 계속 메모리에 존재
	// static 멤버변수는 메모리에 하나만 생성되고 클래스에서 생성된 모든 객체들이 변수의 값을 공유
	// 클래스를 통해 static멤버변수의 값을 바꾸거나 객체를 통해 static멤버변수의 값을 바꾸면
	// 클래스와 클래스를 통해 생성된 모든 객체들에서 static멤버변수의 값이 바뀜
	static int si = 1;
	
	// static 다음에 생김
	// non-static member variable
	// Variable2 타입의 객체가 생성되면 메모리에 생성되었다가
	// 객체가 소멸하면 메모리에서 제거됨
	// non-static멤버변수는 객체마다 가지게 되고 어떤 객체에서 값을 변경해도 다른 객체에 영향을 미치지 않음
	int nsi = 2;
	
	static int si2;
	int nsi2;
	
	// static 초기화 블럭
	// 블럭안의 영역은 static 영역이고 static변수들을 초기화 하는데 사용됨
	static int si3;
	static {
		si3 = 5;
		// static 초기화 블럭내에서 선언되었으므로 static 초기화 블럭의 지역변수
		int i = 10;
	}
	
	// main메소드가 static인 이유는? 
	// JVM은 프로그램 실행 시에 main메소드를 찾아서 실행시킴
	// 이 때는 객체가 없으므로 static메모리 상태에서(객체없이) 호출해야 함
	public static void main(String[] args) {
		// local variable
		// main 메소드가 호출되면 메모리에 생성되었다가
		// 메소드가 반환하면 메모리에서 제거
		int li = 3;
		
		si2 = 4;
		// main메소드는 static메소드 이므로 
		// non-static 변수인 nsi2를 참조(사용)할 수 없음
		// nsi2 = 5; // Cannot make a static reference to the non-static field nsi2
		
		// Variable2타입의 객체 생성
		// variable2는 무슨 변수는?
		// main메소드의 local 변수(main메소드 내에서 선언됨)
		// 생성된 객체는 Heap Area에 생성됨
		// 생성된 객체의 참조값을 가지고 있는 variable2 변수는 Stack Area에 생성됨
		Variable2 variable2 = new Variable2();
		
		// 클래스(static)를 통해 static member variable 접근 가능
		Variable2.si2 = 5;
		// 객체(non-static)를 통해 static member variable 접근 가능
		variable2.si2 = 5;
		// 클래스(static)를 통해 non-static member variable 접근 불가
		// Variable2.nsi2 = 5;
		// 객체(non-static)를 통해 static member variable 접근 가능
		variable2.nsi2 = 5;		
		
//		Variable2.i
		
	} // main
} // class
