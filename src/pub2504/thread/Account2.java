package pub2504.thread;

public class Account2 {

	private String name;
	private int money;

	public Account2() {
	}

	public Account2(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Account2 [name=" + name + ", money=" + money + "]";
	}
	
	// 동기화 출금 메소드
	public synchronized void withdraw() {
		this.setMoney(this.getMoney() - 500);
	}

	// 동기화 입금 메소드
	public synchronized void deposit() {
		this.setMoney(this.getMoney() + 500);
	}

}
