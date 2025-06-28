package pub2504.exthread;

import java.util.List;

public class DeliveryThread extends Thread {
	// 요리가 끝난 후 2초동안 배달을 하는 쓰레드
	// "[요리명] 요리 완료"가 출력될때까지 기다린 후 "[요리명] 배달 시작 "을
	// 출력한 후 2초간 sleep 후에 "[요리명] 배달 완료" 출력
	private List<Order> order;

	public DeliveryThread(List<Order> order) {
		this.order = order;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			Order o = order.get(i);
			synchronized (o) {
				while (!o.isCooked() && !o.isDelivered()) { // 요리가 완료되면 true로 옴, 요리 완료안되면(false)이면 기다림
					try {
						o.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				// 요리가 떡볶이면 배달 불가
				if (o.getName().equals("떡볶이")) {
					System.out.println("[주문번호 " + o.getId() + ", " + o.getName() + "]" + " 배달 불가!");
					o.setCooked(false); // 요리 다시 시작
					o.setDelivered(false); // 배달 종료
					synchronized (o) {
						o.notifyAll(); // 셰프 쓰레드에 알림
					}
				} else {
					System.out.println("[주문번호 " + o.getId() + ", " + o.getName() + "]" + " 배달 시작");
					o.setCooked(false); // 요리 다시 시작
					synchronized (o) {
						o.notifyAll(); // 셰프 쓰레드에 알림
					}
					try {
						Thread.sleep(2000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("[주문번호 " + o.getId() + ", " + o.getName() + "]" + " 배달 완료");
					o.setDelivered(false); // 배달 종료
				}
			}
		}
	}
}
