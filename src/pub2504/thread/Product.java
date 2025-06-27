package pub2504.thread;

// 제품
public class Product {

	// 제품명
	private String product;
	
	// 애플리케이션 설계패턴
	// produce, consume
	
	// 제품을 생산하는 메소드
	public synchronized void produce(String product) {
		// product가 null이 아닌 동안 계속 반복
		while(this.product != null) {
			try {
				wait(); // 제품이 소비될 때까지 대기
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		this.product = product;
		System.out.println("제품 생산 : " + product);
		notify(); // 제품을 소비하라고 알림
	} // product
	
	// 제품을 소비하는 메소드
	public synchronized String consume() {
		while(this.product==null) {
			try {
				wait(); // 생산할때까지 대기
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		String result = this.product;
		this.product = null;
		System.out.println("제품 소비: " + result);
		notify(); // 제품을 생산하라고 알림
		return result;
	} // consume
	
} // class
