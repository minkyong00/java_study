package pub2504.basic;

public class Method2 {

	public static void main(String[] args) {
		
		// non-static 메소드는 클래스로 접근 불가
//		Method2.print("java");
		// Method2.app(3, 5);
		
		Method2 method2 = new Method2();
		method2.print("java");
		System.out.println(method2.add(3,  5));
		
	}
	
	void print(String str) {
		System.out.println(str);
	}
	
	int add(int a, int b) {
		return a + b;
	}
}
