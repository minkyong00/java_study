package pub2504.basic;

public class Method3 {

	public static void main(String[] args) {
		
		System.out.println(add(10, 5));
		System.out.println(subtract(10, 5));
		System.out.println(multiply(10, 5));
		System.out.println(devide(10, 5));
		
	}
	
	public static int add(int a, int b) {
		return a + b;
	}
	
	protected static int subtract(int a, int b) {
		return a - b;
	}
	
	static int multiply(int a, int b) {
		return a * b;
	}
	
	private static int devide(int a, int b) {
		return a / b;
	}
}
