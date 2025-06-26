package pub2504.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectTest1 {

	public static void main(String[] args) {
		
		Person hong = new Person("홍길동", 20, "123456-1234567");
		Person kang = new Person("강감찬", 30, "234567-2345678");
		
		File file = new File("C:\\pub2504\\files\\object.dat");
		
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		try {
			
			// 파일에 객체를 바이트 단위로 출력하는 스트림
			oos = new ObjectOutputStream(new FileOutputStream(file));
			
			// 직렬화 (객체(메모리) -> 바이트스트림)
			oos.writeObject(hong);
			oos.writeObject(kang);
			oos.flush();
			
			// 파일에서 객체를 바이트 단위로 입력하는 스트림
			ois = new ObjectInputStream(new FileInputStream(file));
			
			// 역직렬화 (바이트스트림 -> 객체(메모리)
			// readObject는 반환타입이 Object이므로 Person으로 형변환해줌
			Person h = (Person)ois.readObject();
			System.out.println(h.getName() + ", " + h.getAge() + ", " + h.getSsn());
			Person k = (Person)ois.readObject();
			System.out.println(k.getName() + ", " + k.getAge() + ", " + k.getSsn());
			
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				ois.close();
				oos.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}
	
}
