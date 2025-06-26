package pub2504.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

// 네트워크상의 JSON데이터를 받아서 직렬화 / 역질렬화

public class ObjectTest3 {

	public static void main(String[] args) {
		
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		BufferedReader br = null;
		
		try {
			
			// 1. URI 객체 생성
			URI uri = new URI("https://jsonplaceholder.typicode.com/todos");
			
			// 2. URI를 URL로 변환
			URL url = uri.toURL();
			
			// 3. URL에서 URLConnection을 획득
			URLConnection conn = url.openConnection();
			// System.out.println(conn); // 연결 확인
			
			// 4. URLConnection에서 바이트입력스트림 생성
			InputStream is = conn.getInputStream();
			
			// 5. 바이트입력스트림을 문자입력스트림으로 변환
			InputStreamReader isr = new InputStreamReader(is);
			
			// 6. 버퍼스트림 생성
			br = new BufferedReader(isr);
			
			// 7. JSON 문자열 획득
			String jsonStr = "";
			String line = "";
			while((line=br.readLine()) != null) {
				jsonStr += line;
			}
			
			// 8. JSON문자열을 Java의 ArrayList로 변환
			// GSON라이브러리를 사용(Java의 JSON라이브러리 중 하나)
			// https://mvnrepository.com/ 에서 라이브러리 다운로드
			// 프로젝트 > 빌드패스 > 클래스패스에 라이브러리 추가
			
			// GSON 객체 생성
			Gson gson = new GsonBuilder().create();
			
			// Json 문자열을 ArrayList<Todo>로 변환
			ArrayList<Todo> todoList
				= gson.fromJson(jsonStr, new TypeToken<ArrayList<Todo>>() {}.getType());
			System.out.println(todoList);
//			Map<Integer, List<Todo>> userIdGroupedMap
//				= todoList.stream().collect(Collectors.groupingBy(Todo::getUserId));
//			System.out.println(userIdGroupedMap);
//			for(Entry<Integer, List<Todo>> entry : userIdGroupedMap.entrySet()) {
//				System.out.println("userId=" + entry.getKey() + ", title=" + entry.getValue().get(0).getTitle());
//			}
			
			File file = new File("C:\\pub2504\\files\\todo.dat");
			
			// 직렬화
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(todoList);
			
			// 역직렬화
			ois = new ObjectInputStream(new FileInputStream(file));
			ArrayList<Todo> list = (ArrayList<Todo>) ois.readObject();
//			list.stream().forEach(System.out::println);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				ois.close();
				oos.close();
				br.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}
	
}
