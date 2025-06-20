package pub2504.dp;

public class SingletonClassMain {

	public static void main(String[] args) {
		
		// 싱글턴 객체참조를 몇 개를 만들던 동일함!
		
		// 싱글턴 객체 생성
	 	SingletonClass obj1 = SingletonClass.getInstance();
	 	System.out.println(obj1.hashCode());
	 	
	 	// 싱글턴 객체 생성
	 	SingletonClass obj2 = SingletonClass.getInstance();
		System.out.println(obj2.hashCode());
		
	}
}
