package pub2504.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedTest1 {

	public static void main(String[] args) {
		
		File file = new File("C:\\pub2504\\files\\buffered.dat");
		
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		
		try {
			
			bos = new BufferedOutputStream(new FileOutputStream(file));
			
			long startTime = System.currentTimeMillis();
			
			// 1G byte 배열 생성 후 숫자 넣음
			byte[] byteArr = new byte[1024*1024*1024]; // 1G byte
			int byteArrLeng = byteArr.length;
			for(int i=0; i<byteArrLeng; i++) {
				byteArr[i] = (byte)i;
			}
			bos.write(byteArr);
			
			long endTime = System.currentTimeMillis();
			
			System.out.println("소요시간: " + (endTime-startTime) + "ms");
			
			bis = new BufferedInputStream(new FileInputStream(file));
			byte[] readArr = new byte[1024*1024*1024];
			bis.read(readArr);
			int readArrLeng = readArr.length;
			for(int i=0; i<readArrLeng; i++) {
				System.out.println(readArr[i]);
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}
	
}
