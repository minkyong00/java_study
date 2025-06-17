package pub2504.oop;

// 본체를 추상화
public class Desktop {

	private String name;
	private int price;
	private String cpu;
	private int memory;

	public Desktop() {
	}

	public Desktop(String name, int price, String cpu, int memory) {
		super();
		this.name = name;
		this.price = price;
		this.cpu = cpu;
		this.memory = memory;
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

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

}
