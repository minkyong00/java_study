package pub2504.thread;

public class KangThread extends Thread {

	private Account kangAccount;
	
	public KangThread() {
		this.kangAccount = new Account("강감찬계좌", 0);
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			kangAccount.setMoney(kangAccount.getMoney() + 1000);
			System.out.println("강감찬의 계좌에 1000원 입금!");
			System.out.println(kangAccount + "\n");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
	
}
