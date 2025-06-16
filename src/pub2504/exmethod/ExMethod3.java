package pub2504.exmethod;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ExMethod3 {
	// 2개 정수, 연산자 입력하면 사칙연산 수행하는 프로그램
	// 기능별로 따로 따로 만들기(입력, 연산, 프린트 따로)
	public static void main(String[] args) {
		numAddMulSubDiv();
	}
	
	static void numAddMulSubDiv() {
		Scanner sc = new Scanner(System.in);
		System.out.println("2개의 정수와 연산자를 입력하세요!");
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		String str = sc.next(Pattern.compile("[+-]|[/*]"));
		
		try {
			
			// 스위치로 변경해보기
			if(str.equals("+")) {
				int sum = a + b;
				print(a, b, str, sum);
			} else if(str.equals("-")) {
				int sub = a - b;
				print(a, b, str, sub);
			} else if(str.equals("*")) {
				int mul = a * b;		
				print(a, b, str, mul);
			} else if(str.equals("/")) {				
				int div = a / b;
				print(a, b, str, div);
			}
			
			
		} catch (InputMismatchException ime) {
			System.out.println("세번째는 +, -, /, * 연산자를 입력하세요");
		} finally {
			sc.close();
		}
	}
	
	static void print(int a, int b, String s, int result) {
		System.out.printf("%d %s %d = %d", a, s, b, result);
	}
	
	
}
