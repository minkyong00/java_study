package pub2504.exapiextra;

import java.util.Scanner;

public class APIExtra6 {

	public static void main(String[] args) {
		// 문자 10개를 공백과 함께 입력하면 모두 합쳐진 문자열을 출력 (StringBuilder 사용)
		
//		Scanner sc = new Scanner(System.in);
//		
//		String str1 = "";
//		int str1Leng = str1.length();
//		
//		System.out.println("문자 10개를 공백과 함께 입력하세요");
//		str1 = sc.nextLine();
//		
//		StringBuilder sb = new StringBuilder();
//		sb.append(str1);
//		int idx = 0;
//		while((idx=sb.indexOf(" ", idx+1))>-1) {
//			sb.deleteCharAt(idx);
//		}
//		System.out.println(sb);
//		
//		sc.close();
		
		String line = Util.getLineText(1)[0];
		
		char[] chArr = line.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		
		for(char ch : chArr) {
			if(ch != ' ') {
				sb.append(ch);
			}
		}
		
		System.out.println(sb);
	}
}
