package pub2504.exception;

public class ExceptionMain2 {

	public static void main(String[] args) {
		
		System.out.println("main 메소드 호출");
		
		// 1. main 메소드에서 try~catch로 처리
		try {
			a();
		} catch (ArithmeticException ae) {
			System.out.println("main메소드에서 예외를 처리함!");
		}
		
		// 2. main에서 예외처리를 하지 않음
		// JVM에 예외가 전달되고 예외처리가 되지 않음
		// => main에서는 무조건 예외가 처리되어야 
		// a();
		
	} // main

	private static void a() throws ArithmeticException {
		
		System.out.println("a메소드 호출됨!");
	
		// 1. a메소드에서 try~catch로 처리
//		try {
//			b();
//		} catch (ArithmeticException ae) {
//			System.out.println("a메소드에서 예외를 처리함!");
//		}
		
		// 2. a메소드를 호출한 main메소드에 예외 처리 위임
		b();
		
	} // a
	
	private static void b() throws ArithmeticException {
		
		System.out.println("b메소드 호출됨!");
	
		// 1. b메소드에서 try~catch로 처리
//		try {
//			// ArithmeticExecption 발생
//			int i = 10 / 0;
//		} catch (ArithmeticException ae) {
//			System.out.println("b메소드에서 예외를 처리함");
//		}

		// 2. b메소드를 호출한 a메소들에 예외처리를 위임 (throws)
		int i = 10 / 0;
		
		System.out.println("예외처리 이후에 수행할 코드들..");
		
	} // b
	
} // class
