package pub2504.exoop;

public class Case {

	private String type;
	private String brand;
	private int price;

	public Case() {
	}

	public Case(String type, String brand, int price) {
		super();
		this.type = type;
		this.brand = brand;
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	@Override
	public String toString() {
		return "타입: " + type + ", 브랜드: " + brand + ", 가격: " + price;
	}

}
