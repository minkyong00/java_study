package pub2504.api;

/*
 	String은 불변(immutable) : 한번 메모리에 생성된 문자열은 변할 수 없음
 	그러므로 문자열 접합 연산을 많이 하면 불필요한 문자열들이 메모리에 많이 생김
 	이를 방지하기 위해 자바에서는 StringBuffer와 StringVBuilder를 제공함
 	 1) StringBuffer는 스레드에 안전하지만 속도가 StringBuilder보다 느림
 	 2) StringBuilder는 속도가 StringBuffer보다 빠르지만 스레드에 안전하지 않음
 	 그러므로 멀티스레드 환경에서는 StringBuffer를 사용하고 단일스레드 환경에서는 StringBuilder를 사용함
*/

public class StringBuliderTest {

	public static void main(String[] args) {
		
		StringBuilder sb1 = new StringBuilder();
		
		System.out.println(sb1.capacity()); // 기본 16개 버퍼 생성
		
		sb1.append("h");
		sb1.append("e");
		sb1.append("l");
		sb1.append("l");
		sb1.append("o");
		sb1.append(" ");
		sb1.append("j");
		sb1.append("a");
		sb1.append("v");
		sb1.append("a");
		
		System.out.println(sb1.capacity()); // 버퍼의 크기 : 16
		System.out.println(sb1.length()); // 문자의 개수 : 10
		
		// 버퍼를 문자열로 변환
		String str1 = sb1.toString();
		
		StringBuilder sb2 = new StringBuilder("안녕하세요 자바!");
		
		System.out.println(sb2.charAt(2)); // 하
		
		sb2.delete(2, 5); 
		System.out.println(sb2); // 안녕 자바!
		
		sb2.ensureCapacity(50); // 최소 50개 이상의 버퍼를 확보
		System.out.println(sb2.capacity()); // 52
		
		sb2.trimToSize(); // 문자가 없는 버퍼 제거
		System.out.println(sb2.capacity()); // 6
	
		System.out.println(sb2.indexOf("자바")); // 3
		
		StringBuilder sb3 = new StringBuilder("Java Java Java");
		
		// 인덱스5부터 java문자열이 처음 나오는 인덱스
		System.out.println(sb3.indexOf("Java", 5)); // 5
		System.out.println(sb3.insert(5, "Hi")); // Java HiJava Java
		System.out.println(sb3.lastIndexOf("Java")); // 12
		System.out.println(sb3.length()); // 16
		System.out.println(sb3.replace(5, 7, "Hello")); // Java HelloJava Java
		System.out.println(sb3.reverse()); // avaJ avaJolleH avaJ
		
		sb3.setCharAt(0, 'J');
		System.out.println(sb3); // JvaJ avaJolleH avaJ
		
		System.out.println(sb3.substring(5)); // avaJolleH avaJ
		System.out.println(sb3.substring(5, 9)); // avaJ
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
