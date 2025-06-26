package pub2504.exio_1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExConvBufferStream {

	public static void main(String[] args) {
		// scanner 입력받은 문자열을 scanner1.txt에 쓰고 읽어서 출력
		System.out.println("scanner1.txt에 쓰고 싶은 문자열을 입력하세요");
		Scanner sc = new Scanner(System.in);
		
		FileWriter fw = null;
		FileReader fe = null;
		
		File file = new File("C:\\pub2504\\files\\scanner1.txt");
		
		try {
			
			fw = new FileWriter(file);
			fw.write(sc.nextLine());
			fw.flush();
			
			fe = new FileReader(file);
			int fileLeng = (int) file.length();
			char[] charArr = new char[fileLeng];
			for(int i=0; i<fileLeng; i++) {
				charArr[i] = (char)fe.read();
			}
			
			for(char c : charArr) {
				System.out.printf("%c", c);
			}
			
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fe.close();
				fw.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			sc.close();
		}
		
		
	}// main
} // class
