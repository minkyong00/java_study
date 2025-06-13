package pub2504.api;

import java.util.StringTokenizer;

public class ExString {

	public static void main(String[] args) {
		// 실습1
		// 문자열내 한글 개수 출력
		String str1 = "안녕하세요! Java 재밌나요?";
		int str1Len = str1.length();
		int nkLen = str1.replaceAll("[가-힣]", "").length(); //한글이 아닌 숫자의 길이
		System.out.println("한글의 개수 : " + (str1Len - nkLen));
		
		
		  // 실습 2
	      // 홀수번째 인덱스에 있는 소문자들을 출력
	      String str2 = "Hello! Java Programming!";
	      int str2Len = str2.length();
	      String regex = "[a-z]";
	      for(int i=1; i<str2Len; i+=2) {
	    	  char c = str2.charAt(i);
	    	  if(String.valueOf(c).matches(regex)) {
	    		  System.out.println(c);	    		  
	    	  }
	      }
	      
	      
	      // 실습 3
	      // 문자열을 , 기준으로 분리하고 분리된 각 문자열과 문자열의 길이를 출력
	      // split 사용해서 풀어보기
	      String str3 = "Apple,Banana,Orange,Grape";
	      StringTokenizer st1 = new StringTokenizer(str3, ",");
	      while(st1.hasMoreTokens()) {
	    	  String token = st1.nextToken();
	    	  System.out.println(token + "의 문자열 길이 : " + token.length());	    	  
	      }
	      
	      
	      // 실습 4
	      // 문자열내 단어의 수를 출력
	      String str4 = "    Java is a powerful programming language   ";
	      StringTokenizer st2 = new StringTokenizer(str4.trim(), " ");
	      System.out.println("문자열내 단어의 수 : " +st2.countTokens());
	      
	      
	      // 실습 5
	      // 문자열내 중복문자는 한번만 출력
	      String str5 = "This is Java Programming";
	      int str5Len = str5.length();
	      char[] noDupArr = new char[str5Len];
	      int noDupIdx = 0;
	      for(int i=0; i<str5Len; i++) {
	    	  char ch = str5.charAt(i);
	    	  boolean isDup = false;
	    	  noDupArr[i] = ch;
	    	  for(int j=0; j<noDupIdx; j++) {
	    		  if(noDupArr[j] == ch) {
	    			  isDup = true;
	    			  break;
	    		  }
	    	  }
	    	  if(!isDup) {
	    		  noDupArr[noDupIdx] = ch;
	    		  noDupIdx++;
	    	  };
	      }
	      for(int i=0; i<noDupIdx; i++) {
	    	  System.out.println(noDupArr[i]);
	      }
	      

	      
	      // 실습 6
	      // 주민등록번호 문자열에서 생년월일을 아래 형식으로 출력
	      // 생년월일 : 1999년 1월 16일
	      String str6 = "990116-1234567";
	      String shortYear = str6.substring(0, 2);
	      String month = str6.substring(2, 4);
	      String date = str6.substring(4, 6);
	      System.out.printf("생년월일 : 19%s년 %s월 %s일\n", 
	    		  shortYear,
	    		  month.startsWith("0") ? month.charAt(1) : month,
	    		  date
	      );
	      
	      
	      
	      // 실습 7
	      // 문자열내 숫자들의 합을 출력
	      // 바이트로 형변환해서 아스키코드 사용해서 풀어보기
	      String str7 = "Today is 12th event in 2025";
	      String regex1 = "[^0-9]+";
	      int sum = 0;
	      String[] str7Arr = str7.replaceAll(regex1, " ").trim().split(" ");
	      for(String str:str7Arr) {
	    	  int num = Integer.parseInt(str);
	    	  sum += num;
	      }
	      System.out.println("문자열내 숫자들의 합 : " + sum);
	      
	      
	      // 실습 8
	      // 문자열내 a문자의 인덱스들을 출력
	      String str8 = "Banana is a very delicious and amazing";
	      int idx = -1;
	      while((idx=str8.indexOf("a", idx+1)) >= 0) {
	    	  System.out.println("a의 인덱스 : " + idx);
	      }
	      
	      // 실습 9
	      // 문자열내 두번째 Java 문자열의 인덱스를 출력
	      String str9 = "I love Java. I hate Java";
	      int idx2 = -1;
	      int count = 0;
	      while((idx2=str9.indexOf("Java", idx2+1)) >= 0) {
	    	  count++;
	    	  if(count == 2) {
	    		  System.out.println(idx2);
	    	  }
	      }
	      
	      
	      // 실습 10
	      // 문자열에서 확장자를 추출하여 출력
	      String str10 = "document.final.version.pdf";
	      String[] str10Arr = str10.split("\\.");
	      int str10Len = str10Arr.length;
	      System.out.println(str10Arr[str10Len -1]);
	      
	      int lastDotIdx = str10.lastIndexOf(".");
	      System.out.println(str10.substring(lastDotIdx+1));
	      
	}
}
