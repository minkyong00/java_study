package pub2504.exthread;

import java.util.List;

public class ChefThread extends Thread {
	// 3초동안 요리를 하는 쓰레드
	// "[요리명] 요리 시작"을 출력하고 3초간 sleep 후에 "[요리명] 요리 완료" 출력
	private List<Order> order;

	public ChefThread(List<Order> order) {
		this.order = order;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			Order o = order.get(i);
			synchronized (o) {
				while (o.isCooked()) { // 요리가 false이면 기다리지 않음
					try {
						o.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println("[주문번호 " + o.getId() + ", " + o.getName() + "] " + "요리 시작");
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("[주문번호 " + o.getId() + ", " + o.getName() + "] " + "요리 완료");
			o.setDelivered(true); // 배달 시작
			o.setCooked(true); // 배달할 요리 있음
			synchronized (o) {
				o.notifyAll(); // 배달 쓰레드에 알려줌
			}
		}
	}

}
