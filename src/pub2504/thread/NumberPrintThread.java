package pub2504.thread;

public class NumberPrintThread extends Thread {

	@Override
	public void run() {
		
		for(int i=1; i<6; i++) {
			
			System.out.println(i);
			
			System.out.println("현재 쓰레드 그룹에서 활동중인 쓰레드의 개수: " + Thread.activeCount());
			System.out.println("현재 실행중이 쓰레드 : " + Thread.currentThread());
			System.out.println("현재 쓰레드 아이디: " + this.getId());
			System.out.println("현재 쓰레드 이름 : " + this.getName());
			System.out.println("현재 쓰레드 우선순위 : " + this.getPriority());
			System.out.println("현재 쓰레드 상태 : " + this.getState());
			System.out.println("현재 쓰레드 그룹명 : " + this.getThreadGroup().getName());
			System.out.println("현재 쓰레드가 활동중인지 : " + this.isAlive());
			System.out.println("현재 쓰레드가 데몬쓰레드인지 : " + this.isDaemon());
			System.out.println("현재 쓰레드가 인터럽트 되엇는지 : " + this.isInterrupted());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			
		}
		
	}
	
}
