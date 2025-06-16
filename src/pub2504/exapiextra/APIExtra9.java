package pub2504.exapiextra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class APIExtra9 {
   
   public static void main(String[] args) {
//	   미국독립선언서(americadoi.txt) 파일내의 한글, 영문, 기호의 개수를 출력
      
//	   String txt = getText();
//	   System.out.println(txt);
//	   
//	   int txtLeng = txt.length();
//	   int[] countArr = new int[3];
//	   
//	   for(int i=0; i<txtLeng; i++) {
//		   char c = txt.charAt(i);
//		   byte b = (byte)c;
//			if(c<='힣' && '가'<=c) {
//				countArr[0]++;
//			} else if(b<=90 && 65<=b || b<=122 && 97<=b) {
//				countArr[1]++;
//			} else if(47<=b && 33<=b || 64<=b && 58<=b || 96<=b && 91<=b || 126<=b && 123<=b) {
//				countArr[2]++;
//			} 
//	   }
//	   
//	   System.out.printf("한글의 개수 : %d, 영문의 개수 : %d, 기호의 개수 : %d",
//				countArr[0], countArr[1], countArr[2]);
      
      char[] chArr = getText().toCharArray();
      
      int[] countArr = new int[3];
      
      for(char ch : chArr) {
    	  String str = String.valueOf(ch);
    	  if(str.matches("[가-힣]")) countArr[0]++;
    	  else if(str.matches("[a-zA-Z]")) countArr[1]++;
    	  else if(str.matches("[^\\d]")) countArr[2]++;
      }
      
      System.out.printf("한글의 개수 : %d, 영문의 개수 : %d, 기호의 개수 : %d",
				countArr[0], countArr[1], countArr[2]);
	   
   }
   
   // 파일의 내용을 한 줄씩 읽어서 모두 합쳐서 리턴하는 메소드
   private static String getText() {
      BufferedReader br;
      try {
         br = new BufferedReader(new FileReader(
               new File("C:\\pub2504\\eclipse_workspace\\pub2504\\src\\pub2504\\exapiextra\\americadoi.txt")));
         String line = "";
         String gimiTxt = "";
         while ((line=br.readLine())!=null) {
            gimiTxt += line;
         }
         br.close();
         return gimiTxt;
      } catch (FileNotFoundException fnfe) {
         fnfe.printStackTrace();
         return null;
      } catch (IOException ioe) {
         ioe.printStackTrace();
         return null;
      }
   }      

}
