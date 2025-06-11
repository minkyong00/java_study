package pub2504.basic;

import java.util.Scanner;

public class ExConsoleIO2 {

	public static void main(String[] args) {
		// 문자열 3개 키보드로 입력받아서 그 중 boolean 개수 출력
		// == : 기본타입의 값이 같은지 비교
		// equals : 문자열(String)이 같은지 비교
			
		Scanner scanner = new Scanner(System.in);
		
		String str1 = "";
		String str2 = "";
		String str3 = "";
		int boolCount = 0;
		
		str1 = scanner.next();
		str2 = scanner.next();
		str3 = scanner.next();
		
		if(str1.equals("true") || str1.equals("false")) { boolCount += 1; } 
		if (str2.equals("true") || str2.equals("false")) { boolCount += 1; } 
		if (str3.equals("true") || str3.equals("false")) { boolCount += 1; }
		System.out.println("문자열 중 boolean의 개수 : " + boolCount);
		
		scanner.close();
		
	}
}
