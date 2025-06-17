package pub2504.exoopAmusementPark;

public class AmusementParkMain {

	public static void main(String[] args) {
		Visitor v1 = new Visitor("VIP", "홍길동", 10);
		Visitor v2 = new Visitor("일반", "이순신", 20);
		Visitor v3 = new Visitor("일반", "장보고", 30);
		
		Visitor[] visitors = { v1, v2, v3 };
		
		Ticket ticket = new Ticket(2000, 1000, "2025-06-18");
		
		Ride r1 = new Ride("바이킹", 30, 3, 30);
		Ride r2 = new Ride("후룸라이드", 20, 4, 50);
		Ride r3 = new Ride("티엑스", 10, 5, 60);
		
		Ride[] rides = { r1, r2, r3 };
		
		Event e1 = new Event("퍼레이드", "공연", "광장");
		Event e2 = new Event("불꽃놀이", "공연", "중앙무대");
		
		Event[] events = { e1, e2 };
		
		GiftShop giftShop = new GiftShop("머리띠", "정문", 3000);
		
		AmusementPark amusementPark = new AmusementPark("에버랜드", "용인", "오전 9시",
				"오후 9시", ticket, visitors, rides, events, giftShop);
		
		System.out.println(amusementPark);
		
	}
}
