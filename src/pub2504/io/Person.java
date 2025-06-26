package pub2504.io;

import java.io.Serializable;

/*
  [직렬화 단계]
  1. 클래스가 java.io.Serializable 인터페이스를 구현
  2. serialVersionUID 생성
  3. 기본값으로 직렬화(직렬화시에 데이터를 은닉)할 변수 앞에는 transient 붙임
*/

public class Person implements Serializable {

	private static final long serialVersionUID = 6531565215316354312L;

	// String은 Serializable 구현하고 있는 클래스, 직렬화 가능
	private String name;
	// 모든 기본타입은 직렬화 가능
	private int age;
	// transient 키워드가 붙으면 타입의 기본값으로 직렬화됨
	private transient String ssn;

	public Person() {
	}

	public Person(String name, int age, String ssn) {
		this.name = name;
		this.age = age;
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
