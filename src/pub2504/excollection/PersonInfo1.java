package pub2504.excollection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PersonInfo1 {
	
	public static void main(String[] args) {
		// 이름과 나이 3명 정보 받아 출력 (HashMap)
		System.out.println("이름과 나이 3개를 입력해주세요(형식: 이름,나이)");
		
		Map<String, String> personMap = new HashMap<String, String>();
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<3; i++) {
			String input = sc.next();
			personMap.put(
				input.substring(0, input.indexOf(',')),
				input.substring(input.indexOf(',')+1)
			);
		}
		
		// 엔트리셋 사용
//		Set<Map.Entry<String, String>> personSet = personMap.entrySet();
//		Iterator<Map.Entry<String, String>> it = personSet.iterator();
//		while(it.hasNext()) {
//			Map.Entry<String, String> person = it.next();
//			System.out.println(person.getKey() + "은 " + person.getValue() + "살");
//		}
		
		// 키셋 사용
		Set<String> keySet = personMap.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.printf("%s는 %s살\n", key, personMap.get(key));
		}
		
		sc.close();
		
	}
	
}
