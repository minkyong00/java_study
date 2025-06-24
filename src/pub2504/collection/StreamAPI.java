package pub2504.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 [Stream API]
 - Java8부터 도입
 - 컬렉션의 요소들을 함수형 방식으로 처리할 수 있도록 지원하는 API
 - 반복문을 사용하는 방식보다 가독성, 선언적 코드 스타일, 병렬처리 용이성의 장점을 제공
 - Stream(스트림)이란 데이터 흐름
 - 컬렉션과 배열 등에서 스트림을 얻어 다양한 처리가 가능
 - 스트림은 한번만 소비가 가능 (지나간 스트림은 돌아오지 않는다)
 - 중간연산(Intermediate Operation)과 최종연산(Terminal Operation)으로 구성
 - Stream API 구성
   생성 : 컬렉션, 배열 등에서 스트림 생성 예)list.stream()
   중간연산 : 스트림을 변환 예) filter(), map() ...
   최종연산 : 결과 도출 예) collect(), forEach() ...
 - 중간연산 메소드
   filter() : 조건에 맞는 요소를 필터링 예) stream.filter(s -> s.length()>3)
   map() : 요소를 변환 예) stream.map(String::toUpperCase) //:: 메소드 참조
   sorted() : 요소 순서 정렬 예) stream.sorted()
   distinct() : 요소 중복 제거 예) stream.distinct()
   limit(n) : n개 요소만 추출 예) stream.limit(5)
   skip(n) : 처음에 나오는 n개 건너뛰기 예) stream.skip(2)
   peek() : 디버깅용 중간처리 예) stream.peek(System.out::println) // 앞에 클래스객체 :: 메소드
 - 최종연산 메소드
   forEach() : 각 요소에 대해 작업 수행 예)  stream.forEach(System.out::println)
   collect() : 연산 결과를 수집 예) stream.collect(Collectors.toList())
   reduce() : 누적 연산 예) stream.reduce("", String::concat)
   count() : 요소 수 반환 예) stream.count()
   anyMatch() : 조건을 만족하는 요소 존재하는 지 여부 예) stream.anyMatch(s -> s.contains("Java")) // 자바를 포함한 게 한개라도 있는지
   allMatch() : 전체 요소가 모두 조건을 만족하는 지 여부 예) stream.allMatch(s -> s.length()>0)
   noneMatch() : 조건을 만족하는 요소가 없는지 여부 예) stream.noneMatch(s -> s==null) // null인게 없는지 확인(없어야 함)
   findFirst() : 첫 번째 요소 반환 예) stream.findFirst()
*/

public class StreamAPI {

	public static void main(String[] args) {

		// Stream 생성
		List<String> strList = Arrays.asList("Java", "Python", "C++");
		Stream<String> strStream = strList.stream(); // 단일 스트림
		Stream<String> parallelStream = strList.parallelStream(); // 병렬 스트림
		
		// 배열로 스트림 생성
		String[] sArr = {"Java", "Hello", "Hi", "Thanks", "Sorry"};
		Stream<String> sArrStream = Arrays.stream(sArr);

		// 수집결과를 List, Set, Map으로 만들기
		List<String> sList = sArrStream.collect(Collectors.toList());
		System.out.println(sList);
		
		sArrStream = Arrays.stream(sArr);
		Set<String> sSet = sArrStream.collect(Collectors.toSet());
		System.out.println(sSet);
		
		sArrStream = Arrays.stream(sArr);
		Map<String, Integer> sMap 
		 = sList.stream().collect(Collectors.toMap(str->str, str->str.length()));
		System.out.println(sMap);
		
		// 그룹핑
		List<String> gList = Arrays.asList(
			"apple", "banana", "kiwi", "pear", "grape", "melon", "peach"
		);
		Map<Integer, List<String>> groupedByLength
			= gList.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(groupedByLength);
		
		// 집계
		long count = gList.stream().collect(Collectors.counting());
		System.out.println(count);
		
		// 병렬 처리 (데이터가 많은 경우 효율이 있음, 최소한 몇만건 이상)
		gList.parallelStream()
			.filter(s->s.length()>=5)
			.forEach(System.out::println);
		
		// 메소드 체이닝
		List<String> nameList 
			= Arrays.asList("홍길동", "강감찬", "홍길동", "이순신", "최영", "권율");
		List<String> resultList
		 = nameList.stream() // nameList를 스트림을 변환
			.filter(name -> name.length()>=3) // 3글자 이상인 이름만 필터링
			.distinct() // 중복 제거 (구별)
			.sorted() // 오름차순 정렬 - 인자에 Comparator 구현하면 내림차순 정렬 가능
			.map(name-> name+"님") // 이름에 "님" 붙임
			.collect(Collectors.toList()); // 최종결과를 리스트로
		System.out.println(resultList);
		
		// 실습 : 아래 학생리스트에서 점수가 70점 이상인 학생들의 리스트를 출력
		class Student{
			private String name;
			private int score;
			public Student() {
			}
			public Student(String name, int score) {
				this.name = name;
				this.score = score;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public int getScore() {
				return score;
			}
			public void setScore(int score) {
				this.score = score;
			}
		}
		
		List<Student> studentList = Arrays.asList(
			new Student("홍길동", 90),
			new Student("강감찬", 100),
			new Student("이순신", 60),
			new Student("최영", 70)
		);
		
		List<String> resultList1 = studentList.stream()
			.filter(stu -> stu.getScore()>=70)
			.map(Student::getName)
			.collect(Collectors.toList());
		System.out.println(resultList1); // [홍길동, 강감찬, 최영]
		resultList1.stream().forEach(System.out::println); // 하나씩 출력됨
	}
	
}
