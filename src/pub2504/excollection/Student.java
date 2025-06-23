package pub2504.excollection;

public class Student {

	private String name; // 이름
	private Score score; // 점수

	public Student() {
	}

	public Student(String name, Score score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return name + "은 국어 " + score.getKor() + "점 영어 " + score.getEng() + "점 수학 " + score.getMath() + "점 총점 "
				+ score.getSum() + "점";
	}

}
