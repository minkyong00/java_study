package pub2504.exthread_1;

public class ExThread4 {

	public static void main(String[] args) {
		
		TVFactory tvFactory = new TVFactory(100);
		
		new ProducerThread(tvFactory).start();
		new ConsumerThread(tvFactory).start();
		
	} // main
	
} // class











