package pub2504.api;

import java.util.StringTokenizer;

public class ExString {

	public static void main(String[] args) {
		// 실습1
		// 문자열내 한글 개수 출력
		String str1 = "안녕하세요! Java 재밌나요?";
		int str1Len = str1.length();
		int nkLen = str1.replaceAll("[가-힣]", "").length();
		System.out.println("한글의 개수 : " + (str1Len - nkLen));
		
		
		// 실습 2
	      // 홀수번째 인덱스에 있는 소문자들을 출력
	      String str2 = "Hello! Java Programming!";
	      int str2Len = str2.length();
	      
	      
	      
	      // 실습 3
	      // 문자열을 , 기준으로 분리하고 분리된 각 문자열과 문자열의 길이를 출력
	      String str3 = "Apple,Banana,Orange,Grape";
	      StringTokenizer st1 = new StringTokenizer(str3, ",");
	      while(st1.hasMoreTokens()) {
	    	  System.out.println(st1.nextToken());	    	  
	    	  System.out.println(st1);	    	  
	      }
	      
	      
	      // 실습 4
	      // 문자열내 단어의 수를 출력
	      String str4 = "    Java is a powerful programming language   ";
	      
	      
	   // 실습 5
	      // 문자열내 중복문자는 한번만 출력
	      String str5 = "This is Java Programming";
	      
	      
	      // 실습 6
	      // 주민등록번호 문자열에서 생년월일을 아래 형식으로 출력
	      // 생년월일 : 1999년 1월 16일
	      String str6 = "990116-1234567";
	      
	      
	      // 실습 7
	      // 문자열내 숫자들의 합을 출력
	      String str7 = "Today is 12th event in 2025";
	      
	      
	   // 실습 8
	      // 문자열내 a문자의 인덱스들을 출력
	      String str8 = "Banana is a very delicious and amazing";
	      
	      
	      // 실습 9
	      // 문자열내 두번째 Java 문자열의 인덱스를 출력
	      String str9 = "I love Java. I hate Java";
	      
	      
	      // 실습 10
	      // 문자열에서 확장자를 추출하여 출력
	      String str10 = "document.final.version.pdf";
	      
		
	}
}
