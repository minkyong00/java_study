package pub2504.oop;

public class PrinterMain {

	public static void main(String[] args) {
		
		// 실습
		// 분류 : 잉크젯, 회사명:삼송, 이름:잉크안먹혀1, 가격:1000 잉크젯프린터 생성
		// 분류 : 레이저, 회사명:앱송, 이름:종이다잘려1, 가격:2000 레이저프린터 생성
		// 두 프린터를 켜고 > 출력하고 > 끄고
		IPrinter inkjetPrinter = new InkjetPrinter("잉크젯", "삼송", "잉크안먹혀1", 1000);
		IPrinter razorPrinter = new RazorPrinter("레이저", "앱송", "종이다잘려1", 2000);		
		
		// 호출방식 일원화
//		inkjetPrinter.turnOn();
//		inkjetPrinter.print();
//		inkjetPrinter.turnOff();
//		
//		razorPrinter.turnOn();
//		razorPrinter.print();
//		razorPrinter.turnOff();
		
		// 실습 : DotPrinter
		// 분류 : 도트, 회사명:HP, 이름:나오다말다, 가격:500 도트프린터 생성
		// 두 프린터를 켜고 > 출력하고 > 끄고
		IPrinter dotPrinter = new DotPrinter("도트", "HP", "나오다말다", 500);
		
//		dotPrinter.turnOn();
//		dotPrinter.print();
//		dotPrinter.turnOff();
		
		// 실습 : 프린터 500개를 생성
		// 잉크젯, 레이저, 도트의 비율은 4:4:2로 생성
		// 만들어진 모든 프린터를 켜고 출력하고 끄기
//		int count = 500;
//		IPrinter[] iArr = new IPrinter[count];
//		
//		for(int i=0; i<count; i++) {
//			if(i<200) { iArr[i] = new InkjetPrinter("잉크젯", "삼송", "잉크안먹혀"+(i+1), 1000); }
//			else if(i<400) { iArr[i] = new RazorPrinter("레이저", "앱송", "종이다잘려"+(i+1), 2000); }
//			else { iArr[i] = new DotPrinter("도트", "HP", "나오다말다"+(i+1), 500); }
//		}
//		
//		for(IPrinter i : iArr) {
//			i.turnOn();
//			i.print();
//			i.turnOff();
//		}
		
		//instatnceof 연산자
		// 상속트리상에 존재는지 확인하는 연산자 (= 상속관계에 있는지)
		
		IPrinter printer = new InkjetPrinter("잉크젯", "삼송", "잉크안먹혀", 1000);
		System.out.println(printer instanceof IPrinter); // true
		System.out.println(printer instanceof AbstractPrinter); // true
		System.out.println(printer instanceof InkjetPrinter); // true
		System.out.println(printer instanceof RazorPrinter); // false
		System.out.println(printer instanceof DotPrinter); // false
		
		// 실습 : 프린터 500000개를 생성
		// 잉크젯, 레이저, 도트의 비율은 4:4:2로 생성
		// 생성한 잉크젯, 레이저, 도트 프린터 각각의 개수를 출력
		long startTime = System.currentTimeMillis();
		
		int count = 500000;
		IPrinter[] iArr = new IPrinter[count];
		// 원칙은 최상위(IPrinter)로 받는거지만 사용할 때 name에 접근하려면 Abstaract로 바꿔줘야되기 때문에 Abstaract 받음
		AbstractPrinter inkjet = new InkjetPrinter("잉크젯", "삼송", "잉크안먹혀", 1000);
		AbstractPrinter razor = new RazorPrinter("레이저", "앱송", "종이다잘려", 2000);
		AbstractPrinter dot = new DotPrinter("도트", "HP", "나오다말다", 500);
		
		for(int i=0; i<count; i++) {
			try {
				if(i<200000) { iArr[i] = (AbstractPrinter)(inkjet.clone()); }
				else if(i<400000) { iArr[i] = (AbstractPrinter)(razor.clone()); }
				else { iArr[i] = (AbstractPrinter)(dot.clone()); }
			} catch(CloneNotSupportedException cnse) {
				cnse.printStackTrace();
			}
		}
		
		int[] printerCountArr = new int[3];
		for(int i=0; i<count; i++) {
			if(iArr[i] instanceof InkjetPrinter) printerCountArr[0]++;
			if(iArr[i] instanceof RazorPrinter) printerCountArr[1]++;
			if(iArr[i] instanceof DotPrinter) printerCountArr[2]++;
		}
		
		System.out.println("잉크프린터: " + printerCountArr[0] + "개");
		System.out.println("레이저프린터: " + printerCountArr[1] + "개");
		System.out.println("도트프린터: " + printerCountArr[2] + "개");
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("소요시간: " + (endTime - startTime));
		
	} // main
} // class
