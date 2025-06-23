package pub2504.excollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreMain {
	
	public static void main(String[] args) {
		// 3명의 이름, 국어, 영어, 수학 성적을 입력받아 출력
		// 홍길동은 국어 100점 영어 80점 수학 90점 총점 270점
		System.out.println("3명의 이름, 국어, 영어, 수학 점수를 입력해주세요 (형식: 이름 국어 영어 수학)");
		// 형식: 이름,국어,영어,수학으로 풀어보기
		
		Scanner sc = new Scanner(System.in);
		
		List<Student> stuList = new ArrayList<Student>();
		
		for(int i=0; i<3; i++) {
			stuList.add(
					new Student(sc.next(), 
					new Score(sc.nextInt(), sc.nextInt(), sc.nextInt()))
			);
		}
		
		for(Student student : stuList) {
			System.out.println(student);
		}
		
		sc.close();
	}

}
