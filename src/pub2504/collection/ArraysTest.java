package pub2504.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraysTest {
	
	public static void main(String[] args) {
	
		Integer[] intArr1 = {10, 5, 9, 3, 1};
		
		// 배열을 리스트로 변환
		// asList안에는 가변인자가 들어감
		List<Integer> intList = Arrays.asList(intArr1);
		System.out.println(intList);
		
		Integer[] intArr2 = {1, 20, 5, 9, 3, 2, 7, 4, 15, 9, 6};
		
		// 배열 정렬
		Arrays.sort(intArr2, new Comparator<Integer>() {
		
			@Override
			public int compare(Integer i1, Integer i2) {
				return i2 - i1;
			}
		});
		for(Integer i : intArr2) {
			System.out.println(i + " ");
		}
		
		Integer[] intArr3 = {10, 5, 9, 3, 1};
		Integer[] intArr4 = {1, 20, 5, 9, 3, 2, 7, 4, 15, 9, 6};
		
		// 배열 비교
		// 앞이 크면 음수, 같으면 0, 뒤가 크면 양수
		System.out.println(Arrays.compare(intArr3, intArr4));
		
		
		// 배열 카피 (개수만큼 카피)
		Integer[] intArr5 = Arrays.copyOf(intArr4, 3);
		for(Integer i : intArr5) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		// 배열 카피 (범위만큼 카피)
		Integer[] intArr6 = Arrays.copyOfRange(intArr4, 1, 4);
		for (Integer i : intArr6) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		// 배열 채우기
		Integer[] intArr7 = new Integer[5];
		Arrays.fill(intArr7, 3);
		for(Integer i : intArr7) {
			System.out.print(i + " ");
		}
		
	}

}
