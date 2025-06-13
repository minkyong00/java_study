package pub2504.api;

import java.math.BigInteger;

/*
 	BigInteger : long보다 큰 범위의 정수를 다룰 때
 	BigDecimal : double보다 큰 범위의 실수를 다룰 때
*/

public class BigIntegerTest {

	public static void main(String[] args) {
		
		// long의 범위 : -9,223,372,036,854,775,808 부터 9,223,372,036,854,775,807 
		BigInteger bi1 = new BigInteger("652154565468855315265486823855432");
		BigInteger bi2 = new BigInteger("665321655135153531354566855555");
		
		System.out.println(bi1.add(bi2)); // 덧셈
		System.out.println(bi1.subtract(bi2)); // 뺄셈
		System.out.println(bi1.multiply(bi2)); // 곱셈
		System.out.println(bi1.divide(bi2)); // 나눗셈
		System.out.println(bi1.remainder(bi2)); // 나머지
		
	}
}
