package pub2504.exoopAmusementPark;

import java.util.Arrays;

public class AmusementPark {
	// 놀이공원
	private String name; // 이름
	private String location; //위치
	private String openTime; // 개장시간
	private String endTime; // 폐장시간
	private Ticket ticket; 
	private Visitor[] visitor;
	private Ride[] ride;
	private Event[] event;
	private GiftShop giftShop;
	
	public AmusementPark() {
	}

	public AmusementPark(String name, String location, String openTime, String endTime, Ticket ticket,
			Visitor[] visitor, Ride[] ride, Event[] event, GiftShop giftShop) {
		super();
		this.name = name;
		this.location = location;
		this.openTime = openTime;
		this.endTime = endTime;
		this.ticket = ticket;
		this.visitor = visitor;
		this.ride = ride;
		this.event = event;
		this.giftShop = giftShop;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Visitor[] getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor[] visitor) {
		this.visitor = visitor;
	}

	public Ride[] getRide() {
		return ride;
	}

	public void setRide(Ride[] ride) {
		this.ride = ride;
	}

	public Event[] getEvent() {
		return event;
	}

	public void setEvent(Event[] event) {
		this.event = event;
	}

	public GiftShop getGiftShop() {
		return giftShop;
	}

	public void setGiftShop(GiftShop giftShop) {
		this.giftShop = giftShop;
	}
	
	@Override
	public String toString() {
		return "놀이공원 이름: " + name + ", 장소: " + location + ", 개장시간: " + openTime
				+ ", 폐장시간: " + endTime + ",\n 티켓: " + getTicket().toString()
				+ ",\n 방문객: " + Arrays.toString(visitor) + ",\n 놀이기구: " + Arrays.toString(ride)
				+ ",\n 이벤트: " + Arrays.toString(event) + ",\n 기프트샵: " + getGiftShop().toString();
	}
}
