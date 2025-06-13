package pub2504.api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 정규표현식 (Regular Expression)
 * 정해진 패턴문자열들을 사용해서 문자열내의 문자열을 검색, 치환에 사용되는 표현식
 * ^ : 문자열의 시작
 * [^문자열] : 문자열이 아닌 것
 * $ : 문자열의 끝
 * . : 임의의 한 문자
 * * : 문자가 0개 이상 발생
 * + : 문자가 1개 이상 발생
 * ? : 문자가 0개 또는 1개 발생
 * [] : 문자의 집합 범위
 * {} : 문자열의 반복 회수
 * | : or
 * \b : 단어의 경계
 * \B : 단어가 아닌 것의 경계
 * \s : 공백문자
 * \S : 공백문자가 아닌 문자
 * \w : word (영문대소문자, 숫자, _)
 * \W : word가 아닌 것
 * \d : 숫자 = [0-9]
 * \D : 숫자가 아닌 것
 * \\ : \문자 자체 
 */

public class RegularExpressionTest {

	public static void main(String[] args) {
		
		// String클래스의 matches메소드 : 문자열이 패턴을 따르면 true
		String str1 = "abcde";
		System.out.println(str1.matches("abc")); // false
		System.out.println(str1.matches("abcde")); // true
		
		String str2 = "010-1234-5678";
		System.out.println(str2.matches("\\d{3}-\\d{4}-\\d{4}")); // true
		System.out.println(str2.matches("\\d{3}-\\d{3}-\\d{4}")); // false
		
		String str3 = "12345";
		System.out.println(str3.matches("\\d{5}")); // true
		System.out.println(str3.matches("[0-9]{5}")); // true
		
		String str4 = "abc123";
		String str5 = "ABC123";
		System.out.println(str4.matches("[a-zA-Z]{3}[0-9]{3}")); // true
		System.out.println(str4.matches("[a-zA-Z]{3}\\d{3}")); // true
		
		String str6 = "안녕 자바";
		System.out.println(str6.matches("[가-힣]{2}\s[가-힣]{2}")); // true
		
		// java.util.regex 패키지
		// Pattern : 정규표현식 패턴 클래스
		// Matcher : 패턴에 맞는 지 체크하는 메소드가 있는 클래스
		
		// Pattern
		// Pattern.complile(패턴문자열, 플래그) : 패턴 생성
		// Pattern.CASE_INSENSITIVE : 대소문자 구별없이 탐색
		// Pattern.MULTILINE : 여러라인의 시작과 끝 탐색
		// Pattern.DOTALL : .이 개행 문자도 포함하도록
		
		// 대소문자 구별없이 a가 0개이상으로 시작하고 b로 끝나는 패턴
		Pattern p = Pattern.compile("^a*b$", Pattern.CASE_INSENSITIVE);
		
		// Matcher
		Matcher m1 = p.matcher("ab");
		System.out.println(m1.matches()); // true

		Matcher m2 = p.matcher("bb");
		System.out.println(m2.matches()); // false

		Matcher m3 = p.matcher("aaab");
		System.out.println(m3.matches()); // true
		
		// 정규표현식 실습 1
		// 아래 문자열에서 숫자만 남겨서 출력
		String rstr1 = "전화: 010-1234-5678";
		String rstr1Num = rstr1.replaceAll("[^0-9]", " ").trim();
		System.out.println(rstr1Num);
		
		
        // 정규표현식 실습 2
        // 아래 문자열을 공백 기준으로 단어들을 분리해서 출력
        String rstr2 = "Java is powerful and simple";		
		String[] rstr2Arr = rstr2.split("\\s");
		for(String rstr : rstr2Arr) {
			System.out.println(rstr);
		}
		
		
       // 정규표현식 실습 3 (Pattern 사용)
       // 아래 문자열이 Java라는 단어를 포함하고 있는지 출력
       String rstr3 = "I love Java Programming";
       Pattern p1 = Pattern.compile("[A-Z][a-z]{3}");
       String[] rstr3Arr = rstr3.split("\\s");
       int rstr3ArrLeng = rstr3Arr.length;
       Matcher mc1 = null;
       for(int i=0; i<rstr3ArrLeng; i++) {
    	   String rstr = rstr3Arr[i];
    	   mc1 = p1.matcher(rstr);
    	   System.out.println(mc1.matches());    	   
       }
      
       // 정규표현식 실습 4
       // 아래 문자열에서 소문자만 제거 후 출력
       String rstr4 = "Java123abcDEF";
       String rstr4Token = rstr4.replaceAll("[a-z]", "");
       System.out.println(rstr4Token);
       
      
       // 정규표현식 실습 5
       // 아래 문자열이 휴대폰 번호 형식이 맞는지 확인 후 출력
       String rstr5 = "010-1234-5678";
       System.out.println(rstr5.matches("\\d{3}-\\d{4}-\\d{4}"));
       
      
       // 정규표현식 실습 6
       // 아래 문자열에서 HTML 태그를 제거 후 출력
       String rstr6 = "<p>Hello<br><b>World</b>";
       String rstr6Token = rstr6.replaceAll("</?[a-z]+>", "");
       System.out.println(rstr6Token);
       
      
       // 정규표현식 실습 7
       // 아래 문자열에서 여러개의 공백을 하나로 변경 후 출력
       String rstr7 = "Java      is      easy";
       String rstr7Token = rstr7.replaceAll("\\s+", " ");
       System.out.println(rstr7Token);
       
      
       // 정규표현식 실습 8
       // 아래 배열의 문자열들에 모두 매칭되는 전화번호 정규표현식 패턴만들기
       // 전화번호 : 숫자2개나3개-숫자3개나4개-숫자4개
       String[] telArr = {
            "02-123-4567",
            "031-123-4567",
            "02-1234-5678",
            "031-1234-5678"
       };
       String regex = "\\d{2,3}-\\d{3,4}-\\d{4}";
       for(String tel : telArr) {
    	   System.out.println(tel.matches(regex));
       }
      
       // 정규표현식 실습 9
       // 아래 배열의 문자열들에 모두 매칭되는 주민등록번호 정규표현식 패턴만들기
       // 주민등록번호 : 년도2자리월2자리일2자리-남녀구분1자리숫자6자리
       // 년도:00~99, 월:01~12, 일:01~31, 남녀구분:1~4중하나
       String[] ssnArr = {
            "100101-3234567",
            "001231-4234567",
            "900101-1234567",
            "800101-2234567",
            "701301-1234567",
            "601201-5234567"
       };      
       String regex1 = "\\d{2}([0]\\d | [1][0-2])([0]\\d | [1-2]\\d | [3][0-1])-[1-4]\\d{6}";
       for(String ssn : ssnArr) {
    	   System.out.println(ssn.matches(regex));
       }
       
       
      
       // 정규표현식 실습 10
       // 아래 문자열의 다양한 날짜 형식들을 "YYYY-MM-DD" 형식으로 출력
       String rstr10 = "오늘은 2025-06-13이고, 작년엔 2024.06.12에 회의를 했고, 다음 회의는 2025/06/15입니다.";
       String[] rstr10Token = rstr10.replaceAll("\\D", "").split("\\s");
       
       int rstr10Leng = rstr10Token.length;
       for(int i=0; i<rstr10Leng; i++) {
    	   System.out.println(rstr10Token[i]);
       }
       
		
		
		
		
		
		
		
		
		
	} // main
} // class
