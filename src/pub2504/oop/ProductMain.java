package pub2504.oop;

public class ProductMain {

	public static void main(String[] args) {
		
		TV tv1 = new TV("알지전자", "완전커1", 1000, true);
		Radio radio1 = new Radio("십만전자", "잘들려1", 500, true);
		
		// 실습 : 객체 출력 시 아래 형식으로 출력되도록
		// 출력시에 TV는 TV [회사명:알지전자, 제품명:완전커1, 가격:1000, 디스플레이:있음]
		//			  Radio는 Radio [회사명:십만전자, 제품명:잘들려1, 가격:500, 안테나:있음]
		System.out.println(tv1);
		System.out.println(radio1);
		
		// 상위형변환 
		// 메모리 참조범위가 좁은 쪽으로의 형변환이므로
		// 메모리 참조에 문제가 없어서 자동으로 묵시적으로 형변환됨
		
		// tv2는 Product타입, 가지고 있는 참조는 TV타입
		// 상위형변환은 묵시적이므로 new앞에 Product붙여야하지만 자동으로 형변환됨
		Product tv2 = new TV("알지전자", "완전커2", 2000, true);
		// radio2는 Product타입, 가지고 있는 참조는 Radio타입
		Product radio2 = new Radio("십만전자", "잘들려2", 1000, true);
		
		// 하위형변환
		// 메모리 참조범위를 넓히는 쪽으로의 형변환이므로
		// 메모리 참조에 문제가 발생할 수 있어서 강제적으로 명시적으로 형변환해야 함
		
		// tv2는 Product 타입, 가지고 있는 참조는 TV타입
		// tv2는 상위형변환이 되서 TV타입 참조를 가지고 있으므로 하위형변환이 가능
		// => tv2가 가지고 있는 참조가 TV타입이므로 TV로 하위형변환 가능
		TV tv3 = (TV)tv2;
		
		// radio2는 Product타입, 가지고 있는 참조는 Radio타입
		Radio radio3 = (Radio)radio2;
		
		Object tv4 = new TV("알지전자", "완전커3", 3000, true);
		Object radio4 = new Radio("십만전자", "잘들려3", 1500, true);
		
		// 실습 : tv4와 radio4를 각각 Product타입과 TV 또는 Radio타입으로 형변환
		// 가지고 있는 참조가 똑같으므로 차이가 있을 수 없음
		Product ptv1 = (Product)tv4;
		Product pradio1 = (Product)radio4;
		
		TV tv5 = (TV)tv4;
		Radio radio5 = (Radio)radio4;
		
		// Product로 형변환한 것과 TV로 형변환한 것의 결과는 같음
		// => 가지고 있는 참조는 TV
		System.out.println(ptv1);
		System.out.println(pradio1);
		
		// Product로 형변환한 것과 Radio로 형변환한 것의 결과는 같음
		// => 가지고 있는 참조는 Radio
		System.out.println(tv5);
		System.out.println(radio5);
		
		// 결론
		// 객체참조변수가 어떤 타입인지보다 객체참조변수가
		// 어떤 타입의 참조값을 가지고 있는지가 훨씬 중요함
		// => 결국 객체참조변수를 통해서 접근하는 메모리는 가지고 있는 참조값을 기준으로 한다
	}
	
}
