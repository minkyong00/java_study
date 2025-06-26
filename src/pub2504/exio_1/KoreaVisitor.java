package pub2504.exio_1;

public class KoreaVisitor {

	private String nation; // 국가
	private String date; // 날짜
	private int visitor; // 방문자 수
	private double growth; // 성장률

	public KoreaVisitor() {
	}

	public KoreaVisitor(String nation, int visitor) {
		this.nation = nation;
		this.visitor = visitor;
	}

	public KoreaVisitor(String nation, int visitor, double growth) {
		this(nation, visitor);
		this.growth = growth;
	}

	public KoreaVisitor(String nation, String date, int visitor, double growth) {
		this(nation, visitor, growth);
		this.date = date;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getVisitor() {
		return visitor;
	}

	public void setVisitor(int visitor) {
		this.visitor = visitor;
	}

	public double getGrowth() {
		return growth;
	}

	public void setGrowth(double growth) {
		this.growth = growth;
	}

	@Override
	public String toString() {
		return nation + visitor;
	}
}
