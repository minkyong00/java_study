package pub2504.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectTest2 {

	public static void main(String[] args) {
		
		Animal dog1 = new Dog("치와와", 4, "왈왈");
		Animal dog2 = new Dog("셰퍼드", 4, "멍멍");
		
		File file = new File("C:\\pub2504\\files\\object2.dat");
		
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		try {
			
			oos = new ObjectOutputStream(new FileOutputStream(file));
			
			oos.writeObject(dog1);
			oos.writeObject(dog2);
			oos.flush();
			
			ois = new ObjectInputStream(new FileInputStream(file));
			
			Animal d1 = (Dog)ois.readObject();
			Animal d2 = (Dog)ois.readObject();
			
			System.out.println(d1);
			System.out.println(d2);
			
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
