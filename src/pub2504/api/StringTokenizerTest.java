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
		
		StringTokenizer st3 = new StringTokenizer(str3, "\n");
		while(st3.hasMoreTokens()) {			
			StringTokenizer st4 = new StringTokenizer(st3.nextToken(), ",");
			while(st4.hasMoreTokens()) {
				System.out.println(st4.nextToken());
			}
		}
		
		
	      // 실습
	      // str4 문자열을 토크나이징해서 아래 형식으로 출력
	      // 번호:1, 이름:홍길동, 이메일:hong@hong.com, 전화번호:(010)0000-0000
	      // 번호:2, 이름:강감찬, 이메일:kang@kang.com, 전화번호:(010)1111-2222
	      // 번호:3, 이름:이순신, 이메일:lee@lee.com, 전화번호:(010)2222-2222
	      
	      String str4 = "[";
	      str4 += "{\"name\": \"홍길동\", \"email\": \"hong@hong.com\", \"tel\": \"010-0000-0000\"},";
	      str4 += "{\"name\": \"강감찬\", \"email\": \"kang@kang.com\", \"tel\": \"010-1111-1111\"},";
	      str4 += "{\"name\": \"이순신\", \"email\": \"lee@lee.com\", \"tel\": \"010-2222-2222\"}";
	      str4 += "]";		
	      System.out.println(str4);
	      StringBuilder personSb = new StringBuilder();
	      
	      
	      StringTokenizer st5 = new StringTokenizer(str4, ",");
	      while(st5.hasMoreTokens()) {
	    	  StringTokenizer st6 = new StringTokenizer(st5.nextToken(), "{");
	    	  while(st6.hasMoreTokens()) {
	    		  StringTokenizer st7 = new StringTokenizer(st6.nextToken(), "}");
	    		  while(st7.hasMoreTokens()) {
	    			  StringTokenizer st8 = new StringTokenizer(st7.nextToken(), ":");
	    			  while(st8.hasMoreTokens()) {
	    				  StringTokenizer st9 = new StringTokenizer(st8.nextToken(), "\"");
	    				  while(st9.hasMoreTokens()) {
	    					  String st9Token = st9.nextToken();
		    				  personSb.append(st9Token);
	    				  }
	    			  }
	    		  }
	    	  }
	      }
	      
	      personSb.trimToSize();
	      System.out.println(personSb);
	      System.out.println(personSb.substring(6, 9));
	      System.out.println(personSb.substring(16, 30));
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
		
	} // main
	
} // class
