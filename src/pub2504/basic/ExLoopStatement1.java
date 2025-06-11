package pub2504.basic;

public class ExLoopStatement1 {
	
	public static void main(String[] args) {
		// 구구단 출력
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				int mul = i * j;
				System.out.printf("%d X %d = %d \n", i, j, mul);
			}
		}
	}

}
