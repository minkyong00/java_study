package pub2504.exception;

public class ExceptionMain3 {

	public static void main(String[] args) {
		
		int age = (int)(Math.random()*20) + 10; // 10 ~ 29 임의의 정수
		System.out.println("나이 : " + age);
		
		try {
			if(age < 15) {
				throw new Under15Exception();
			} else if(age < 19) {
				throw new Under19Exception();
			} else {
				System.out.println("20세 이상이므로 통과!");
			}
		} catch (Under15Exception u15e) {
			System.out.println(u15e);
		} catch (Under19Exception u19e) {
			System.out.println(u19e);
		}
		
		System.out.println("즐거운 관람되세요!");
		
	} // main
} // class