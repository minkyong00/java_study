package pub2504.basic;

import java.util.Scanner;

public class ExConditionalStatement1 {

	public static void main(String[] args) {
		// 두 수의 합이 10보다 크면 "10보다 크다" 아니면 "10보다 크지 않다"를 출력
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("두 수를 입력하세요");
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		
		int sum = num1 + num2;
		
		if(sum > 10) { System.out.printf("두 수의 합은 %d이므로 10보다 크다", sum); }
		else { System.out.printf("두 수의 합은 %d이므로 10보다 크지 않다", sum); }
		
		scanner.close();
	}
}
