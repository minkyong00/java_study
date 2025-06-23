package pub2504.collection;

import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		
		Map<Integer, String> stdMap = new HashMap<Integer, String>();
		
		// 엔트리 추가
		// 기본타입이 자동으로 참조타입으로 래핑됨 : 오토래핑 -> new Integer(1)이라 안쓰고 1로 써도 들어감
		// 키 중복안됨
		stdMap.put(1, "홍길동");
		stdMap.put(2, "장보고");
		stdMap.put(3, "이순신");
		stdMap.put(2, "강감찬"); // 기존 키를 사용해 저장하면 기존 값은 없어짐
		
		System.out.println(stdMap);
		
		// 키 포함 여부
		System.out.println(stdMap.containsKey(1));
		
		// 값 포함 여부
		System.out.println(stdMap.containsValue("유관순"));
		
		// 키에 해당하는 값 반환
		System.out.println(stdMap.get(3));
		
		// 엔트리가 없는지
		System.out.println(stdMap.isEmpty());
		
		// 맵에 맵을 추가
		Map<Integer, String> subMap = new HashMap<Integer, String>();
		subMap.put(4, "유관순");
		subMap.put(5, "권율");
		stdMap.putAll(subMap);
		System.out.println(stdMap);
		
		// 키에 해당하는 엔트리 제거
		stdMap.remove(1);
		System.out.println(stdMap);
		
		// 맵의 엔트리 수
		System.out.println(stdMap.size());
		
		// 모든 엔트리 제거
		subMap.clear();
		System.out.println(subMap);
		
		// 엔트리 셋
		Set<Map.Entry<Integer, String>> entrySet = stdMap.entrySet();
		
		// 엔트리 셋을 반복시키기 위한 반복자
		Iterator<Map.Entry<Integer, String>> it = entrySet.iterator();
		while(it.hasNext()) { // 다음번 반복할 요소가 있는 동안 반복
			Map.Entry<Integer, String> entry = it.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		// 실습 : 맵에서 키셋을 추출해서 키들을 반복 출력
		Set<Integer> keySet = stdMap.keySet();
		
		Iterator<Integer> it1 = keySet.iterator();
		while(it1.hasNext()) {
			System.out.println(it1.next());
		}
		
		// 맵에서 값들만 추출해서 값들을 반복 출력
		Collection<String> valueColl = stdMap.values();
		
		Iterator<String> it2 = valueColl.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		
	}
	
}
