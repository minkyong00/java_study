package pub2504.oop;

public class OuterMain {

	public static void main(String[] args) {
		
		// Outer 객체
		Outer outerObj = new Outer();
		outerObj.print();
		
		System.out.println();
		
		// static inner class 객체 생성
		Outer.SIClass outerSIClassObj = new Outer.SIClass();
		outerSIClassObj.print();
		
		System.out.println();

		// non-static inner class 객체 생성 후 print 메소드 호출
		Outer.NSIClass outerNSIClassObj = new Outer().new NSIClass();
		outerNSIClassObj.print();
		
	}
}
