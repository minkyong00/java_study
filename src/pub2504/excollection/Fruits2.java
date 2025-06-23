package pub2504.excollection;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Fruits2 {
	
	public static void main(String[] args) {
		// 5개 과일 입력 받아 중복되지 않은 과일 출력 (HashSet)
		System.out.println("과일 5개를 입력해주세요");
		
		Set<String> fruitSet = new HashSet<String>();
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<5; i++) {
			fruitSet.add(sc.next());
		}
		
		System.out.println(fruitSet);
		
		sc.close();

	}
}
