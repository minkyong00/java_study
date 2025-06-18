package pub2504.oop;

// TV is a Product
public class TV extends Product {

	boolean hasDisplay; // 화면 보유 여부
	
	TV(String company, String name, int price, boolean hasDisplay){
		super(company, name, price);
		this.hasDisplay = hasDisplay;
	}
	
	// TV [회사명:알지전자, 제품명:완전커1, 가격:1000, 디스플레이:있음]
//	@Override
//	public String toString() {
//		return "TV [회사명: " + company + ", 제품명: " + name 
//				+ ", 가격: " + price + ", 디스플레이: " + (hasDisplay ? "있음" : "없음") + "]";
//	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + super.toString() 
		  + ", 디스플레이: " + (hasDisplay ? "있음" : "없음") + "]";
	}

}
