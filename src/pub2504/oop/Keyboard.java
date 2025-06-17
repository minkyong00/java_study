package pub2504.oop;

// 키보드를 추상화
public class Keyboard {

	private String name;
	private int price;
	private String type; // 타입 (기계식, 전자식 ...)
	private int keyCount; // 키 개수

	public Keyboard() {
	}

	public Keyboard(String name, int price, String type, int keyCount) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
		this.keyCount = keyCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getKeyCount() {
		return keyCount;
	}

	public void setKeyCount(int keyCount) {
		this.keyCount = keyCount;
	}

}
