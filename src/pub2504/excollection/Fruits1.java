package pub2504.excollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fruits1 {

	public static void main(String[] args) {
		// 5개 과일 입력받아서 과일명 순서대로 출력 (ArrayList)
		System.out.println("과일 5개를 입력해주세요");
		
		List<String> fruitArr = new ArrayList<String>();

		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<5; i++) {
			fruitArr.add(sc.next());
		}

		System.out.println(fruitArr);
		
		sc.close();
	}
}
