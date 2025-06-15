package pub2504.exapiextra;

import java.util.Scanner;

public class APIExtra7 {

	public static void main(String[] args) {
		// 영문 대소문자를 포함한 문자열을 입력하면 대문자는 소문자로 소문자로 대문자로 변환하여 출력
		
		Scanner sc = new Scanner(System.in);
		
		String str1 = "";
		System.out.println("영문 대소문자를 포함한 문자열을 입력해주세요");
		str1 = sc.nextLine();
		
		String result = "";
		
		int strLeng = str1.length();
		for(int i=0; i<strLeng; i++) {
			char c = str1.charAt(i);
			
			if(Character.isUpperCase(c)) {
				c = Character.toLowerCase(c);
			} else if(Character.isLowerCase(c)) {
				c = Character.toUpperCase(c);
			}
			result += c;
		}
		System.out.println(result);
		
		
	}
}
