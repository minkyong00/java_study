package pub2504.exthread_1;

public class ThreeThread extends Thread {
	
	@Override
	public void run() {
		int i = 1;
		while (true) {
			System.out.println("3의 배수" + 3*i++);
			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

}