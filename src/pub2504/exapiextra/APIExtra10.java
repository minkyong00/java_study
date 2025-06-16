package pub2504.exapiextra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class APIExtra10 {
	
	static int idx = 0;
	static String[][] words = new String[10000][2];

	public static void main(String[] args) {
		// 미국독립선언서(americadoi.txt) 파일내에서 영단어 중 길이가 가장 긴 단어부터 
		// 가장 짧은 단어를 순서대로 개수와 함께 출력
		
//		String txt = getText();
//		String resultStr = "";
//		
//		String[] strArr = txt.split("\\s");
//		int strArrLeng = strArr.length;
//		String engStr = "";
//		
//		String[] resultArr = new String[strArrLeng];
//		Arrays.fill(resultArr, "");
//		
//		for(int i=0; i<strArrLeng; i++) {
//			engStr = strArr[i].replaceAll("[^a-zA-z]", "");
//			if(!engStr.isEmpty()) {
//				resultArr[i] = engStr;
//				
//				char[] cArr = engStr.toCharArray();
//				cArr = Arrays.sort(cArr);
//				String sorted = new String();
//				
//				System.out.println(sorted);
//			}
//		}
		
		// Iterator : 반복자 객체
		// MatchResult : 정규표현식과 매칭된 결과 객체
		Iterator<MatchResult> iterator
		// 전체 문자열에서 영문자가 1개 이상인 것들의 결과들을 반복시키는 반복자 객체
			= Pattern.compile("[a-zA-Z]+").matcher(getText())
			  .results().iterator();
		
		// 반복할 MatchResult가 있는 동안 반복
		while(iterator.hasNext()) {
			// MatchResult내에 있는 매칭된 문자열을 저장
			String word = iterator.next().group();
			words[idx][1] = "1"; // 문자열의 개수를 1로 설정
			if(!isDup(word)) { // 중복되지 않았다면 (= 새로운 문자열)
				words[idx++][0] = word; // 문자열을 저장
			}
		}
		
		// 배열을 문자열 길이에 대해 내림차순으로 정렬
		sortWords();
		
		// 배열 출력
		printWords();
		
			
	} // main
	
	// 중복체크
	public static boolean isDup(String str) {
		for(int i=0; i<idx; i++) {
			if(str.equals(words[1][0])) {
				words[i][1] = String.valueOf(Integer.parseInt(words[i][1]) + 1);
				return true;
			}
		}
		return false;
	}
	
	// 배열 정렬
	public static void sortWords() {
		// Arrays.sort : 배열 정렬 메소드 (인자로 배열과 Comparator)
		Arrays.sort(words, new Comparator<String[]>() {
			@Override
			public int compare(String[] prev, String[] next) { // 비교 메소드
				if(prev[0]!=null && next[0]!=null) {
					return next[0].length() - prev[0].length(); // 문자열 길이에 대해 내림차순
				} else {
					return 0; // 순서를 바꾸지 않음
				}
			}
		});
	}
	
	// 배열 출력
	public static void printWords() {
		for(int i=0; i<idx; i++) {
			System.out.println(words[i][0] + " 단어는 " + words[i][1] + "번 나옴");
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
