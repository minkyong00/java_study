package pub2504.exthread;


public class UpperThread extends Thread {

	// 대문자 65-90
	private int i;
	
	@Override
	public void run() {
		for(int i=65; i<91; i++) {
			System.out.println((char)i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
	}
	
}
