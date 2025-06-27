package pub2504.exthread;

public class ExThread1 {
	// 3의 배수, 5의 배수 무한히 화면에 출력
	public static void main(String[] args) {
		
		new ThreeThread().start();
		new FiveThread().start();
		
	}
	
}
