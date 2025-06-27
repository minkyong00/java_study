package pub2504.thread;

public class EvenThread extends Thread {

	private int i = 0;
	
	@Override
	public void run() {
		
		while(true) {
			System.out.println("EvenThread : " + i);
			i += 2;
			try {
				if(i==10) this.interrupt();
				Thread.sleep(2000);
			} catch (InterruptedException ie) {
				System.out.println("# # # EvenThread 종료됨! # # #");
				System.exit(0); // 정상 종료
			}
		}

	}
	
	
	
}
