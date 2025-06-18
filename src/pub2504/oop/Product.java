package pub2504.oop;

// 제품 추상화
public class Product {

	String company; // 제조회사명
	String name; // 제품명
	int price; // 가격
	
	
	public Product(String company, String name, int price) {
		super();
		this.company = company;
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "[회사명: " + company + ", 제품명: " + name + ", 가격: " + price;
	}
	
}
