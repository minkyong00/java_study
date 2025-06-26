package pub2504.exio_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ExbyteStream {
	
	public static void main(String[] args) {
		// byte.dat파일에 byte하나 쓰고 읽어서 출력
		
		InputStream is = null;
		OutputStream os = null;
		
		File file = new File("C:\\pub2504\\files\\byte.dat");
		
		try {
			os = new FileOutputStream(file);
			os.write(65);
			os.flush();
			
			is = new FileInputStream(file);
			System.out.println((char)(is.read()));
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		
	} // main

} // class
