package pub2504.exoopAmusementPark;

public class Ticket {
	
	private int price; // 가격
	private int totalTicketCount; // 총 판매된 티켓 수
	private String date; // 예매한 날짜
	
	public Ticket() {
	}

	public Ticket(int price, int totalTicketCount, String date) {
		super();
		this.price = price;
		this.totalTicketCount = totalTicketCount;
		this.date = date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotalTicketCount() {
		return totalTicketCount;
	}

	public void setTotalTicketCount(int totalTicketCount) {
		this.totalTicketCount = totalTicketCount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "티켓 가격: " + price + ", 예매한 날짜: " 
				+ date + ", 총 판매된 티켓 수: " + totalTicketCount;
	}
	
}
