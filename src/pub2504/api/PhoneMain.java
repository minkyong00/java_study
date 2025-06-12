package pub2504.api;

import java.util.Scanner;
import java.util.StringTokenizer;

public class PhoneMain {

	public static void main(String[] args) {
		// Scanner 5명 이름, 번호 입력
 		// '홍길동 010-1234-5678'
		// 출력 시에는 이름5개, 국번 5개, 앞자리5개, 뒷자리5개 각각 출력
		
		Scanner scanner = new Scanner(System.in);
		
		String[][] phoneArr = new String[5][4];
		
		int phoneArrLen = phoneArr.length;
		for(int i=0; i<phoneArrLen; i++) {
			String line = scanner.nextLine();
			
		}
		
		
		
		
		
//		for(String phone : phoneArr) {
//			StringTokenizer phoneSt = new StringTokenizer(phone, "- ");
//			
//			int phoneStLen = phoneSt.countTokens();
//			phoneTokenArr = new String[phoneStLen];
//			int phoneTokenArrLen = phoneTokenArr.length;
//			
//			while(phoneSt.hasMoreTokens()) {
//				
//				String phoneToken = phoneSt.nextToken();
//				
//				for(int i=0; i<phoneTokenArrLen; i++) {
//					phoneTokenArr[i] = phoneToken;
//				}
//				
//			}
//		}
		
		scanner.close();
	}
}
