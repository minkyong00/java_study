package pub2504.basic;

import java.util.Scanner;

public class ConsoleIO {
	
	public static void main(String[] args) {
		
		// Scanner : 파일, 스트림, 키보드를 통한 입력을 처리하는 클래스
		// System.in : 표준 입력 (Stream : 데이터의 흐름)
		// System.out : 표준 출력 스트림
		// System.err : 표준 에러출력 스트림
		Scanner scanner = new Scanner(System.in); // 키보드 입력용 Scanner
		
//		while (scanner.hasNext()) { // 입력받을 문자열이 있는 동안 반복
//			String nextStr = scanner.next(); // 입력받은 문자열을 할당
//			System.out.println(nextStr);
//		}
		
		
		// 실습 : 두 수를 키보드로 입력받아 합계를 출력하는 프로그램
		int nextInt1 = 0;
		int nextInt2 = 0;
		
		if(scanner.hasNextInt()) {
			nextInt1 = scanner.nextInt();
		} else {
			System.out.println("정수를 입력해주세요");
			return; // main메소드에서 return하면 프로그램 종료 => System.exit(0); 해도 됨
		}
		if(scanner.hasNextInt()) {
			nextInt2 = scanner.nextInt();
		} else {
			System.out.println("정수를 입력해주세요");
			return;
		}
		
		int sum = nextInt1 + nextInt2;
		int mul = nextInt1 * nextInt2;
		System.out.println("두 수의 합 : " + sum);
		System.out.println("두 수의 곱 : " + mul);
		
		// printf : formatting print
		// 형식 문자열 : %d 정수, %s 문자열, %f 실수
		//            예시) %3.2f > 전체 3자리 중 소수점 이하 2자리
		//				   %10s > 문자열을 10자리에 맞춤
		System.out.printf("%d와 %d의 합은 %d 입니다!", 
				nextInt1, nextInt2, sum);
		
		
		// Scanner 사용 후 메모리에서 해제
		scanner.close();
		
	} // main
} // class
