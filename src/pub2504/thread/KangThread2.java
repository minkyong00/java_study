package pub2504.thread;

public class KangThread2 extends Thread {

	private Account2 kangAccount2;
	
	public KangThread2(Account2 account2) {
		this.kangAccount2 = account2;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			
			// 동기화 블럭 : KangThread2가 kangAccount2객체를 사용 중 일때는
			// 			   HongThread2가 hongAccount2객체를 사용하지 못하도록 동기화
//			synchronized (kangAccount2) {
//				kangAccount2.setMoney(kangAccount2.getMoney() + 500);
//			}
			
			// 동기화 출금 메소드 사용
			// 메소드 동기화 시 메소드 안 모든 객체가 동기화됨
			kangAccount2.deposit();
			
			System.out.println("강감찬의 계좌에 500원 입금!");
			System.out.println(kangAccount2 + "\n");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
	
}
