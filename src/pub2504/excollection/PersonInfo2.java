package pub2504.excollection;

import java.util.ArrayList;
import java.util.List;

public class PersonInfo2 {
	
	public static void main(String[] args) {
		
		Person p1 = new Person("홍길동", 20);
		Person p2 = new Person("강감찬", 30);
		Person p3 = new Person("장보고", 40);
		
		List<Person> personList = new ArrayList<Person>();
		
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		
		for(Person person : personList) {
			System.out.println(person);
		}
		
	}

}
