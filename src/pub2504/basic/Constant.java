package pub2504.basic;

// 상수 (Constant)
// 값을 초기화하면 값을 변경할 수 없는 변수
// 상수명은 대문자로 만드는 관례가 있고, 여러 단어의 조합인 경우 _로 연결
// 상수는 반드시 초기화해야 사용할 수 있음

public class Constant {
	
	// 일반적으로 상수는 아래와 같이 정의함
	// public : 어디서든 접근 가능하도록
	// static : 메모리에 1개만 생성
	public static final double PI = 3.141592; 
	
	public static void main(String[] args) {
		
		final int FI1;
//		System.out.println(FI1); // 상수는 초기화해야 사용 가능
		FI1 = 1; // 상수 초기화
		System.out.println(FI1);
		
//		FI1 = 2; // 상수는 초기화 후 값 변경 불가
		
		// 일반적으로 클래스를 통해 상수를 사용
		// static는 클래스로 접근
		System.out.println(Constant.PI);
		
	}
}
