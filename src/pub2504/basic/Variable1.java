package pub2504.basic;

public class Variable1 {

	public static void main(String[] args) {
		
		// 자바의 기본타입 8가지
		byte b = 1; // 1바이트 부호화 정수 (표현범위 : -2^7 ~ 2^7 -1)
		short s = 2; // 2바이트 부호화 정수 (표현범위 : -2^15 ~ 2^15 -1)
		int i = 3; // 4바이트 부호화 정수 (표현범위 : -2^31 ~ 2^31 -1)
		long l = 4; // 8바이트 부호화 정수 (표현범위 : -2^63 ~ 2^63 -1)
		// float 표현범위 : 1.4x10^-45 ~ 3.4028235x10^38
		float f = 3.14f; // 4바이트 부호화 실수 (1비트 부호비트, 8비트 지수비트, 23비트 가수비트)
		// double 표현범위 : 1.4x10^-324 ~ 3.4028235x10^38
		double d = 2.1; // 8바이트 부호화 실수 (1비트 부호비트, 11비트 지수비트, 52비트 가수비트)
		char c = 'A'; // 2바이트 유니코드
		boolean bool = true; // 1바이트 (true 또는 false의 값만 가짐)
		
		// 정수와 실수는 비트구성이 다르기 때문에 4바이트 실수인 float가 8바이트 정수인 long보다
		// 표현범위가 더 넓음
		
		// 표현범위 : double > float > long > int > short > byte
		
		// 정수타입의 기본타입 : int
		// 실수타입의 기본타입 : double
		
		
		
	} // main
	
} // class
