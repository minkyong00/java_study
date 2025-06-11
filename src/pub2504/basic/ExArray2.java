package pub2504.basic;

public class ExArray2 {

	public static void main(String[] args) {
		// 학생 3명의 이름과 학점 (A~F)을 배열에 저장하고 학생명과 학점을 출력
		String[][] studentArr = {
			{"홍길동", "A"},	
			{"강감찬", "B"},	
			{"이순신", "F"}	
		};
		
		for(String[] stuArr : studentArr) {
			for(String student : stuArr) {
				System.out.println(student);
			}
		}
	}
}
