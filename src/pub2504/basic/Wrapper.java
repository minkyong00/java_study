package pub2504.basic;

public class Wrapper {

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
		
		// Wrapper Class : 기본타입의 값을 가지는 참조타입을 생성
		// Wrapping : 기본타입의 값을 갖는 참조타입을 생성하는 것 = Boxing
		Byte wb = new Byte(b);
		Short ws = new Short(s);
		Integer wi = new Integer(i);
		Long wl = new Long(l);
		Float wf = new Float(f);
		Double wd = new Double(d);
		Character wc = new Character(c);
		Boolean wbool = new Boolean(bool);
		
		// Unwrapping : 참조타입이 가진 기본타입의 값을 꺼내는 것 = Unboxing
		System.out.println(wb.byteValue());
		System.out.println(ws.shortValue());
		System.out.println(wi.intValue());
		System.out.println(wl.longValue());
		System.out.println(wf.floatValue());
		System.out.println(wd.doubleValue());
		System.out.println(wc.charValue());
		System.out.println(wbool.booleanValue());
		
		// auto-wrapping
		// 5는 기본타입 int, 기본타입 5를 Integer에 넣기 위해 자동으로 래핑이 일어남
		Integer integer = 5; // Integer integer = new Integer(5);
		
		// auto-unwrapping
		// 덧셈연산을 하기 위해서 new Integer(5)에서 기본타입 int의 값 5를 자동으로 언래핑함
		int sum = 3 + new Integer(5); // int sum = 3 + 5;
		
	}
	
}
