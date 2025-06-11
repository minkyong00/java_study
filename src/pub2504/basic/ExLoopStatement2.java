package pub2504.basic;

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
		
		//1 3 5
		
		System.out.println();
		
		for(int i=0; i<3; i++) {
			for(int k=3-i; k>0; k--) {
				System.out.print(' ');				
			}
			for(int j=0; j<(2*i)-i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		
		
		
		
		// 보너스 실습 2)
		// 3이상의 홀수를 입력하면 최대 별의 개수가
		// 입력한 별의 개수가 되는 다이아몬드 별찍기
		// 3입력하면
		/*
		 
		  *
		 ***
		  *
		  
		 */
		
		
		
		
		
		
		
		
	} //main
} //class
