package pub2504.api;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
	
		String str1 = "안녕하세요! 자바 재밌나요?";
		String str2 = "010-1234-5678";
		
		StringTokenizer st1 = new StringTokenizer(str1); // 공백문자 기준으로 토크나이징
		System.out.println(st1.countTokens()); // 4
		
		while (st1.hasMoreTokens()) { // 토큰이 있는 동안 반복
			System.out.println(st1.nextToken()); // 토큰을 꺼내서 출력
		}
		
		StringTokenizer st2 = new StringTokenizer(str2, "-"); // - 문자 기준으로 토크나이징
		System.out.println(st2.countTokens()); // 3
		
		while (st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		
		// 실습
		// str3 문자열을 토크나이징해서 각 토큰을 출력
		
		
		String str3 = "a,b,c\nd,e,f\n1,2,3";
		
		StringTokenizer st3 = new StringTokenizer(str3, ",");
		
		while(st3.hasMoreTokens()) {
			System.out.println(st3.nextToken());
		}	
		
	} // main
	
} // class
