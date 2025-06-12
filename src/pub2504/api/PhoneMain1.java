package pub2504.api;

import java.util.Scanner;
import java.util.StringTokenizer;

public class PhoneMain1 {
   
   public static void main(String[] args) {
      System.out.println("5명의 이름과 휴대폰번호를 입력해 주세요!");
      System.out.println("형식 : 홍길동 010-0000-0000");
      
      String[][] strArr = new String[5][4];
      Scanner scanner = new Scanner(System.in);
      
      for (int i=0; i<5; i++) {
         String line = scanner.nextLine();
         StringTokenizer st = new StringTokenizer(line, " -");
         int j = 0;
         while(st.hasMoreTokens()) {
            strArr[i][j++] = st.nextToken();
         }
      } // for
      
      for (int i=0; i<strArr.length-1; i++) {
         for (int j=0; j<strArr[0].length; j++) {
            System.out.print(strArr[j][i] + " ");
         }
         System.out.println();
      } // for
      
      scanner.close();
      
   } // main

} // class
























