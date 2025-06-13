package pub2504.exapiextra;

import java.util.Scanner;

public class APIExtra4 {

	public static void main(String[] args) {
		// 문자열을 두 줄 입력하고 첫번째 문자열내에 두번째 문자열이 존재하는지 출력
		
		Scanner sc = new Scanner(System.in);
		
		String str1 = "";
		String str2 = "";
		
		System.out.println("문자열 두 줄을 입력하세요");
		str1 = sc.nextLine();
		str2 = sc.nextLine();
		
		int idx = 0;
		while((idx=str1.indexOf(str2, idx+1))>-1) {
			System.out.println("true");
		}

		
		
	}
}
