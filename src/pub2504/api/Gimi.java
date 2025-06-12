package pub2504.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Gimi {
   
   public static void main(String[] args) {
	   // 독립 개수 출력, 모든 마침표 뒤에 줄바꿈을 한 후 파일의 모든 내용 출력
      
      String filePath = "C:\\pub2504\\eclipse_workspace\\pub2504\\src\\pub2504\\api\\gimi.txt";
      
      try {
         
         BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
         
         String gimiTxt = "";
         String readLine = "";
         while ((readLine=br.readLine()) != null) {
            gimiTxt += readLine;
         }
         System.out.println(gimiTxt);
         
         int idx = -1;
         int count = 0;
         while((idx=gimiTxt.indexOf("독립", idx+1)) >= 0) {
        	 count++;
        	 System.out.println("'독립'의 " + count + "번째 인덱스 : " + idx + "\n");
         }
       	 
         System.out.println("'독립'이라는 문자열은 " + count + "번 나옵니다!\n");
         
     	 System.out.println(gimiTxt.replaceAll("\\.", "\\.\n"));
         
      } catch (Exception ex) {
         ex.printStackTrace();
      }
      
   } // main

} // class

























