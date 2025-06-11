package pub2504.basic;

import java.util.Scanner;

public class ExConditionalStatement2 {

	public static void main(String[] args) {
		// 100~91점은 A, 90~81점은 B, 80~71점은 C, 70~61점은 D, 60점 이하는 F 출력
		
		Scanner scanner = new Scanner(System.in);
		
		int score = 0;
		System.out.println("점수를 입력하세요");
		score = scanner.nextInt();
		
		if(score <= 100 && 91 <= score) { System.out.println("A"); }
		else if(score <= 90 && 81 <= score) { System.out.println("B"); }
		else if(score <= 80 && 71 <= score) { System.out.println("C"); }
		else if(score <= 70 && 61 <= score) { System.out.println("D"); }
		else if(score <= 60) { System.out.println("F"); }
		
	}
}
