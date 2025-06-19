package pub2504.oop;

public abstract class AbstractPrinter implements IPrinter, Cloneable {

	String sort; // 종류
	String company; // 제조사
	String name; // 이름
	int price; // 가격
	
	public AbstractPrinter() {
	}

	public AbstractPrinter(String sort, String company, String name, int price) {
		this.sort = sort;
		this.company = company;
		this.name = name;
		this.price = price;
	}

	@Override
	public void turnOn() {
		System.out.println(name + "프린터의 전원을 켜다!");
	}
	
	@Override
	public abstract void print(); // 아직 어떻게 구현할 지 모를때 추상메소드로 구현
	
	@Override
	public void turnOff() {
		System.out.println(name + "프린터의 전원을 끄다!");
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
} // class
