package pub2504.exoop3;

public class PFGradePolicy extends Enrollment implements GradePolicy {

	// 70점 이상이면 "PASS" 그렇지 않으면 "FAIL"
	@Override
	public String gradePolicy(int score) {
		if(score <= 70) return "PASS";
		else return "FAIL";
	}

}
