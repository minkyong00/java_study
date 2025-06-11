package pub2504.basic;

public class MultiDimensionArray {

	public static void main(String[] args) {
		
		// 2차원 int배열 선언, 초기화
		int[][] intArr = new int[3][3]; // 행 인덱스(2차원 배열의 length), 열 인덱스(1차원 배열의 length), length 3, index범위 0~2 (2차원 배열)
//		int[] iArr = intArr[0]; // length 3, index범위 0~2 (1차원 배열)
		
		// 2차원 배열 값 할당
		intArr[0][0] = 1;
		intArr[0][1] = 2;
		intArr[0][2] = 3;
		intArr[1][0] = 4;
		intArr[1][1] = 5;
		intArr[1][2] = 6;
		intArr[2][0] = 7;
		intArr[2][1] = 8;
		intArr[2][2] = 9;
		
		// 2차원 배열내 1차원 배열의 모든 요소값 출력
		int intArrLength1 = intArr[0].length; // 1차원배열의 요소의 수
		int intArrLength2 = intArr.length; // 2차원배열의 요소의 수
		for(int i=0; i<intArrLength1; i++) {
			for(int j=0; j<intArrLength2; j++) {
				System.out.println(intArr[i][j]);
			}
		}
		
		// 2차원 배열 선언, 초기화, 할당 동시에
		int[][] intArr2 = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		
		for(int[] iArr : intArr2) {
			for(int j: iArr)
			System.out.println(j);
		}
		
		// 참조타입 2차원 배열
		String[][] strArr = {
			{"홍길동", "강감찬", "이순신"},
			{"서울", "부산", "제주"},
			{"학생", "직장인", "가수"}			
		};
		
		for(String[] sArr : strArr) {
			for(String s : sArr) {
				System.out.println(s);
			}
		}
		
		
	} // main
} // class
