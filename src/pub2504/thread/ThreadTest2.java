package pub2504.thread;

public class ThreadTest2 {

	public static void main(String[] args) {
		
		new EvenThread().start();
		new OddThread().start();

		new EvenThread().start();
		new OddThread().start();
		
		new EvenThread().start();
		new OddThread().start();
		
		System.out.println("실행중인 쓰레드의 개수: " + Thread.activeCount());
		
	}
	
}
