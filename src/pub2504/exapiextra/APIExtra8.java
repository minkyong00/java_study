package pub2504.exapiextra;

import java.util.Scanner;

public class APIExtra8 {

	public static void main(String[] args) {
		// 영문 대소문자, 숫자, 기호를 포함한 문자열을 입력하면 대문자, 소문자, 숫자, 기호의 개수를 출력
		Scanner sc = new Scanner(System.in);
		
		String str = "";
		int[] countArr = new int[4];
		
		System.out.println("영문 대소문자, 숫자, 기호를 포함한 문자열을 입력하세요");
		str = sc.nextLine();
		
		int strLeng = str.length();
		for(int i=0; i<strLeng; i++) {
			byte b = (byte)str.charAt(i);
			if(b<=90 && 65<=b) {
				countArr[0]++;
			} else if(b<=122 && 97<=b) {
				countArr[1]++;
			} else if(b<=57 && 48<=b) {
				countArr[2]++;
			} else if(47<=b && 33<=b || 64<=b && 58<=b || 96<=b && 91<=b || 126<=b && 123<=b) {
				countArr[3]++;
			}
		}
		
		System.out.printf("대문자의 개수 : %d, 소문자의 개수 : %d, 숫자의 개수 : %d, 기호의 개수 : %d",
				countArr[0], countArr[1], countArr[2], countArr[3]);
		
	}
}
