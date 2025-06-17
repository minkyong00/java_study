package pub2504.oop;

/*
 	Composition (구성)
 	- PC는 제품명과 가격 정보가 있음
 	- PC는 Monitor와 Desktop과 Keyboard로 구성됨
 	- Monitor와 Desktop과 Keyboard는 PC를 구성하는 구성 요소 = 컴포넌트 (Component)
	- PC는 Monitor, Desktop, Keyboard를 가진다 (has a 관계)
	- PC객체가 생성되려면  Monitor객체와 Desktop객체와 Keyboard객체가 필요함
*/

// 개인용 컴퓨터를 추상화
public class PC {

	private String name;
	private double price;
	private Monitor monitor;
	private Desktop desktop;
	private Keyboard keyboard;
	
	public PC() {
	}

	public PC(Monitor monitor, Desktop desktop, Keyboard keyboard, String name, double price) {
		this.monitor = monitor;
		this.desktop = desktop;
		this.keyboard = keyboard;
		this.name = name;
		this.price = price;
	}


	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public Desktop getDesktop() {
		return desktop;
	}

	public void setDesktop(Desktop desktop) {
		this.desktop = desktop;
	}

	public Keyboard getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(Keyboard keyboard) {
		this.keyboard = keyboard;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	

} // class
