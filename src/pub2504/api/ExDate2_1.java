package pub2504.api;

import java.util.Calendar;
import java.util.Scanner;

public class ExDate2_1 {
   
   public static void main(String[] args) {
      
      System.out.println("달력을 표시할 년월을 6자리로 입력해 주세요!");
      
      Scanner scanner = new Scanner(System.in);
      String yearMonth = scanner.nextLine();
      
      Calendar cal = Calendar.getInstance();
      
      // 날짜 설정
      cal.set(
            Integer.parseInt(yearMonth.substring(0, 4)), // 년도 문자열4개를 정수로
            Integer.parseInt(yearMonth.substring(4)) - 1, // 월 문자열2개를 정수로
            1 // 1일
      );
      
      // 1일의 요일 숫자 (1 일, 2 월 ...)
      int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
      // 월의 마지막 날
      int lastDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
      
      System.out.println("일\t월\t화\t수\t목\t금\t토");
      
      // 요일값-1만큼 탭 만들기
      for (int i=1; i<dayOfWeek; i++) System.out.print("\t");
      
      for (int i=1; i<=lastDayOfMonth; i++) {
         System.out.print(i + "\t"); // 날짜 표시 (1일부터 말일까지)
         if ((dayOfWeek+(i-1))%7 == 0) System.out.println(); // 7개마다 줄바꿈
      }      
      
      scanner.close();
      
   } // main

} // class
