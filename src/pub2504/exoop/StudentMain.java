package pub2504.exoop;

public class StudentMain {

	public static void main(String[] args) {
		
		// 3명의 이름, 국어, 영어, 수학, 총점, 평균ㄴ
		// 중복된 코드는 기능별로 메서드, 한번 쓰는 변수는 사용을 자제
		printStudent(makeStudent("홍길동", 100, 90, 80));
		printStudent(makeStudent("강감찬", 100, 90, 80));
		printStudent(makeStudent("장보고", 100, 90, 80));
	}	
	
	private static Student makeStudent(String name, int kor, int eng, int math) {
		Student studentObj = new Student(name);
		Student.Score ScoreObj = studentObj.new Score(kor, eng, math);
		return studentObj;
	}
	
	private static void printStudent(Student studentObj) {
		System.out.println(studentObj);
	}
	
}