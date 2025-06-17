package pub2504.exoop;

public class Charger {

	private String type;
	private int price;
	private String brand;

	public Charger() {
	}

	public Charger(String type, int price, String brand) {
		super();
		this.type = type;
		this.price = price;
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "타입: " + type + ", 브랜드: " + brand + ", 가격: " + price;
	}
}
