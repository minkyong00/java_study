package pub2504.exio_1;

public class Score {

	private int kor;
	private int eng;
	private int math;

	public Score() {
	}

	public Score(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}
	
	@Override
	public String toString() {
		return "국어: " + kor + ", 영어: " + eng + ", 수학: " + math;
	}

}
