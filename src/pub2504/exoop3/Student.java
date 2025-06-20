package pub2504.exoop3;

public class Student extends User {
	// 학생의 정보 및 수강과목 정보를 관리하는 클래스
	private static Enrollment[] enrollment;

	public Student() {
	}

	public Student(int id, String name) {
		super(id, name);
	}
	
	

	
	@Override
	public void printInfo() {
		System.out.println(
				getName() + " 님의 성적/n"
				+ "과목: " + arrayEnrollment().getSubject().getSubjectName()
				+ "/ 점수: " + arrayEnrollment().getScore()
				+ "/ 학점: " 
		);
	}

	// 배열 순회
	private static Enrollment arrayEnrollment() {
		for(Enrollment en : enrollment) {
			return en;
		}
		return null;
	}
	
	

}
