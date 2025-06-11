package pub2504.basic;

public class Operator {

	public static void main(String[] args) {
		
		// 단항 연산자
		int i1 = +5; // 양수, + 생략가능
		int j1 = -i1; // 음수, - 생략불가
		
		// 전치/후치
		int i2 = ++i1; // 전치연산자, i1이 1 증가되고 i2에 할당
		int i3 = i1++; // 후치연산자, i1이 i3에 할당된 후 1 증가됨
		
		// 삼항연산자
		int i4 = 5;
		int j2 = i4 > 5 ? 1 : 2;
		
		// 비트연산자
		byte b1 = 3; // 00000011
		byte b2 = (byte)~3; // 11111100, 비트반전
		byte b3 = 5; // 00000101
		byte b4 = 3 | 5; // 00000011 | 00000101  => 00000111, 비트 or
		byte b5 = 3 & 5; // 00000011 & 00000101 => 00000001, 비트 and
		byte b6 = 3 ^ 5; // 00000011 ^ 00000101 => 00000110, 비트 xor(같으면 0, 다르면 1)
		
		// 쉬프트연산자
		// 비트쉬프트연산의 이유는 2곱하기, 2로 나누기를 더 빨리 연산하기 위함
		// 좌시프트를 하나 한다는 건 곱하기 2를 하는 것 00000001 > 00000010 > 00000100
		// 우시프트를 하나 한다는건 나누기 2를 하는 것 00000100 > 00000010 > 00000001
		byte b7 = 5; // 00000101
		byte b8 = 5 >> 3; // 00000000, 비트를 오른쪽으로 피연산자수만큼 이동시키고 앞비트를 0으로 채움
		byte b9 = (byte)(-5 >>> 3); // 11111111, 비트를 오른쪽으로 피연산자수만큼 이동시키고 앞비트를 부호로 채움
		byte b10 = 3 << 2; // 00001100,  비트를 왼쪽으로 피연산자수만큼 이동시키고 뒷비트를 0으로 채움
		
		// 나머지 연산자
		int i5 = 7;
		int j5 = 3;
		int remainder = i5 % j5; // 1
		
		// 관계 연산자
		int i6 = 10;
		int j6 = 5;
		boolean bool1 = i6 == j6; // false  
		boolean bool2 = i6 != j6;  // true
		boolean bool3 = i6 > j6;  // true
		boolean bool4 = i6 >= j6;  // true
		boolean bool5 = i6 < j6;  // false
		boolean bool6 = i6 <= j6;  // false
		
		// 논리 연산자
		boolean bool7 = true;
		boolean bool8 = false;
		boolean bool9 = !bool7; // false
		boolean bool10 = bool7 | bool8; // true
		boolean bool11 = bool7 & bool8; // false
		// bool7이 true이므로 bool8은 판별하지 않음 > 연산속도 증가
		boolean bool12 = bool7 || bool8; // true
		// bool7이 true이므로 bool8을 판별해야 함 > 만약에 bool7이 false면 bool8을 판별하지 않음
		boolean bool13 = bool7 && bool8; // false
		
		// 대입 연산자
		int i8 = 5;
		int i9 = 3;
		i9 += i8; // i9 = i9 + i8;
		i9 -= i8; // i9 = i9 - i8;
		i9 *= i8; // i9 = i9 * i8;
		i9 /= i8; // i9 = i9 / i8;
		i9 %= i8; // i9 = i9 % i8;
		
		// 연산자 우선 순위
		// ()가 연산자 우선 순위가 가장 높음
		// 대입 연산자가 우선 순위가 가장 낮음
		// 피연산자 수가 적을수록 우선 순위가 높음
		// 연산을 우선적으로 해야할 경우는 ()를 사용
		
		
	}
}


/*
 양수 > 음수 변환 시 비트를 반전시킨 후 1을 더해 줌
 00000101 (5)
 11111010 
 11111011 (-5)
*/
