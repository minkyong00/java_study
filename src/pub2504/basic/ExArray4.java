package pub2504.basic;

import java.util.Scanner;

public class ExArray4 {

	public static void main(String[] args) {
		// 학생 3명의 이름, 국어, 영어, 수학 점수를 키보드로 받아 총점, 평균 산출하여
		// 학생명, 국어, 영어, 수학, 총점, 평균 출력
		
		Scanner scanner = new Scanner(System.in);
		
		String[][] studentArr = new String[3][4];
		
		int studentArrLen = studentArr.length;
		int student0ArrLen = studentArr[0].length;
		int kor, eng, math, sum, avg;
		
		for(int i=0; i<studentArrLen; i++) {
			System.out.printf("%d번째 학생의 이름, 국어, 영어, 수학 점수를 입력하세요\n", i+1);
			
			for(int j=0; j<student0ArrLen; j++) {
				studentArr[i][j] = scanner.next();
			}
			
			kor = Integer.parseInt(studentArr[i][1]);
			eng = Integer.parseInt(studentArr[i][2]);
			math = Integer.parseInt(studentArr[i][3]);
			sum = kor + eng + math;
			avg = sum / 3;
			System.out.printf("%s의 국어는 %d점, 영어는 %d점, 수학은 %d점이고 총점은 %d, 평균은 %d점입니다!\n",
					studentArr[i][0], kor, eng, math, sum, avg);
		}		
		
		scanner.close();
		
	}
}