package pub2504.api;

public class StringTest {

	public static void main(String[] args) {
		
		String str1 = "abcdefgh"; // length : 8, index:0~7
		
		System.out.println(str1.charAt(3)); // d 
		System.out.println(str1.concat("ij")); // abcdefghij
		System.out.println(str1+"ij"); // abcdefghij
		System.out.println(str1.contains("cba")); // false 
		System.out.println(str1.endsWith("gh")); // true
		System.out.println(str1.startsWith("cd")); // false
		System.out.println(str1.equals("abcdefg")); // false
		System.out.println(str1.equalsIgnoreCase(("ABCDEFGH"))); // true
		
		byte[] byteArr = str1.getBytes();
		for(byte b : byteArr) {
			System.out.println(b); // ASCII코드값
			System.out.println((char)b); // 문자
		}
		
		System.out.println(str1.indexOf('c')); // 2
		
		String str2 = "          ";
		System.out.println(str2.isBlank()); // true
		System.out.println(str2.isEmpty()); // false
		
		String str3 = "abcdabcdabcd";
		System.out.println(str3.lastIndexOf('a')); // 8
		System.out.println(str3.length()); // 12
		System.out.println(str3.repeat(2)); // abcd가 6번
		System.out.println(str3.replace("bc", "ef")); // aefdaefdaefd
		System.out.println(str3.replaceAll("ab", "12")); // 12cd12cd12cd
		
		String str4 = "010-1234-5678";
		
		// - 문자열을 기준으로 문자열을 Tokenizing(자름)해서 String배열을 반환
		String[] strArr = str4.split("-");
		for(String str : strArr) {
			System.out.println(str);
		}
		
		String str5 = "안녕하세요! 자바 재밌나요?";
		
		System.out.println(str5.startsWith("안녕")); // true
		System.out.println(str5.substring(7)); // 자바 재밌나요?
		System.out.println(str5.substring(7, 9)); // 자바
		
		char[] charArr = str5.toCharArray();
		for(char ch : charArr) {
			System.out.println(ch);
		}
		
		String str6 = "  Abc  dEf  ";
		
		System.out.println(str6.toLowerCase()); //   abc  def  
		System.out.println(str6.toUpperCase()); //   ABC  DEF  
		System.out.println(str6.trim()); // Abc  dEf
		System.out.println(String.valueOf(false)); // "false"
		System.out.println("" + false); // "false"
		
		
		
		
		
		
	}
	
}
