package pub2504.exapiextra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class APIExtra10 {

	public static void main(String[] args) {
		// 미국독립선언서(americadoi.txt) 파일내에서 영단어 중 길이가 가장 긴 단어부터 
		// 가장 짧은 단어를 순서대로 개수와 함께 출력
		
		String txt = getText();
		String resultStr = "";
		
		String[] strArr = txt.split("\\s");
		int strArrLeng = strArr.length;
		String engStr = "";
		
		String[] resultArr = new String[strArrLeng];
		Arrays.fill(resultArr, "");
		
		for(int i=0; i<strArrLeng; i++) {
			engStr = strArr[i].replaceAll("[^a-zA-z]", "");
			if(!engStr.isEmpty()) {
				resultArr[i] += engStr;
				
				char[] cArr = engStr.toCharArray();
				Arrays.sort(cArr);
				String sorted = new String(cArr);
				
				System.out.println(sorted);
			}
		}
		
			
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
