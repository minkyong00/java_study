package pub2504.exoop;

public class Phone {

	private String brand;
	private String name;
	private int price;
	private String telecom;
	private Case c;
	private Charger charger;
	private SmartWatch smartWatch;
	private EarPhone earPhone;
	private Film film;

	public Phone() {
	}

	public Phone(String brand, String name, int price, String telecom, Case c, Charger charger, SmartWatch smartWatch,
			EarPhone earPhone, Film film) {
		super();
		this.brand = brand;
		this.name = name;
		this.price = price;
		this.telecom = telecom;
		this.c = c;
		this.charger = charger;
		this.smartWatch = smartWatch;
		this.earPhone = earPhone;
		this.film = film;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTelecom() {
		return telecom;
	}

	public void setTelecom(String telecom) {
		this.telecom = telecom;
	}

	public Case getC() {
		return c;
	}

	public void setC(Case c) {
		this.c = c;
	}

	public Charger getCharger() {
		return charger;
	}

	public void setCharger(Charger charger) {
		this.charger = charger;
	}

	public SmartWatch getSmartWatch() {
		return smartWatch;
	}

	public void setSmartWatch(SmartWatch smartWatch) {
		this.smartWatch = smartWatch;
	}

	public EarPhone getEarPhone() {
		return earPhone;
	}

	public void setEarPhone(EarPhone earPhone) {
		this.earPhone = earPhone;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}
	
	@Override
	public String toString() {
		return  "브랜드: " + name + ", 가격: " + price + ", 통신사: " + telecom 
				+ ", 충전기: " + getCharger().getBrand() + ", 스마트워치 :" + getSmartWatch().getBrand() 
				+ ", 이어폰: " + getEarPhone().getBrand() + ", 필름: " + getFilm().getBrand();
	}

}
