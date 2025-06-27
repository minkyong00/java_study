package pub2504.exthread;

public class LowerThread extends Thread {

	// 소문자 97-122
	private int i;
	
	@Override
	public void run() {
		for(int i=97; i<123; i++) {
			System.out.println((char)i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
	}
}

