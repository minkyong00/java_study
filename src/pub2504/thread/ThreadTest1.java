package pub2504.thread;

public class ThreadTest1 {

	public static void main(String[] args) {
		
		Thread t = new NumberPrintThread();
		t.start();
		
	}
	
}
