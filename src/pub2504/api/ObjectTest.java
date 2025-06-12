package pub2504.api;

public class ObjectTest {

	public static void main(String[] args) {
		
		Object obj = new Object();
		//java.lang.Object@5ca881b5 (4btye) 참조값을 16진수로 변환, 10진수로 변환한게 hashCode
		// Object클래스의 toString메소드가 호출됨
		// toString : getClass().getName() + "@" + Integer.toHexString(hashCode())
		System.out.println(obj); // obj 뒤에 .toString() 생략됨
		
		Object obj2 = new Object();
		//java.lang.Object@24d46ca6
		// 위 obj의 참조값과 obj2의 참조값은 다름 = 메모리의 다른 곳에 위치함 = 다른 객체
		System.out.println(obj2);
		
		// equals : 두 객체의 동일성 비교 (두 객체가 동일하다는 건 메모리의 같은 위치에 있음)
		System.out.println(obj.equals(obj2));
		
		// getClass : 객체 > 클래스의 정보 획득 (Reflection)
		Class objClass = obj.getClass();
		System.out.println(objClass.getPackageName()); // java.lang
		System.out.println(objClass.getCanonicalName()); // java.lang.Object
		System.out.println(objClass.getName()); // java.lang.Object
		System.out.println(objClass.getSimpleName()); // Object
		System.out.println(objClass.getTypeName()); // java.lang.Objects
		
		// hashCode : 참조값을 10진수 int로 반환
		System.out.println(obj.hashCode());
		System.out.println(obj2.hashCode());
		
		// clone: 동일한 내용(비트패턴)을 가진 다른 객체를 생성
		// 1. clone할 객체의 클래스는 Clonable 인터페이스를 구현 해야 함
		// 2. clone할 객체의 클래스는 Object의 clone메소드를 오버라이디이 헤야 함
		// 3. clone메소드 호출시에는 CloneNotSupportedException을 처리해야함
		// clone의 목적은 생성된 객체와 동일한 내용의 객체를 빠르게 생성하기 위함
		
		Person orgPerson = new Person("홍길동", 20);
		try {
			Person clonePerson = (Person)orgPerson.clone();
			System.out.println(clonePerson.name);
			System.out.println(clonePerson.age);
		} catch (CloneNotSupportedException cnse) {
			cnse.printStackTrace();
		}
		
	} //main
} // class
