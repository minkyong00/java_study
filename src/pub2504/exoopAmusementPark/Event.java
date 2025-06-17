package pub2504.exoopAmusementPark;

public class Event {

	private String name; // 이름(퍼레이드, 불꽃놀이..)
	private String type; // 타입(공연, 할인..)
	private String location; // 장소(광장, 중앙무대..)
	
	public Event() {
	}

	public Event(String name, String type, String location) {
		super();
		this.name = name;
		this.type = type;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "이벤트 이름: " + name + ", 타입: " + type + ", 장소: " + location;
	}
}
