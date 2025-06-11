package pub2504.basic;

/*
	 기본타입형변환 (Promitive Type Casting)
	 - 데이터(값)의 손실(loss) 유뮤에 따라 자동형변환/강제형변환으로 나눠짐
	 - 자동형변환 : 개발자가 관여하지 않아도 데이터의 손실이 없음을 보장할 수 있을때
	 			  형변환 연산을 명시하지 않아도 자동으로 형변환이 됨
	 - 강제형변환 : 데이터의 손실 우려가 있는 경우 컴파일러가 책임지지 못하므로
	 			  개발자가 명시적으로 형변환 연산을 해야 함
	 - long은 8byte정수, float는 4byte실수이지만 float의 표현범위가 long보다 넓으므로
	   long을 float로 형변환할 때는 자동 형 변환이 일어남
	 - boolean타입은 다른 타입과 형변환 되지 않음
	 - char타입은 0부터 양의 정수만 가지므로 byte를 char으로 형변환 할때도
	 	강제 형변환을 해줘야함
*/

public class primitiveTypeCasting {

	public static void main(String[] args) {
		
		// 8가지 기본타입
		byte b = 1; // int(1) > byte(1) 자동형변환
		short s = 2; // int(2) > short(2) 자동형변환
		int i = 3; // 형변환 없음
		long l = 4; // int(4) > long(4) 자동형변환
		float f = 1.0f; // 형변환 없음
		double d = 2.0; // 형변환 없음
		char c = 'A'; // 형변환 없음
		boolean bool = true; // 형변환 없음
		
		s = b; // byte(1) > short(1) 자동형변환
		
		b = (byte)s; // short(2) > byte(2), 바이트손실이 있으므로 강제형변환 해야 함
		
		d = f; // float(1.0f) > double 자동형변환
		
		f = (float)d; // double(2.0) > float, 바이트 손실이 있으므로 강제형변환 해야 함
	
		b = 65; // int(65) > byte 자동형변환
		
		b = (byte)128; // 128은 byte의 표현범위를 넘으므로 컴파일러가 책임 못짐 > 개발자가 책임져야 함, 강제형변환 필요
		System.out.println(b); // 데이터를 손실해서 쓰레기값(garbage value)
		
		b = 65;
		c = (char)b; // byte와 char은 비트구성이 다르므로 강제형변환 필요
		System.out.println(c); // ASCII코드 65가 A문자
		
		char c2 = '김';
		short s2 = (short)c2; // short과 char은 2바이트이지만 비트구성이 다르므로 강제형변환 필요
		System.out.println(s2); // 데이터를 손실해서 쓰레기값(garbage value)
		
		short s3 = (short)44608; // 10진수
		// short s3x = (short)0xAE40; // 16진수
		char c3 = (char)s3;
		System.out.println(c3); // 김
		
		long l2 = 10;
		float f2 = 1.0f;
		
		// long은 8byte 정수, float는 4byte 실수
		// 표현범위가 float가 넓으므로 long으로 강제형변환 해줘야 함
		l2 = (long)f2;
		
		
	} //main
} // class
