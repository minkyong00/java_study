package pub2504.api;

import java.util.Calendar;
import java.util.TimeZone;

public class ExDate1 {

	public static void main(String[] args) {
		// 한국, 영국, 미국, 호주
		Calendar cal = Calendar.getInstance();
		
		
		// 서울
		cal.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
		printDate("한국 서울", cal);
		
		// 호주
		cal.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
		printDate("호주 시드니", cal);
		
		// 영국
		cal.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		printDate("영국 런던", cal);
		
		// 미국
		cal.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
		printDate("미국 LA", cal);
	}
	
	   public static void printDate(String name, Calendar cal) {
		      System.out.println(
		            name + "은 지금 " + cal.get(Calendar.YEAR) + "년 " 
		            + (cal.get(Calendar.MONTH)+1) + "월 "
		            + cal.get(Calendar.DAY_OF_MONTH) + "일 "
		            + (cal.get(Calendar.AM_PM)==0 ? "오전 " : "오후 ")
		            + cal.get(Calendar.HOUR) + "시 "
		            + cal.get(Calendar.MINUTE) + "분 "
		            + cal.get(Calendar.SECOND) + "초 입니다!"
		      );      
		   }
}
