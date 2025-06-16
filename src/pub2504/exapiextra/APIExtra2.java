package pub2504.exapiextra;

public class APIExtra2 {

	public static void main(String[] args) {
		// "Hello Java"라는 문자열내의 문자들의 아스키코드값의 총합을 출력
//		String str = "Hello Java";
//		int strLeng = str.length();
//		int sum = 0;
//		for(int i=0; i<strLeng; i++) {
//			byte b = (byte)str.charAt(i);
//			sum += b;
//		}
//		System.out.println(sum);
		
		char[] charArr = Util.getLineText(1)[0].toCharArray();
		int sum = 0;
		for(char ch : charArr) {
			sum += (int)ch;
		}
		System.out.println("아스키코드 총합은 " + sum);
	}
}
