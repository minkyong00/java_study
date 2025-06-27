package pub2504.exthread;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LongThread extends Thread {

	// 문자열 입력받을때마다 inputString.log 파일에 날짜시간과 함께 출력
	// [2024/11/24 09:00:00] 안녕하세요!

	private String inputString; // 입력받은 문자열
	private String timeAndDate; // 문자열 입력했을 때의 날짜시간

	public LongThread() {
	}

	public LongThread(String timeAndDate) {
		this.timeAndDate = timeAndDate;
	}
	
	public LongThread(String inputString, String timeAndDate) {
		this.inputString = inputString;
		this.timeAndDate = timeAndDate;
	}

	@Override
	public void run() {

		FileWriter fw = null;
		Scanner sc = new Scanner(System.in);
		File file = new File("C:\\pub2504\\files\\inputString.log");
		
		try {
			fw = new FileWriter(file);
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		while (sc.hasNext()) {
			
			try {
				
				fw.write(timeAndDate + " ");
				fw.write(sc.next() + "\n");
				fw.flush();
				
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} finally {
				try {
					fw.close();
					sc.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
	}

	@Override
	public String toString() {
		return timeAndDate + inputString;
	}

}
