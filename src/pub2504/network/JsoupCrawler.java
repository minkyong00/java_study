package pub2504.network;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
	[Jsoup 라이브러리]
	- mvnrepository에서 jsoup.jar 다운
	- Java기반의 HTML파싱 및 웹 크롤링 라이브러리
	- 웹페이지를 크롤링하고 DOM을 탐색 및 조작하는데 사용
	- BeautifulSoup의 자바 버전
	- 주요 기능 : HTML파싱, DOM탐색/조작, 데이터 추출, POST/GET 요청
*/

public class JsoupCrawler {

	public static void main(String[] args) {
		
		// HTML 무자열 파싱
		String html = "<html><body><h1>안녕!</h1><p>좋은 아침!</p></body></html>";
		
		// Document 객체
		Document doc = Jsoup.parse(html); // HTML 문자열 파싱해서 Document객체 생성
		
		Element h1 = doc.selectFirst("h1"); // 첫 번째 h1 엘리먼트
		System.out.println("제목 : " + h1.text());
		
		Element p = doc.selectFirst("p"); // 첫 번째 p 엘리먼트
		System.out.println("내용 : " + p.text());
		
		// 웹페이지 크롤링
		String newsUrl = "https://news.naver.com/breakingnews/section/103/237";
		try {
			int interval = (int)(Math.random()*1000) + 1500; 
			Document docNews = Jsoup.connect(newsUrl)
				.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)")	// 웹브라우저라고 알려주기 위해 
				.timeout(interval) // 5초간 딜레이 (사람인 것 처럼)
				.get(); // URL 연결해서 Document 객체 생성
			// strong 엘리먼트 중에서 클래스가 sa_text_strong인 엘리먼트들
			Elements titles = docNews.select("strong.sa_text_strong");
			for (Element title : titles) {
				System.out.println("제목 : " + title.text());
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		// pixabay.com의 이미지 가져오기
//		String pixaUrl = "https://pixabay.com/photos/";
//		try {
//			int interval = (int)(Math.random()*1000) + 1500; 
//			Document docPixa = Jsoup.connect(pixaUrl)
//					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
//					.timeout(interval) 
//					.get();
//			Elements images = docPixa.select("img");
//			for (Element image : images) {
//				System.out.println("이미지 경로명 : " + image.absUrl("src"));
//			}
//		} catch (IOException ioe) {
//			ioe.printStackTrace();
//		}
		
		// 학원 홈페이지내 웹페이지 이미지 가져오기
		String koreaUrl = "https://g-sa.koreaisacademy.com/curriculum/app/app.asp";
		List<String> imgList = new ArrayList<String>();
		try {
			int interval = (int)(Math.random()*1000) + 1500; 
			Document docKorea = Jsoup.connect(koreaUrl)
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
					.timeout(interval) 
					.get();
			Elements images = docKorea.select("img");
			for (Element image : images) {
				imgList.add(image.absUrl("src"));
				System.out.println("이미지 경로명 : " + image.absUrl("src"));

			}
			
			// 실습 : 이미지들을 C:\\pub2504\\files\\koreaitimage 폴더에 저장
			new File("C:\\pub2504\\files\\koreaitimage").mkdir();
			for(Element image : images) {
				saveImage(image.absUrl("src"));
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	} // main
	
	private static void saveImage(String path) {
		String imgName = path.substring(path.lastIndexOf("/")+1);
		if(imgName.endsWith("png") || imgName.endsWith("jpg")) {
			try {
				URLConnection conn = new URI(path).toURL().openConnection();
				BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
				BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(new File("C:\\pub2504\\files\\koreaitimage\\" + imgName)));
				
				byte[] byteArr = new byte[1024];
				int byteCount = 0;
				while((byteCount=bis.read(byteArr))>-1) {
					bos.write(byteArr, 0, byteCount);
				}
				bos.flush();
				System.out.println(imgName + " 파일 생성됨!");
				
				bos.close();
				bis.close();
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}
	}
	
}
