package pub2504.exmethod;

public class ExMethod5_1 {
   
	static String[][] strArr = {
			{"홍길동", "90", "80", "70", "0", "0.0"},
			{"강감찬", "80", "70", "60", "0", "0.0"},
			{"이순신", "70", "60", "50", "0", "0.0"}
	};
	
	static int strArrLeng = strArr.length;
	static int strArr0Leng = strArr[0].length;
	
   public static void main(String[] args) {
      
      print(calcScore());
      
      
   } // main
   
   static String[][] calcScore() {
	   for (int i=0; i<strArrLeng; i++) {
	         int total = 0;
	         float avg = 0.0f;
	         for (int j=1; j<strArr0Leng - 2; j++) {
	            total += Integer.parseInt(strArr[i][j]);
	         }
	         avg = total / 3;
	         strArr[i][4] = String.valueOf(total);
	         strArr[i][5] = String.valueOf(avg);
	         
	      }
	   return strArr;
   }
   
   
   static void print(String[][] strArr) {
	   for (int i=0; i<strArrLeng; i++) {
	         for (int j=0; j<strArr0Leng; j++) {
	            System.out.print(strArr[i][j] + " ");
	         }
	         System.out.println();
	      }
   }

}











