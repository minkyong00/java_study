package pub2504.exthread;

public class Order {

	private int id; // 주문번호
	private String name; // 음식이름
	private boolean isCooked; // 요리 완료 여부
	private boolean isDelivered; // 배달 완료 여부

	public Order(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Order(int id, String name, boolean isCooked, boolean isDelivered) {
		this.id = id;
		this.name = name;
		this.isCooked = false;
		this.isDelivered = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCooked() {
		return isCooked;
	}

	public void setCooked(boolean isCooked) {
		this.isCooked = isCooked;
	}

	public boolean isDelivered() {
		return isDelivered;
	}

	public void setDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + "]";
	}

}
