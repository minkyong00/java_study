package pub2504.exthread;

public class ThreeThread extends Thread {

	private int i = 0;

	@Override
	public void run() {
		while(true) {
			i++;
			if(i%3==0) {
				System.out.println("3의 배수: " + i);
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
	
}
