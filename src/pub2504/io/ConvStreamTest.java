package pub2504.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class ConvStreamTest {

	public static void main(String[] args) {
		
		OutputStream os = null;
		Writer writer = null;
		InputStream is = null;
		Reader reader = null;
		
		try {
			
			File file = new File("C:\\pub2504\\files\\file3.txt");
			
			os = new FileOutputStream(file);
			
			// OutPutStreamWriter을 Writer로 변환하는 변환스트림
			// 바이트단위 출력스트림을 문자단위 출력스트림으로 변환
			writer = new OutputStreamWriter(os);
			writer.write(65); // A
			writer.flush();
			
			is = new FileInputStream(file);
			
			// InputStream을 Reader로 변환하는 변환스트림
			// 바이트단위 입력스트림을 문자단위 입력스트림으로 변환
			reader = new InputStreamReader(is);
			System.out.println((char)reader.read());
			
			
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			// finally에서는 모든 스트림을 반드시 닫는다!
			// 스트림 닫는 순서는 사용한 순서의 반대
		} finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}
}
