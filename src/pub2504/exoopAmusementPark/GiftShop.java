package pub2504.exoopAmusementPark;

public class GiftShop {

	private String itemName; // 판매하는 아이템 이름
	private String location; // 장소
	private int price; // 가격
	
	public GiftShop() {
	}

	public GiftShop(String itemName, String location, int price) {
		super();
		this.itemName = itemName;
		this.location = location;
		this.price = price;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "기프트샵 아이템 이름: " + itemName + ", 가격: " + price + ", 장소: " + location;
	}
	
}
