package pub2504.oop;

public class InkjetPrinter extends AbstractPrinter implements Cloneable{

	public InkjetPrinter(String sort, String company, String name, int price){
		super(sort, company,name, price);
		this.sort = "잉크젯프린터";
	}
	
	@Override
	public void print() {
		System.out.println(
			sort + " 타입의" +
		    name + " 프린터는 잉크를 이용해 출력하고 가격은 " +
			price + "원 입니다"
		);
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
