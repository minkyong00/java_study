package pub2504.exthread;

import java.util.ArrayList;
import java.util.List;

public class ProducerThread extends Thread {
	// ProducerThread는 매초 랜덤하게 5~10대의 TV를 생산
	
	private List<TVFactory> tvFactory;
	
	public ProducerThread() {
	}


	public ProducerThread(List<TVFactory> tvFactory) {
		this.tvFactory = tvFactory;
	}


	@Override
	public void run() {
		List<TVFactory> tvFactory = new ArrayList<TVFactory>();
		
		while(!tvFactory.isEmpty()) {
			synchronized (tvFactory) {
				try {
					wait();
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
				
				for(int i=0; i<(Math.random()*5)+5; i++) {
					tvFactory.add(new TVFactory("삼성", "LCD", "메인보드"));
				}
			
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
				System.out.println("제품 생산: " + tvFactory);
				notify();
			}
		}
	}
	
	
}
