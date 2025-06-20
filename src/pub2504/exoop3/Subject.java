package pub2504.exoop3;

public class Subject {
	// 과목, 과목마다 학점 정책을 설정할 수 있음
	private String subjectName; // 과목
	private GradePolicy gradePolicy; // 정책

	public Subject() {
	}

	public Subject(String subjectName, GradePolicy gradePolicy) {
		super();
		this.subjectName = subjectName;
		this.gradePolicy = gradePolicy;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public GradePolicy getGradePolicy() {
		return gradePolicy;
	}

	public void setGradePolicy(GradePolicy gradePolicy) {
		this.gradePolicy = gradePolicy;
	}

}
