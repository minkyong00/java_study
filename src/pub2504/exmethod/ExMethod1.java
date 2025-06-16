package pub2504.exmethod;

public class ExMethod1 {
	// 정수 두개 중 더 큰 수 출력
	public static void main(String[] args) {
		printBigNum(3, 2);
	}
	
	static void printBigNum(int a, int b) {
		// 같은거 추가
		System.out.println(a > b ? a : (a==b) ? a : b);
	}
}
