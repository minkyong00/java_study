package pub2504.exio;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ExCharStream {

	public static void main(String[] args) {
		// name.txt 파일 생성하여 파일에 본인의 이름 쓰고 읽어서 출력
		
		Writer writer = null;
		Reader reader = null;
		
		File file = new File("C:\\pub2504\\files\\name.txt");
		
		try {
			writer = new FileWriter(file);
			writer.write("김민경");
			writer.flush();
			
			reader = new FileReader(file);
			int count = (int) file.length();
			char[] charArr = new char[count];
			for(int i=0; i<count; i++) {
				charArr[i] = (char)(reader.read());
			}
			
			for(char c : charArr) {
				System.out.printf("%c", c);
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	} //main
} // class
