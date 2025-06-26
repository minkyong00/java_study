package pub2504.exio_1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EXIO1 {
	
	public static void main(String[] args) {
		// gimi.txt 읽어서 화면에 출력
		
		FileReader fe = null;
		
		File file = new File("C:\\pub2504\\eclipse_workspace\\pub2504\\src\\pub2504\\exio\\gimi.txt");
		
		try {
			
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
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}

}
