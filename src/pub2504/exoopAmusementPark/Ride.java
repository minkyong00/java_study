package pub2504.exoopAmusementPark;

public class Ride {

	private String name; // 이름
	private int rideTotalCount; // 놀이기구 총 이용가능한 인원
	private int duration; // 운행시간
	private int waitingTime; // 대기 시간
	
	public Ride() {
	}

	public Ride(String name, int rideTotalCount, int duration, int waitingTime) {
		super();
		this.name = name;
		this.rideTotalCount = rideTotalCount;
		this.duration = duration;
		this.waitingTime = waitingTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRideTotalCount() {
		return rideTotalCount;
	}

	public void setRideTotalCount(int rideTotalCount) {
		this.rideTotalCount = rideTotalCount;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}
	
	@Override
	public String toString() {
		return "놀이기구 이름: " + name + ", 이용가능한 인원 수: " + rideTotalCount 
				+ ", 운행시간: " + duration + ", 대기시간: " + waitingTime;
	}
	
}
