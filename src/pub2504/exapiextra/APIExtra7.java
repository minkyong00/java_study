package pub2504.exapiextra;

import java.util.Scanner;

public class APIExtra7 {

	public static void main(String[] args) {
		// 영문 대소문자를 포함한 문자열을 입력하면 대문자는 소문자로 소문자로 대문자로 변환하여 출력
		
		Scanner sc = new Scanner(System.in);
		
//		String str1 = "";
//		System.out.println("영문 대소문자를 포함한 문자열을 입력해주세요");
//		str1 = sc.nextLine();
//		
//		String result = "";
//		
//		int strLeng = str1.length();
//		for(int i=0; i<strLeng; i++) {
//			char c = str1.charAt(i);
//			
//			if(Character.isUpperCase(c)) {
//				c = Character.toLowerCase(c);
//			} else if(Character.isLowerCase(c)) {
//				c = Character.toUpperCase(c);
//			}
//			result += c;
//		}
//		System.out.println(result);
//		
//		sc.close();
		
		String line = Util.getLineText(1)[0];
		
		char[] chArr = line.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		
		for(char ch : chArr) {
			byte b = (byte)ch;
			if((b > 64 && b < 91) || (b > 96 && b < 123)) {
				if(b < 91) {
					sb.append((char)(ch+32));
				} else {
					sb.append((char)(ch-32));
				}
			}
		}
		
		System.out.println(sb);
	}
}
