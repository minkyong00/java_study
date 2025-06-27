package pub2504.exthread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExThread3 {

	public static void main(String[] args) {
		
		// 문자열 입력받을때마다 inputString.log 파일에 날짜시간과 함께 출력
		// [2024/11/24 09:00:00] 안녕하세요!
		
		System.out.println("inputString.log 파일에 들어갈 문자열을 입력해주세요!");
		
		SimpleDateFormat sdf = new SimpleDateFormat("[yyyy/MM/dd HH:mm:ss]");
		String time = sdf.format(new Date());
		
		Thread longThread = new LongThread(time);

		longThread.start();
		
	}
	
}
