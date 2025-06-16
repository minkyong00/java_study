package pub2504.exception;

public class ExcetionTest3 {

	public static void main(String[] args) {
		// "홍길동/산적, 강감찬/장군, 이순신/장군, 임꺽정/산적, 권율/장군"
		// 의 이름과 직업을 가진 5명 생성
		// 직업이 산적인 Person이 생성되면 "좋은 직업을 선택하세요!"라는 JobException 발생
		
		Person[] personArr = {
			new Person("홍길동", "산적"),
			new Person("강감찬", "장군"),
			new Person("이순신", "장군"),
			new Person("임꺽정", "산적"),
			new Person("권율", "장군"),
		};
		
		int personArrLeng = personArr.length;
		
		for(int i=0; i<personArrLeng; i++) {
			if(personArr[i].job.equals("산적")) {
				try {
					throw new JobException();
				} catch (JobException je) {
					System.out.println(personArr[i].name + "님 " + je);
				}
			}
		}
			
		
//		makePerson("홍길동", "산적");
//		makePerson("강감찬", "장군");
//		makePerson("이순신", "장군");
//		makePerson("임꺽정", "산적");
//		makePerson("권율", "장군");
	
	} // main
	
	private static void makePerson(String name, String job) {
		if(new Person(name, job).job.equals("산적")) {
			try {
				throw new JobException();
			} catch (JobException je) {
				System.out.println(name + "님 " + je);
			}
		}
	}
	
} // class
