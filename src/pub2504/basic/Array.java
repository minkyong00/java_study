package pub2504.basic;

public class Array {

	public static void main(String[] args) {
		
		// 배열 선언 : 배열변수명과 배열의 타입을 지정
		int[] intArr;
		// int intArr2[]; // 배열대괄호를 뒤에 쓰는 것도 가능하나 int타입으로 오인될 수 있어 비추!
		
		// 배열 초기화 : 배열요소의 개수만큼 메모리를 확보하고 각 요소의 기본타입의 값으로 초기화
		// 자바에서는 배열을 항상 초기화한 후 사용할 수 있음
		intArr = new int[5]; // 크기(요소의 수 = length)는 5, 인덱스범위는 0~4, 각 방에는 0이 들어있음
		System.out.println(intArr[0]); // 0번방의 값
		
		// 배열 값 할당 : 각 방에 값을 할당
		intArr[0] = 1;
		intArr[1] = 2;
		intArr[2] = 3;
		intArr[3] = 4;
		intArr[4] = 5;
		// runtime exception : ArrayIndexOutOfBoundsException
		// 0~4 인덱스까지 참조할 수 있는데 5 인덱스를 참조
		// intArr[5] = 6;
		
		// intArr 배열의 값을 for문으로 출력
		// 코드를 개선하고 좋은 코드를 만들려면 아래 책들을 읽어보자 
		// 마틴파울러 Refactoring, 마이크로소프트 Code Complete
		// length를 한번만 구하도록 변수로 만들어서 사용
		int intArrLength = intArr.length; // for문내에서 반복적으로 length를 구할 필요는 없음
		for(int i=0; i<intArrLength; i++) {
			System.out.println(intArr[i]);			
		}
		
		// 배열 선언, 초기화, 할당을 동시에
		int[] intArr3 = {1, 2, 3, 4, 5}; // length 5, index 0~4
		
		// 향상된 for (enhanced for)
		// 배열, 리스트내의 요소들을 반복하는 for문
		// 인덱스는 필요없고 요소들만 반복해서 추출할 때 사용
		for (int i : intArr3) {
			System.out.println(i);
		}
		
		// 참조타입 배열
		String[] strArr = {"hello", "java", "programming"};
		
		for(String str : strArr) {
			System.out.println(str);
		}
		
		
		
		
		
		
		
		
		
		
	} // main
} // class
