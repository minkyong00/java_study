package pub2504.gui;

/*

[{"sid": "1", "sname": "홍길동", "kor": 100, "math": 90, "eng": 80},
       {"sid": "2", "sname": "강감찬", "kor": 90, "math": 80, "eng": 70},
       {"sid": "3", "sname": "이순신", "kor": 80, "math": 70, "eng": 60}]  

*/

public class Score {

	private int kor;
	private int math;
	private int eng;

	public Score() {
	}

	public Score(int kor, int math, int eng) {
		this.kor = kor;
		this.math = math;
		this.eng = eng;
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
		return "Score [kor=" + kor + ", math=" + math + ", eng=" + eng + "]";
	}

}
