package pub2504.exmethod;

public class ExMethod5 {
	// 배열과 메서드 활용해서 3명의 국어, 영어, 수학, 총점, 평균을 출력
	// 데이터 : 3명의 학생명, 국어, 영어, 수학
	
	private static Student[] studentArr = {
		new Student("홍길동", 100, 90, 80),	
		new Student("강감찬", 90, 80, 70),	
		new Student("이순신", 90, 50, 60)	
	};
	
	public static void main(String[] args) {
		printStudentSorce(studentArr);
	}
	
	static void printStudentSorce(Student[] student) {
		int studentArrLeng = studentArr.length;
		for(Student stu : studentArr) {
			int kor = stu.kor;
			int eng = stu.eng;
			int math = stu.math;
			
			System.out.printf("%s의 국어 점수: %d, 영어 점수: %d, 수학 점수: %d, 총점: %d, 평균: %d\n",
					stu.name, kor, eng, math, kor+eng+math, (kor+eng+math)/studentArrLeng);
		}
	}
	
}
