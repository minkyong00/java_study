package pub2504.basic;

/*
 	오버로딩 (Overloading)
 	목적) 메소드명을 일원화
 	조건) 1. 동일한 클래스내에 선언된 메소드들 간에
 	     2. 반환타입이 같고
 	     3. 메소드명이 같고
 	     4. 파라미터리스트(개수, 순서, 타입) 중 하나라도 다름
*/

public class MethodOverloading {

	public static void main(String[] args) {
		
		printStr("Hello");
		printStr("Java", 3);
		printStr("Hello", "Java", 3);
		
	}
	
	static void printStr(String str) {
		System.out.println(str);
	}
	
	static void printStr(String str, int loopCount) {
		for(int i=0; i<loopCount; i++) {
			System.out.println(str);
		}
	}
	
	static void printStr(String str1, String str2, int loopCount) {
		for(int i=0; i<loopCount; i++) {
			System.out.println(str1 + ", " + str2);
		}
	}
	
}
