package pub2504.api;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {

	public static void main(String[] args) {
		
		// 날짜/시간 표시 형식
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
		
		// 현재 날짜/시간을 표시 형식에 맞춰 문자열로 변환
		String dateStr = sdf.format(new Date());
		System.out.println(dateStr);
		
		
	}
}
