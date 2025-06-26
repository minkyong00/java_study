package pub2504.exio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExData {

	public static void main(String[] args) {
		
		// "홍길동", 20, "010", '-', "1234", '-', "5678"
		DataOutputStream dos = null;
		DataInputStream dis = null;
		
		File file = new File("C:\\pub2504\\files\\dataStream.dat");
		
		try {
			
			dos = new DataOutputStream(new FileOutputStream(file));
			dos.writeUTF("홍길동");
			dos.writeInt(20);
			dos.writeUTF("010");
			dos.writeChars("-");
			dos.writeUTF("1234");
			dos.writeChars("-");
			dos.writeUTF("5678");

			dis = new DataInputStream(new FileInputStream(file));
			dis.readUTF();
			dis.readInt();
			dis.readUTF();
			dis.readChar();
			dis.readUTF();
			dis.readChar();
			dis.readUTF();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dis.close();
				dos.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}
}
