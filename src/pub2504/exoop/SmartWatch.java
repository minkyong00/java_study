package pub2504.exoop;

public class SmartWatch {

	private String brand;
	private int price;
	private String inch;
	private String generation;

	public SmartWatch() {
	}

	public SmartWatch(String brand, int price, String inch, String generation) {
		super();
		this.brand = brand;
		this.price = price;
		this.inch = inch;
		this.generation = generation;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getInch() {
		return inch;
	}

	public void setInch(String inch) {
		this.inch = inch;
	}

	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

	@Override
	public String toString() {
		return "화면크기: " + inch + ", 브랜드: " + brand + ", 가격: " + price + ", 세대: " + generation;
	}
}
