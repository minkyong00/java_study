package pub2504.exception;

public class ExcetionTest3_1 {

	private static Person[] personArr = {
			new Person("홍길동", "산적"),
			new Person("강감찬", "장군"),
			new Person("이순신", "장군"),
			new Person("임꺽정", "산적"),
			new Person("권율", "장군"),
	};

	public static void main(String[] args) {
		// "홍길동/산적, 강감찬/장군, 이순신/장군, 임꺽정/산적, 권율/장군"
		// 의 이름과 직업을 가진 5명 생성
		// 직업이 산적인 Person이 생성되면 "좋은 직업을 선택하세요!"라는 JobException 발생
	
		checkJob(personArr);
	
	} // main
	
	private static void checkJob(Person[] personArr) {
		for(Person person : personArr) {
			if(person.job.equals("산적")) {
				try {
					throw new JobException();
				} catch (JobException je) {
					System.out.println(person.name + "님 " + je);
				}
			}
		}
	}
} // class
