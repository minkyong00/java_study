package pub2504.exio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class ExPrint {

	public static void main(String[] args) {
		// 1개의 바이트를 printStream을 통해 출력, 1개의 문자를 printWriter를 통해 출력

		PrintStream ps = null;
		PrintWriter pw = null;
		
		File file = new File("C:\\pub2504\\files\\printStream.dat");
		File file2 = new File("C:\\pub2504\\files\\printWriter.txt");
		
		try {
			
			ps = new PrintStream(new FileOutputStream(file), true);
			ps.print(1);
			
			pw = new PrintWriter(new FileWriter(file2), true);
			pw.print("1");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
			ps.close();
		}
		
	}
	
}
