package pub2504.basic;

import java.util.Scanner;

public class ExArray4 {

	public static void main(String[] args) {
		// 학생 3명의 이름, 국어, 영어, 수학 점수를 키보드로 받아 총점, 평균 산출하여
		// 학생명, 국어, 영어, 수학, 총점, 평균 출력
//		String[][] studentArr = {
//				{"홍길동", "90", "80", "70"},	
//				{"강감찬", "80", "70", "60"},	
//				{"이순신", "60", "50", "40"}
//			};

		
		Scanner scanner = new Scanner(System.in);
		
		String[][] studentArr = new String[3][4];
		
//		System.out.println("학생 이름을 입력하세요");
		int studentArrLen = studentArr.length;
		int student0ArrLen = studentArr[0].length;
		System.out.println(studentArrLen);
		System.out.println(student0ArrLen);
		
		for(int i=0; i<studentArrLen; i++) {
			for(int j=0; j<student0ArrLen; j++) {
				studentArr[i][j] = scanner.next();
				System.out.println(studentArr[i][j]);
			}
		}
		
		
		
//		System.out.println("국어 점수를 입력하세요");
//		studentArr[0][1] = scanner.next();
//		studentArr[1][1] = scanner.next();
//		studentArr[2][1] = scanner.next();
//		
//		System.out.println("영어 점수를 입력하세요");
//		studentArr[0][2] = scanner.next();
//		studentArr[1][2] = scanner.next();
//		studentArr[2][2] = scanner.next();
//		
//		System.out.println("수학 점수를 입력하세요");
//		studentArr[0][3] = scanner.next();
//		studentArr[1][3] = scanner.next();
//		studentArr[2][3] = scanner.next();
		
		
//		for(String[] stuArr : studentArr) {
//			for(String student : stuArr) {
//				System.out.println(student);
//			}
//		}
		
		
		
		
		
		
		
		
		
		
		
	}
}
