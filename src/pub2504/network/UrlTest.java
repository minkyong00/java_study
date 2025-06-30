package pub2504.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class UrlTest {

	public static void main(String[] args) {
		
		URI uri = null;
		URL url = null;
		URLConnection conn = null;
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			
			uri = new URI("https://www.google.com"); // URI 객체 생성
			url = uri.toURL(); // URL로 변환
			conn = url.openConnection(); // URLConnection 획득
//			System.out.println(conn);
			if(conn!=null) { // 연결 되었다면
				is = conn.getInputStream(); // InputStream 획득
				isr = new InputStreamReader(is); // Reader 획득
				br = new BufferedReader(isr); // BufferedReader 획득
				String html = "";
				String lineStr = "";
				while((lineStr=br.readLine()) != null) { // 읽어들인 라인이 있다면
					html += lineStr;
				}
				// 파일에 저장
				File file = new File("C:\\pub2504\\files\\google.html");
				bw = new BufferedWriter(new FileWriter(file));
				bw.write(html);
				bw.flush();
			}
			
		} catch (URISyntaxException urise) {
			urise.printStackTrace();
		} catch (MalformedURLException murle) {
			murle.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				bw.close();
				br.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		
	}
	
}
