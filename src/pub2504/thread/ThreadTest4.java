package pub2504.thread;

public class ThreadTest4 {

	public static void main(String[] args) {
		
		// 공용 계좌 생성
		Account2 account2 = new Account2("커플계좌", 0);
		
		// 계좌를 하나만 만들어서 두 쓰레드에 공유시킴
		new HongThread2(account2).start();
		new KangThread2(account2).start();
		
		try {
			Thread.sleep(12000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		System.out.println("최종계좌 잔액 : " + account2);

	}
	
}
