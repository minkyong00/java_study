package pub2504.basic;

import java.util.Scanner;

public class ExLoopStatement2 {

	public static void main(String[] args) {
		
		// 별찍기
		
		/*
		 
		 *
		 **
		 ***
		 ****
		 *****
		 
		 */
		
		for(int i=1; i<6; i++) {
			for(int j=1; j<i+1; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		
		
		System.out.println();
		
		/*
		 
		 *****
		 ****
		 ***
		 **
		 *
		 
		 */
		
		for(int i=1; i<6; i++) {
			for(int j=1; j<=6-i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		
		System.out.println();
		
		
		/*
		 
		 *****
		  ****
		   ***
		    **
		     *
		 
		 */
		
		for(int i=1; i<6; i++) {
			for(int j=1; j<i+1; j++) {
				System.out.print(' ');
			}
			for(int k=1; k<=6-i; k++) {
				System.out.print('*');
			}
			System.out.println();
		}
		
		System.out.println();
		
		
		/*
		 
		     *
		    ***
		   *****
		  *******
		 *********
		 
		 */
		
		
		for(int i=1; i<6; i++) {
			for(int j=1; j<= 6-i; j++) {
				System.out.print(' ');
			}
			for(int k=1; k<i+1; k++) {
				System.out.print('*');
			}
			for(int k=2; k<i+1; k++) {
				System.out.print('*');
			}
			for(int j=1; j<= 6-i; j++) {
				System.out.print(' ');
			}
			System.out.println();
		}
		
		System.out.println();
		
		
			/*
			 
		     *****
		     *   *
		     *   *
		     *   *
		     *****
		 
		    */
		
		for(int i=1; i<6; i++) {
			for(int j=1; j<6; j++) {
				if(i%5 == 0 || i%5 == 1 || j%5 == 0 || j%5 == 1) {
					System.out.print('*');
				} else {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
		
		/*
		 
	     *   *
	      * * 
	       *  
	      * * 
	     *   *
	 
	    */
		
		
		System.out.println();
		
		for(int i=1; i<6; i++) {
			for(int j=1; j<6; j++) {
				if(i==j || (i*j)%8 == 0 || i*j == 5) {
					System.out.print('*');					
				} else {
					System.out.print(' ');										
				}
			}
			System.out.println();
		}
		
		/*
		 
		 *****
		 ** **
		 * * *
		 ** **
		 *****
	 
		 */
		
		
		System.out.println();
		
		for(int i=1; i<6; i++) {
			for(int j=1; j<6; j++) {
				if(i%5 == 0 || j%5 == 0 || i%5 == 1 || j%5 == 1 || i==j || (i*j) == 8) {
					System.out.print('*');					
				} else {
					System.out.print(' ');										
				}
			}
			System.out.println();
		}
		
		// 보너스 실습 1)
		/*
		    *   
		   ***   
		  *****   
		   ***   
		    *   
		 */
		
//	i	1 2 3 4 5
//	j	1 3 5 3 1
//	k	2 1 0 1 2
		
		//1 3 5 3 1
		//  2(2(2-i) + 1
		System.out.println();
		
		for(int i=0; i<5; i++) {
			for(int k=Math.abs(2-i); k>0; k--) {
				System.out.print(' ');				
			}
			for(int j=0; j<5-2*(Math.abs(2-i)); j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		
		System.out.println();
		
//		k = |2-i|
//		k = (5-j)/2
//		if i<middle then k = 2-i=((2*middle + 1)-j)/2
//		else k = -2+i=i-2=((2*middle + 1)-j)/2
//		전체 줄수 = 2*middle + 1
//		((2*middle + 1)-i)/middle = (total -i)/middle = middle-i
		int line = 5;
		int middle = line/2;
		int kEnd = 0; // k반복의 끝 값 = 공백의 수
		int jEnd = 0; // j반복의 끝 값 = 공백의 수
		
		for(int i=0; i<line; i++) {
			if(i < middle) {
				kEnd = middle - i;
				jEnd = 2*i + 1;
			} else {
				kEnd =i - middle;
				jEnd = (line*2 - 1) -2*i;
			}
			for(int k=0; k<kEnd; k++) System.out.print(' ');
			for(int j=0; j<jEnd; j++) System.out.print('*'); 
			System.out.println();
		}
		
		System.out.println();
		
		
		// 보너스 실습 2)
		// 3이상의 홀수를 입력하면 최대 별의 개수가
		// 입력한 별의 개수가 되는 다이아몬드 별찍기
		// 3입력하면
		/*
		 
		  *
		 ***
		  *
		  
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("별의 행 개수를 입력하세요");
		int rowCount = scanner.nextInt();
		int center = rowCount / 2;
		
		for(int i=0; i<rowCount; i++) {
			for(int k=Math.abs(center-i); k>0; k--) {
				System.out.print(' ');				
			}
			for(int j=0; j<rowCount-2*(Math.abs(center-i)); j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		
		
		
		
		
		
		
	} //main
} //class