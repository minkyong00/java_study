package pub2504.exio;

public class KoreaVisitor {

	private String nation; // 국가
	private int num; // 등수
	private double visitor; // 방문자 수 
	private double growth; //성장률
	
	public KoreaVisitor() {
	}
	
	public KoreaVisitor(String nation, double visitor) {
		this.nation = nation;
		this.visitor = visitor;
	}
	
	public KoreaVisitor(String nation, double visitor, double growth) {
		this(nation, visitor);
		this.growth = growth;
	}

	public KoreaVisitor(String nation, int num, double visitor, double growth) {
		this(nation, visitor, growth);
		this.num = num;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getVisitor() {
		return visitor;
	}

	public void setVisitor(double visitor) {
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
