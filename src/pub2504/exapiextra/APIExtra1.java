package pub2504.exapiextra;

import java.util.Scanner;

public class APIExtra1 {

	public static void main(String[] args) {
		//문자열을 한 줄 입력받아서 문자열의 길이를 출력
//		Scanner sc = new Scanner(System.in);
//		
//		String scStr = "";
//		
//		scStr = sc.next();
//		System.out.println(scStr + "의 문자열 길이 : " + scStr.length());
		
		System.out.println("문자열의 길이: " + Util.getLineText(1)[0].length());
		
	}
}
