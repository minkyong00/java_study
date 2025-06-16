package pub2504.exception;

public class ExceptionMain1 {
	
	public static void main(String[] args) {
		
		try { // 예외발생 가능성이 1이라도 있다면 try 블럭 내에 코드를 위치 시켜야함

			int[] iarr = {1, 2, 3, 4, 5};
			// ArrayIndexOutOfBoundsException 발생
			// 배열의 length가 5(인덱스 범위가 0~4)인데 인덱스 5를 참조함
			int i1 = iarr[5];
			
			// NumberFormatException 발생
			// 정수 변환 시 문자열 형식이 잘못됨
			int i2 = Integer.parseInt("백");
			
			// ArithmeticException 발생
			// 수학에서 0으로 나눌 수 없음
			int i = 10 / 0;
			
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("ArrayIndexOutOfBoundsException 처리함!");
		} catch (NumberFormatException nfe) {
			System.out.println("NumberFormatException 처리함!");
		} catch (ArithmeticException ae) {
			System.out.println("ArithmeticException 처리함!");
		} catch (Exception ex) {
			// 하위에 Exception으로 예외처리하는 건 괜찮음 
			System.out.println(ex + "처리함");
		} finally {
			System.out.println("예외 발생여부와 관계없이 수행하는 코드 블럭");
		}
		
		System.out.println("예외 처리 후 계속 수행 코드들....");
		
	} // main
	
} // class
