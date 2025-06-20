package pub2504.exoop;

public class Student {

	// has a 관계
	// 멤버변수들은 특별한 이유가 없으면 private으로 만들기
	// getter, setter
	private String name; // 이름
	private Score score; // 성적

	public Student() {
	}

	public Student(String name) {
		this.name = name;
	}

	public Student(String name, Score score) {
		this(name);
		this.score = score;
	}


	class Score {
		private int kor;
		private int eng;
		private int math;
		private int sum;
		private int avg;

		public Score() {
		}

		public Score(int kor, int eng, int math) {
			this.kor = kor;
			this.eng = eng;
			this.math = math;
			this.sum = kor + eng + math;
			this.avg = this.sum / 3;
		}

		public int getKor() {
			return kor;
		}

		public void setKor(int kor) {
			this.kor = kor;
		}

		public int getEng() {
			return eng;
		}

		public void setEng(int eng) {
			this.eng = eng;
		}

		public int getMath() {
			return math;
		}

		public void setMath(int math) {
			this.math = math;
		}

		public int getSum() {
			return sum;
		}

		public void setSum(int sum) {
			this.sum = sum;
		}

		public int getAvg() {
			return avg;
		}

		public void setAvg(int avg) {
			this.avg = avg;
		}

	} // Score
	
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
		return name + "님의 국어점수: " + score.kor + ", 영어점수: " + score.eng + ", 수학점수:"
				+ score.math + ", 총점: " + score.getSum() + ", 평균: " + score.getAvg();
	}

} // Student
