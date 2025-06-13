package pub2504.exapiextra;

import java.util.Scanner;

public class APIExtra3 {

	public static void main(String[] args) {
		// 문자 5개를 입력하면 3번째 입력한 문자의 아스키코드값을 출력
		Scanner sc = new Scanner(System.in);
		
		String[] arr = new String[5];
		char[] carr = new char[5];
		int arrLeng = arr.length;
		for(int i=0; i<arrLeng; i++) {
			arr[i] = sc.nextLine();
		}
		for(int i=0; i<arrLeng; i++) {
			carr[i] = arr[i].charAt(i);
		}
		for(char ch : carr) {
			byte b = (byte)ch;
			System.out.println(b);
		}
	}
}
