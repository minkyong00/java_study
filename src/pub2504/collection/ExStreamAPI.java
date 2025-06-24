package pub2504.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/*
	[Stream API 실습]
	
*/

public class ExStreamAPI {

	public static void main(String[] args) {
		
	List<Student> students = Arrays.asList(
		new Student("Alice", 85),
		new Student("Bob", 67),
		new Student("Charlie", 90),
		new Student("David", 75),
		new Student("Eve", 90),
		new Student("Frank", 45),
		new Student("Bob", 67),
		new Student("Grace", 70)
	);
			
	List<String> resultStudent = students.stream()
			
		// 4-1. 성적 내림차순
		// .sorted(Comparator.comparing(Student::getScore).reversed())
		
		// 70점 이상인 학생들
		.filter(student->student.getScore()>=70)
		
		// 이름을 대문자로 변경, String으로 변경됨
		.map(s-> s.getName().toUpperCase())
		
		// 중복 제거
		.distinct()
		
		// 이름 내림차순 정렬
//		.sorted(Comparator.reverseOrder())
		
		// 처음 한명 건너뛰기
		.skip(1)
		
		// 3명만 추출
		.limit(3)
		
		// 중간값 출력
		.peek(n -> System.out.println("Peek: " + n))
		
		// 리스트 수집
		.collect(Collectors.toList());
	
	resultStudent.stream().forEach(System.out::println);
	
	// 학생 수 출력
	System.out.println(resultStudent.stream().count());
	
	// 평균 점수 출력
//	Integer sum = students.stream().map(s-> s.getScore()).reduce(0, (a,b) -> a+b);
//	long count = students.stream().count();
//	System.out.println(sum/count);
	
	System.out.println(students.stream().collect(Collectors.averagingInt(Student::getScore)));
	
	// 최대 점수 출력
	System.out.println(
			students.stream().mapToInt(Student::getScore).max().orElse(0)
	);
	
	// 최소 점수 출력
	System.out.println(
			students.stream().mapToInt(Student::getScore).min().orElse(0)
	);
	
	// 100점인 학생이 있는지? 모두 30점 이상인지? 음수인 점수가 없는지?
	System.out.println(
		students.stream().anyMatch(s -> s.getScore()==100)
		? "100점인 학생 있음" : "100점인 학생 없음"
	);
	System.out.println(
		students.stream().allMatch(s -> s.getScore()>=30)
		? "전체가 30점 이상" : "전체가 30점 이상 아님"
	);
	System.out.println(
		students.stream().noneMatch(s -> s.getScore()<0)
		? "음수인 정수 없음" : "음수인 정수 있음"
	);
	
	// 점수가 70점에서 80점 사이인 사람 중 첫번째 학생
	// findFirst()의 반환타입은 Optional<Object> : null방지 Object
	// Optional에서 원래 값 추출하려면 get()
	System.out.println(
		students.stream().filter(stu -> stu.getScore()>=70 && stu.getScore()<=80)
		.map(s -> s.getName()).findFirst().get()
	);
	
	// 점수의 총합
	System.out.println(
//		students.stream().mapToInt(Student::getScore).reduce(0, (a,b) -> a+b)
		students.stream().mapToInt(Student::getScore).reduce(0, Integer::sum)
	);
	
	// 중복을 제거하고 점수별로 그룹핑된 학생 이름를 출력
	// 객체의 중복값을 제거할려면 Student 클래스에서 eqals, hashcode 오버라이딩해서 비교해야함
	Map<Integer, List<String>> grouped
	 = students.stream()
	   .distinct()
	   .collect(
		   Collectors.groupingBy(
				   Student::getScore, 
				   Collectors.mapping(Student::getName, Collectors.toList())
	   ));
	
	grouped.forEach((score, names) -> {
		System.out.println("점수: " + score + ", 학생: " + names);
	});
	
		
	} // main
} // class
