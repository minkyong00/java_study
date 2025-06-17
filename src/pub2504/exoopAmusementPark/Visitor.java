package pub2504.exoopAmusementPark;

public class Visitor {

	private String type; // 입장객 타입(일반, VIP..)
	private String name; // 이름
	private int age; // 나이
	
	public Visitor() {
	}

	public Visitor(String type, String name, int age) {
		super();
		this.type = type;
		this.name = name;
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "방문객 이름: " + name + ", 나이 : " + age + ", 타입: " + type;
	}
}
