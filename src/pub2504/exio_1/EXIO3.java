package pub2504.exio_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EXIO3 {
	
	public static void main(String[] args) {
		// scanner를 통해 학생 3명 이름, 국어, 영어, 수학 입력받아 student.dat에 바이트로 저장하고 읽어서 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학생 3명의 이름과 국어, 영어, 수학 점수를 입력하세요");
		List<Student> studentList = Arrays.asList(
				new Student(sc.next(), new Score(sc.nextInt(), sc.nextInt(), sc.nextInt())),
				new Student(sc.next(), new Score(sc.nextInt(), sc.nextInt(), sc.nextInt())),
				new Student(sc.next(), new Score(sc.nextInt(), sc.nextInt(), sc.nextInt()))
		);
//		System.out.println(studentList);
		
		
		FileOutputStream fos = null;
		FileInputStream fis = null;
		
		File file = new File("C:\\pub2504\\files\\student.dat");
		
		try {
			
			fos = new FileOutputStream(file);
			for(Student student : studentList) {
				fos.write(student.toString().getBytes());
			}
			fos.flush();
			
			fis = new FileInputStream(file);
			int fileLeng = (int) file.length();
			char[] charArr = new char[3];
			for(Student student : studentList) {
				System.out.println(fis.read(student.toString().getBytes()));
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
				sc.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		
	} // main

} // class
