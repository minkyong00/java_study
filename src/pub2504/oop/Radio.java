package pub2504.oop;

// Radio is a Product
public class Radio extends Product{

	boolean hasAntena; // 안테나 보유 여부
	
	Radio(String company, String name, int price, boolean hasAntena){
		super(company, name, price);
		this.hasAntena = hasAntena;
	}
	
	// Radio [회사명:십만전자, 제품명:잘들려1, 가격:500, 안테나:있음]
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + super.toString() 
		  + ", 안테나: " + (hasAntena ? "있음" : "없음") + "]";
	}
	
}
