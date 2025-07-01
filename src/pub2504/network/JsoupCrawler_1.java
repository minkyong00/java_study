package pub2504.network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
   [Jsoup 라이브러리]
   - mvnrepository.com에서 jsoup.jar 다운로드
   - Java기반의 HTML파싱 및 웹 크롤링 라이브러리
   - 웹페이지를 크롤링하고 DOM을 탐색 및 조작하는데 사용
   - BeautifulSoup의 자바 버젼
   - 주요 기능 : HTML파싱, DOM탐색/조작, 데이터 추출, POST/GET요청
*/

public class JsoupCrawler_1 {
   
   public static void main(String[] args) {
      
      // HTML 문자열 파싱
      String html = "<html><body><h1>안녕!</h1><p>좋은 아침!</p></body></html>";
      
      // Document 객체
      Document doc = Jsoup.parse(html); // HTML문자열 파싱해서 Document객체 생성
      
      Element h1 = doc.selectFirst("h1"); // 첫번째 h1 엘리먼트
      System.out.println("제목 : " + h1.text());
      
      Element p = doc.selectFirst("p"); // 첫번째 p 엘리먼트
      System.out.println("내용 : " + p.text());
      
      // 웹페이지 크롤링
      String url = "https://news.naver.com/breakingnews/section/103/237";
      try {
         int interval = (int)(Math.random()*1000) +1500;
         Document docNews = Jsoup.connect(url)
            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)") // 웹브라우져
            .timeout(interval) // 딜레이 (사람인것 처럼...)
            .get(); // URL 연결해서 Document객체 생성
         // stong엘리먼트 중에서 클래스가 sa_text_strong인 엘리먼트들
         Elements titles = docNews.select("strong.sa_text_strong"); 
         for (Element title : titles) {
            System.out.println("제목 : " + title.text());
         }
      } catch (IOException ioe) {
         ioe.printStackTrace();
      }
      
      // 학원 홈페이지내 웹페이지 이미지 가져오기
      String koreaUrl = "http://koreaitacademy.kr/curriculum/app/app.asp";
      try {
         int interval = (int)(Math.random()*1000) +1500;
         Document docKorea = Jsoup.connect(koreaUrl)
            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)") // 웹브라우져
            .timeout(interval) // 딜레이 (사람인것 처럼...)
            .get(); // URL 연결해서 Document객체 생성
         Elements images = docKorea.select("img"); 
//         for (Element image : images) {
//            System.out.println("이미지경로명 : " + image.absUrl("src"));
//         }
         
         // 실습 : 이미지들을 C:\\pub2504\\files\\koreaitimage 폴더에 저장
         new File("C:\\pub2504\\files\\koreaitimage").mkdirs();
         for (Element image : images) {
            saveImage(image.absUrl("src"));
         }         
         
      } catch (Exception e) {
         e.printStackTrace();
      }      
      
   } // main
   
   private static void saveImage(String imagePath) throws Exception {
      String imageFileName = imagePath.substring(imagePath.lastIndexOf('/')+1);
      if (imageFileName.endsWith("jpg") || imageFileName.endsWith("png")) {
         URLConnection conn = new URI(imagePath).toURL().openConnection();
         conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
         BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
         BufferedOutputStream bos = new BufferedOutputStream(
            new FileOutputStream(new File("C:\\pub2504\\files\\koreaitimage\\" + imageFileName))
         );
         byte[] buffer = new byte[1024];
         int readByteCount = 0;
         while ((readByteCount=bis.read(buffer)) > -1) {
            bos.write(buffer, 0, readByteCount);
         }
         bos.flush();
         System.out.println(imageFileName + " 파일 생성됨!");
         bos.close();
         bis.close();
      }
      
   } // saveImage
      
} // class















