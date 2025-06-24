package pub2504.excollection;

public class Card {

	private Integer number; // 숫자(A, 2, 3 ... 10, J, Q, K)
	private String pattern; // 무늬(하트, 클로버, 다이아몬드, 스페이드)

	public Card() {
	}

	public Card(Integer number, String pattern) {
		this.number = number;
		this.pattern = pattern;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public String toString() {
		return pattern + number;
	}
}
