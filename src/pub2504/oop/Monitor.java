package pub2504.oop;

// 모니터를 추상화
public class Monitor {

	private String name; // 제품명
	private int inch; // 화면크기
	private int price; // 가격

	public Monitor() {
	}

	public Monitor(String name, int inch, int price) {
		super();
		this.name = name;
		this.inch = inch;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
