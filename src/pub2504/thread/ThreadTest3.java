package pub2504.thread;

public class ThreadTest3 {

	public static void main(String[] args) {
		
		// 홍길동의 계좌(HongThread의 hongAccount)와
		// 강감찬의 계좌(KangThread의 KangAccount)는
		// 서로 다른 객체이므로 동기화할 필요가 없음
		
		new HongThread().start();
		new KangThread().start();
		
	}
	
}
