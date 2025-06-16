package pub2504.basic;

public class Method1 {

	public static void main(String[] args) {
		
		print("hello java");
		print("java Programming");
		
		int sum = add(1, 2);
		System.out.println(sum);
		System.out.println(add(3, 4));
		// static 메소드는 클래스로 접근 가능
		System.out.println(Method1.add(5, 6));
		
	} // main

	static void print(String str) {
		System.out.println(str);
		// return; 생략된 것
	}
	
	static int add(int a, int b) {
		// 반환값이 있는 경우 return 생략 불가
		return a + b;
	}
	
} // class
