package pub2504.excollection;

public class Score {

	private int kor; // 국어
	private int eng; // 영어
	private int math; // 수학
	private int sum; // 국어, 영어, 수학의 총점

	public Score() {
	}

	public Score(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public Score(int kor, int eng, int math, int sum) {
		this(kor, eng, math);
		this.sum = sum;
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
		return kor + eng + math;
	}
	
}
