package pub2504.thread;

public class HongThread2 extends Thread {

	private Account2 hongAccount2;
	
	public HongThread2(Account2 account2) {
		this.hongAccount2 = account2;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			
			// 동기화 블럭 : HongThread2가 hongAccount2객체를 사용 중 일때는
			// 			   KangThread2가 kangAccount2객체를 사용하지 못하도록 동기화
//			synchronized (hongAccount2) {
//				hongAccount2.setMoney(hongAccount2.getMoney() - 500);
//			}
			
			// 동기화 메소드 사용
			hongAccount2.withdraw();
			
			System.out.println("홍길동의 계좌에서 500원 출금!");
			System.out.println(hongAccount2 + "\n");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
	
}
