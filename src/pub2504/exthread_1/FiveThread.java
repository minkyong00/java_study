package pub2504.exthread_1;

public class FiveThread extends Thread {
	
	@Override
	public void run() {
		int i = 1;
		while (true) {
			System.out.println("5의 배수" + 5*i++);
			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

}
