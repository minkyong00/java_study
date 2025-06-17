package pub2504.exmethod;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ExMethod3 {
	// 2개 정수, 연산자 입력하면 사칙연산 수행하는 프로그램
	// 기능별로 따로 따로 만들기(입력, 연산, 프린트 따로)
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		numAddMulSubDiv();
	}
	
	static int calcNum(String str, int[] intArr) {
		switch(str) {
			case "+":
				return intArr[0] + intArr[1];
			case "-":
				return intArr[0] - intArr[1];
			case "/":
				return intArr[0] / intArr[1];
			case "*":
				return intArr[0] * intArr[1];
		}
		return 0;
	}
	
	static int[] inputNums() {
		int[] intArr = new int[2];
		intArr[0] = sc.nextInt();
		intArr[1] = sc.nextInt();
		return intArr;
	}
	
	
	static void numAddMulSubDiv() {
		System.out.println("2개의 정수와 연산자를 입력하세요!");
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		try {
			String str = sc.next(Pattern.compile("[+-]|[/*]"));
			
			
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
