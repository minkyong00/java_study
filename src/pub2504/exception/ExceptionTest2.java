package pub2504.exception;

import java.util.Scanner;

public class ExceptionTest2 {

	public static void main(String[] args) {
		// 두 개의 정수를 입력하여 나눗셈 결과 출력
		// 단, 재수가 0인 경우는 "0으로 나눌 수 없습니다!"라고 출력
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println(sc.nextInt() / sc.nextInt());
		} catch (ArithmeticException ae) {
			System.out.println("0으로 나눌 수 없습니다!");
		} finally {
			sc.close();
		}
		
	}
	
}
