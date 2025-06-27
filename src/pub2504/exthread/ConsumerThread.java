package pub2504.exthread;

import java.util.List;

public class ConsumerThread extends Thread {
	// ConsumerThread는 매초 랜덤하게 3~8대의 TV를 판매한다고 할때
	
private List<TVFactory> tvFactory;
	
	public ConsumerThread() {
	}


	public ConsumerThread(List<TVFactory> tvFactory) {
		this.tvFactory = tvFactory;
	}

	@Override
	public void run() {
		while(tvFactory.isEmpty()) {
			synchronized (tvFactory) {
				try {
					wait();
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
//				for(int i=0; i<(Math.random()*5)+3)
				tvFactory.remove(tvFactory);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		}
	
	}
	
}
