package pub2504.exoop3;

public class BasicGradePolicy extends Enrollment implements GradePolicy {

	@Override
	public String gradePolicy(int score) {
		if(score <= 90) return "A";
		else if(score <= 80) return "B";
		else if(score <= 70) return "C";
		else if(score <= 60) return "D";
		else return "F";
	}

}
