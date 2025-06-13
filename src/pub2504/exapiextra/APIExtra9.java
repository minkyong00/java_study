package pub2504.exapiextra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class APIExtra9 {
   
   public static void main(String[] args) {
      
      System.out.println(getText());
      
   }
   
   // 파일의 내용을 한 줄씩 읽어서 모두 합쳐서 리턴하는 메소드
   private static String getText() {
      BufferedReader br;
      try {
         br = new BufferedReader(new FileReader(
               new File("C:\\Users\\Administrator\\git\\pub2504\\pub2504\\src\\pub2504\\exapiextra\\americadoi.txt")));
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
