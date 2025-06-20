package pub2504.exoop3;

public class Enrollment {
	// 수강내역, 학생이 수강한 과목과 점수를 저장
	private int score;
	private User student;
	private Subject subject;

	public Enrollment() {
	}

	public Enrollment(User student, Subject subject, int score) {
		this.student = student;
		this.subject = subject;
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}
