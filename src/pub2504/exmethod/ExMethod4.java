package pub2504.exmethod;

import java.util.Scanner;

public class ExMethod4 {
	// 별의 개수 입력하면 첫 행에 1개의 별
	// 마지막행에는 입력한 개수의 별을 출력하는 프로그램
	// 기능별로 나누기
	
	public static void main(String[] args) {
		printStar(input());
	}
	
	static int input() {
		System.out.println("출력하실 별의 개수를 입력하세요!");
		Scanner sc = new Scanner(System.in);
		
		int starCount = sc.nextInt();
		sc.close();
		
		return starCount;
	}
	
	static void printStar(int starCount) {
		
		for(int i=0; i<starCount; i++) {
			for(int j=0; j<i+1; j++) {
				System.out.print('*');				
			}
			System.out.println();
		}
		
	}

}
