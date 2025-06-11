package pub2504.basic;

public class ExArray3 {
	
	public static void main(String[] args) {
		// 총점이 200점 이상인 학생들의 학생명과 총점 출력
		String[][] studentArr = {
			{"홍길동", "90", "80", "70"},	
			{"강감찬", "80", "70", "60"},	
			{"이순신", "60", "50", "40"}
		};
		
		
		for(String[] stuArr : studentArr) {
			int kor = Integer.parseInt(stuArr[1]);
			int eng = Integer.parseInt(stuArr[2]);
			int math = Integer.parseInt(stuArr[3]);
			
			int scoreSum = kor + eng + math;
			if(scoreSum >= 200) {
				System.out.println("과목의 총점이 200점 이상인 학생 : " + stuArr[0] + ", 총점 : " + scoreSum);
			}
		}
	}
}
