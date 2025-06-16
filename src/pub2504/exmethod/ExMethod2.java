package pub2504.exmethod;

public class ExMethod2 {
	// 실수 3개의 총합 구하는 메소드
	
	public static void main(String[] args) {
		System.out.println("세 실수의 합은 " + add(1.1, 2.2, 3.3));
	}
	
	static double add(double a, double b, double c) {
		return a + b + c;
	}
}
