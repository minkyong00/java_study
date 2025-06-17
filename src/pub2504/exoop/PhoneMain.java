package pub2504.exoop;

public class PhoneMain {
	
	public static void main(String[] args) {
		
		Case c = new Case("하드", "신지모루", 1000);
		Charger charger = new Charger("c타입", 1500, "애플");
		EarPhone earPhone = new EarPhone("애플", 3000, "블루투스");
		Film film = new Film("방탄필름", "신지모루", 500);
		SmartWatch smartWatch = new SmartWatch("애플", 2000, "41mm", "7세대");
		
		Phone phone = new Phone("애플", "iphone16", 8000, "KT", c, charger, smartWatch, earPhone, film);
		
		System.out.println(phone);
		System.out.println(c);
		System.out.println(charger);
		System.out.println(earPhone);
		System.out.println(film);
		System.out.println(smartWatch);
	}
}
