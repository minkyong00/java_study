package pub2504.basic;

/*
 	Access Modifier (접근지정자 = 접근한정자 = 접근제한자)
 	자바에서는 접근제한자를 통해 클래스의 멤버 변수와 생성자, 멤버 메소드에 대한 접근 범위를
 	지정할 수 있다.
 	1. public : 모든 패키지에서 접근 가능
 	2. protected : 동일 패키지와 상속관계의 클래스에서 접근 가능
 	3. (default) : 동일 패키지 접근 가능
 	4. private : 동일 클래스에서 접근 가능
 	
 	접근범위 : public < protected > default > private
 			 --------------------> 접근 제한 강도 높음
 */

public class Variable3 {
	
	public int pubi = 1;
	protected int proi = 2;
	int di = 3;
	private int prii = 4;

}
