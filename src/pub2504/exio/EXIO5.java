package pub2504.exio;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
   [Kaggle데이터를 활용한 IO실습]
   * 파일 : KoreaVisitor.java, EXIO5.java
   1. 연령별 대한민국 방문객 데이터를 Kaggle에서 다운로드 (Enter_korea_by_age.csv)
       https://www.kaggle.com/datasets/bappekim/south-korea-visitors?resource=download
   2. 다운로드 받은 파일을 읽어서 기간내 국가별 방문자수와 성장률 평균 연산
   3. 1을 입력하면 국가별 방문자수 상위순으로 국가명과 평균방문자수를 출력
       2를 입력하면 국가별 성장률 상위순으로 국가명과 평균성장률을 출력
   4. 출력 예)
       원하시는 통계를 입력하세요 (1:국가별 평균방문자수, 2:국가별 평균성장률)
       1
       1위    중국    250000명
       2위    일본    220000명
       ...
*/

public class EXIO5 {

	public static void main(String[] args) {
		
		FileReader fe = null;
		
		File file = new File("C:\\pub2504\\eclipse_workspace\\pub2504\\src\\pub2504\\exio\\Enter_korea_by_age.csv");
		
		try {
			
			fe = new FileReader(file);
			
			// file 읽어서 콘솔에 출력
			int fileLeng = (int) file.length();
			char[] charArr = new char[fileLeng];
			for(int i=0; i<fileLeng; i++) {
				charArr[i] = (char) fe.read();
			}
			String str = new String(charArr);
			
			String[] strArr = str.split("\\,");
			List<String> strList = Arrays.asList(strArr);
			System.out.println(strList);
			int strListSize = strList.size()/10 -1;
//			System.out.println(strListSize);
			for(int i=0; i<strListSize; i++) {
				System.out.println(strList.subList((i*10)+12, (i*10)+13).get(0));				
			}
			
			List<Integer> visitorList = new ArrayList<Integer>();
			
			
//			Map<String, > strMap = strList.stream().collect(Collectors.groupingBy()); 
			
			
			// 나라 60국가
			// 연도 19.01 - 20.04 16개월
			// 방문 성장
			
			// 19.01
			// 12, 13 중국
			// 23, 24 일본
			// 34, 35 대만
			// 45, 47 홍콩
			
			// 19.02
			// 
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fe.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	} // main
	
} // class
 