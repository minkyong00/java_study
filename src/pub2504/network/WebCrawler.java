package pub2504.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class WebCrawler {

	public static void main(String[] args) {
		
		URI uri = null;
		URL url = null;
		URLConnection conn = null;
		BufferedReader br = null;
		
		try {
			
			uri = new URI("https://news.naver.com/breakingnews/section/103/237");
			url = uri.toURL();
			conn = url.openConnection();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line = "";
			String startStr = "<strong class=\"sa_text_strong\">";
			String endStr = "</strong>";
			
			while ((line=br.readLine()) != null) {
				String subject = "";
				if(line.trim().startsWith(startStr)) {
					int startIdx = line.indexOf(startStr) + startStr.length();
					int endIdx = line.indexOf(endStr, startIdx);
					subject = line.substring(startIdx, endIdx);
					System.out.println(subject);
				}
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}
	
}
