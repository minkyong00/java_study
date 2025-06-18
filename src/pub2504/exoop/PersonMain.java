package pub2504.exoop;

public class PersonMain {
	
	private static Person[] pArr = new Person[10];

	public static void main(String[] args) {
	
		// Person 램덤 객체 생성
		addPerson();
		
	} // main
	
	// 배열안에 들어갈 랜덤 숫자
	private static int randomNum() {
		return (int) ((Math.random() * 3) );
	}
	
	// 객체 10개 랜덤 생성
	private static Person[] addPerson() {
		
		String[][] strArr = {
				{ "홍길동", "이순신", "강감찬" },
				{ "20", "30", "40" },
				{ "000000-0000000", "111111-1111111", "222222-2222222" }
		};
		
		int nameArrLeng = strArr[0].length;
		
			// 1초마다 작업 수행
			int i = 0;
			try {
				while(i<10) {
					pArr[i++] = new Person(strArr[0][randomNum()], strArr[1][randomNum()], strArr[2][randomNum()]);
					if(isDup(pArr[i++])) {
						i--;
						continue;
					}
					Thread.sleep(1000); // 1000 밀리초동안 작업중지
				}
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		
		for(Person person : pArr) {
			System.out.println(person);
		}
		return pArr;
	}
	
	private static boolean isDup(Person person) {
	      for (int i=0; i<pArr.length; i++) {
	         if (pArr[i].equals(person)) {
	            System.out.println("이미 생성된 Person 입니다");
	            return true;
	         } else {
	            return false;
	         }
	      }
	      return false;
	   }
	
	
}
