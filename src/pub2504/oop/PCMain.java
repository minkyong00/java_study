package pub2504.oop;

public class PCMain {

	public static void main(String[] args) {
		
		// PC의 멤버변수들 (=구성요소 =컴포넌트)
		Monitor monitor = new Monitor("삼송UHD슈퍼잘보임", 1000, 30);
		Desktop desktop = new Desktop("아수스", 2000, "I9", 16);
		Keyboard keyboard = new Keyboard("앱코", 500, "기계식", 108);
		
		// PC 객체 생성
		PC pc = new PC(monitor, desktop, keyboard, "삼송매직스테이션", 5000);
		
		System.out.println(pc.getMonitor().getName());
		System.out.println(pc.getDesktop().getName());
		System.out.println(pc.getKeyboard().getName());
		System.out.println(pc.getName());
		System.out.println(pc.getPrice());
		
		// 실습 : PC의 가격은 Monitor와 Desktop과 Keyboard 가격 합의 1.5배로 함
		//		PC의 가격을 출력
		pc.setPrice((pc.getMonitor().getPrice() + pc.getDesktop().getPrice()
				      + pc.getKeyboard().getPrice()) * 1.5);
		System.out.println(pc.getPrice());
		
		// NullPointerException : 참조값이 없는데 참조하려 함 (= 메모리에 없는데 가져오려 함)
//		pc = null;
//		System.out.println(pc.getPrice()); 
		
	}
}
