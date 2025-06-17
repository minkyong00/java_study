package pub2504.oop;

public class Person {

	private String name; // 이름
	private String job; // 직업
	private int age; // 나이
	private float height; // 키
 
	public Person() {
	}

	public Person(String name) {
		// 모든 생성자 첫째줄은 상위 생성자 : super()
		this.name = name;
	}

	public Person(String name, String job) {
		this(name);
		this.job = job;
	}

	public Person(String name, String job, int age) {
		this(name, job);
		this.age = age;
	}

	public Person(String name, String job, int age, float height) {
		this(name, job, age);
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "이름: " + name + ", 직업: " + job + ", 나이: " + age + ", 키: " + height;
	}
	
}
