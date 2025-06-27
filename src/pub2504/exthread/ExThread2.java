package pub2504.exthread;

public class ExThread2 {

	public static void main(String[] args) {
		
		Thread upperThread = new UpperThread();
		Thread lowerThread = new LowerThread();
		
		upperThread.start();
		lowerThread.start();
		
		try {
			upperThread.join(1000);
			lowerThread.join(1000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
	}
	
}
