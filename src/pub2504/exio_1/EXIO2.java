package pub2504.exio_1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EXIO2 {

	public static void main(String[] args) {
		// scanner를 통해 파일명과 문자열을 입력받아 입력받은 파일명.txt에 문자열을 저장
		Scanner sc = new Scanner(System.in);
		
		FileWriter fw = null;
		FileReader fe = null;
		
		System.out.println("파일명을 입력해주세요");
		File file = new File("C:\\pub2504\\files\\" + sc.nextLine() + ".txt");
		
		try {
			
			fw = new FileWriter(file);
			System.out.println("파일에 저장할 문자열을 입력해주세요");
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
				sc.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}
}
