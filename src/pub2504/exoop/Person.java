package pub2504.exoop;

public class Person {
	
	private String name;
	private String age;
	private String ssn;
	
	public Person() {
	}
	
	public Person(String name, String ageArr, String ssn) {
		this.name = name;
		this.age = ageArr;
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
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
		return this.getClass().getSimpleName() + " [name=" + name + ", age=" + age + ", ssn=" + ssn + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this.getName().equals(((Person)obj).getName()) 
				&& this.getSsn().equals(((Person)obj).getSsn()) 
				&& this.getAge().equals(((Person)obj).getAge())) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
