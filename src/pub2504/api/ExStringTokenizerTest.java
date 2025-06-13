package pub2504.api;

import java.util.StringTokenizer;

public class ExStringTokenizerTest {
	
	public static void main(String[] args) {
		
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
	    
	    // [
	    //{"name": "홍길동", "email": "hong@hong.com", "tel": "010-0000-0000"},
	    //{"name": "강감찬", "email": "kang@kang.com", "tel": "010-1111-1111"},
	    //{"name": "이순신", "email": "lee@lee.com", "tel": "010-2222-2222"}
	    //]
	    System.out.println(str4);
	    
	    StringTokenizer objTokenizer 
	       = new StringTokenizer(str4.substring(1, str4.length()-1), "{},:\" ");
	    
	    int tokenCount = objTokenizer.countTokens();
	    String[] tokens = new String[tokenCount];
	    
	    int idx = 0;
	    while (objTokenizer.hasMoreTokens()) {
	       tokens[idx++] = objTokenizer.nextToken();
	    }
	    
	    for (int i=1; i<tokenCount; i=i+6) {
	       String newTel = "";
	       StringTokenizer telTokenizer = new StringTokenizer(tokens[i+4], "-");
	       while (telTokenizer.hasMoreTokens()) {
	          newTel += telTokenizer.nextToken();
	       }
	       System.out.printf(
	          "번호: %d, 이름: %s, 이메일: %s, 전화번호: %s\n",
	          i/6+1, 
	          tokens[i], 
	          tokens[i+2],
	          newTel.substring(0, 3) + ")" +
	                newTel.substring(3, 7) + "-" +
	                   newTel.substring(7, 11)
	       );
	    }
		
		
	}


}
