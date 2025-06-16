package pub2504.exception;

public class ExceptionTest1 {
	
	// 8byte * 1024 => 8Kbyte * 1024 => 8Mbyte * 1024 => 8Gbyte 
	long[] longArr = new long[1024 * 1024 * 1024];
	// 1byte * 1024 => 1Kbyte * 1024 => 1Mbyte * 1024 => 1Gbyte 
	// byte[] longArr = new byte[1024 * 1024 * 1024];
	
	public static void main(String[] args) {
		
		// OutOfMemoryError : 객체의 저장공간인 Heap메모리가 부족
		// eclipse.ini 파일에 Xms(최소힙크기), Xmx(최대힙크기) 설정 가능
		// JVM이 관리하는 객체 하나의 최대 크기는 2Gbyte
		ExceptionTest1 obj = new ExceptionTest1();
		
		// StackOverflowError 발생 : 메소드 순환 호출 main > a > b > a > b...
//		a();
	}
	
	public static void a() {
		b();
	}
	
	public static void b() {
		a();
	}
	
}