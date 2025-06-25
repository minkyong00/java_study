package pub2504.exio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
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
		
		File file = new File("C:\\pub2504\\eclipse_workspace\\pub2504\\src\\pub2504\\exio\\Enter_korea_by_age.csv");
		Map<String, List<KoreaVisitor>> korvisitorMap = new HashMap<String, List<KoreaVisitor>>();
		
		
		try {
			Scanner scanner = new Scanner(file);
			
			scanner.nextLine();
			
			while(scanner.hasNextLine()) {
				String fileStr = scanner.nextLine();
				
				StringTokenizer st = new StringTokenizer(fileStr, ",");
				
				if(st.countTokens() >= 4) {
					st.nextToken();
					String nation =  st.nextToken();
					double visitor = Integer.parseInt(st.nextToken());
					st.nextToken();
//					double growth = Integer.parseInt(st.nextToken());
				
					List<KoreaVisitor> korList = Arrays.asList(
						new KoreaVisitor(nation, visitor)
					);
					
					System.out.println(korList);
						
				}
				
			}
						
			
			
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		
		
	} // main
	
} // class
 