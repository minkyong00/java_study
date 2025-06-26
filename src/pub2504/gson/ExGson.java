package pub2504.gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/*

	[Gson 변환 실습]
	https://jsonplaceholder.typicode.com/users 데이터를 가져와서
	Java List로 변환 후 website가 .com으로 끝나는 사용자들의 정보를 출력

*/

public class ExGson {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		
		try {
			
			URI uri = URI.create("https://jsonplaceholder.typicode.com/users");
			URL url = uri.toURL();
			URLConnection conn = url.openConnection();
			
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			
			br = new BufferedReader(isr);
			
			String jsonStr = "";
			String line = "";
			while((line=br.readLine()) != null) {
				jsonStr += line;
			}
			
//			System.out.println(jsonStr);
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			List<User> usersList 
				= gson.fromJson(jsonStr, new TypeToken<List<User>>() {}.getType());
			usersList.stream()
				.filter(u -> u.getWebsite().endsWith("com"))
				.forEach(System.out::println);
				
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
