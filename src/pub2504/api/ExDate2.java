package pub2504.api;

import java.util.Calendar;
import java.util.Scanner;

public class ExDate2 {

	public static void main(String[] args) {
		// 년도 4자리 입력받아서 1월부터 12월까지
		// 년도 4자리와 월 2자리를 입력받아 해당 년월을 달력으로 출력
		Calendar cal = Calendar.getInstance();
//		
		int year = 0;
		int month = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("년도 4자리와 월 2자리를 입력하세요");
		year = sc.nextInt();
		month = sc.nextInt();
		
//		System.out.printf("%d, %d", year, month);

		// 입력한 년, 월의 1일
		cal.set(year, month, 1);
		System.out.println(cal.get(Calendar.DAY_OF_WEEK)); // 6, 금요일
		System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH)); // 13
		
		
		sc.close();
	}
}
