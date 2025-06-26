package pub2504.io;

import java.io.Serializable;

public class Animal implements Serializable {

	private static final long serialVersionUID = 5646454123546354L;

	private String name;
	private int legCount;

	public Animal() {
	}

	public Animal(String name, int legCount) {
		this.name = name;
		this.legCount = legCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLegCount() {
		return legCount;
	}

	public void setLegCount(int legCount) {
		this.legCount = legCount;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", legCount=" + legCount + "]";
	}

}
