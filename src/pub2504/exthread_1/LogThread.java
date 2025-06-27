package pub2504.exthread_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LogThread extends Thread {

	private Scanner scanner;
	private File logFile;
	private PrintWriter pw;
			
	LogThread() {
		this.scanner = new Scanner(System.in);
		this.logFile = new File("C:\\pub2504\\files\\inputstring.log");
		try {
			this.pw = new PrintWriter(this.logFile);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("[yyyy/MM/dd HH:mm:ss] ");
		
		System.out.println("파일에 저장하실 문자열을 입력해 주세요!");
		
		while (true) {
			pw.println(sdf.format(new Date()) + scanner.nextLine());
			pw.flush();
		}
		
	} // run
	
} // class















