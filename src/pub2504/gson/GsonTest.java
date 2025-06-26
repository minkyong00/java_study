package pub2504.gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/*
 	GSON
 	- Google에서 만든 Java Json Library
 	- toJson(): 자바객체 -> JSON문자열
 	- fromJson(): JSON문자열 -> 자바객체
 	- 비슷한 라이브러리 : Jackson, SimpleJson ...
*/

public class GsonTest {

	public static void main(String[] args) {
		
		// Gson 객체 생성법 1)
		Gson gson1 = new Gson();
		
		// Gson 객체 생성법 2)
		Gson gson2 = new GsonBuilder().create();
		
		// Gson 객체 생성법 3)
		Gson gson3 = new GsonBuilder().setPrettyPrinting().create(); // 들여쓰기 정렬해서
		
		// JsonObject 객체 생성
		JsonObject jsonObject = new JsonObject();
		
		// JsonObject에 키/값 추가
		jsonObject.addProperty("name", "홍길동"); // {"name": "홍길동"}
		jsonObject.addProperty("age", 30); // {"name": "홍길동", "age": 30}
		
		//JsonObject를 Json문자열로 변환 toJson
		String jsonStr = gson3.toJson(jsonObject);
//		System.out.println(jsonStr);
		
		// Java객체를 Json문자열로 반환
		Person person = new Person("홍길동", 30);
		String personJsonStr = gson3.toJson(person);
//		System.out.println(personJsonStr);
		
		// Json문자열을 Java객체로 변환
		String jsonStr2 = "{\"name\": \"강감찬\", \"age\": 30}";
		// Json문자열, 변환타입
		Person person2 = gson3.fromJson(jsonStr2, Person.class);
//		System.out.println(person2);
		
		// List객체를 Json문자열로 변환
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("홍길동", 30));
		personList.add(new Person("강감찬", 40));
		personList.add(new Person("이순신", 50));
		String jsonStr3 = gson3.toJson(personList);
//		System.out.println(jsonStr3);
		
		// Json문자열을 List객체로 변환
		List<Person> personList2 
			= gson3.fromJson(
					jsonStr3,
					new TypeToken<ArrayList<Person>>() {}.getType()
			  );
//		personList2.stream().forEach(System.out::println);
		
		// Map객체를 Json문자열로 변환
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "유관순");
		map.put("age", "20");
		map.put("gender", "여성");
		String mapStr = gson3.toJson(map);
		// System.out.println(mapStr);
		
		// Json문자열을 Map객체로 변환
		Map<String, String> map2 = gson3.fromJson(mapStr, Map.class);
		for(Map.Entry<String, String> entry : map2.entrySet()) {
//			System.out.println(entry.getKey() + ", " + entry.getValue());
		}
		
		// 실습 : Person들의 Map을 생성해서 Json문자열로 변환 후 다시 Map으로 변환
		Map<String, Person> personMap = new HashMap<String, Person>();
		personMap.put("1번", new Person("홍길동1", 10));
		personMap.put("2번", new Person("홍길동2", 20));
		personMap.put("3번", new Person("홍길동3", 30));
		String personMapStr = gson3.toJson(personMap);
//		 System.out.println(personMapStr);
		
		Map<String, Person> personMap2 
			= gson3.fromJson(
				personMapStr, 
				new TypeToken<HashMap<String, Person>>() {}.getType()
			);
//		System.out.println(personMap2);
//		for(Map.Entry<String, Person> entry : personMap2.entrySet()) {
//			System.out.println(entry.getKey() + ", 이름: " + entry.getValue().getName() + ", 나이: " + entry.getValue().getAge());
//		}
		
		
		
	} // main
	
} // class
