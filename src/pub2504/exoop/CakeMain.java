package pub2504.exoop;

public class CakeMain {

	public static void main(String[] args) {
		
		makeAndPrint("모카");
		makeAndPrint("초코");
		makeAndPrint("바나나");
		
	}
	
	private static void makeAndPrint(String cakeName) {
		Cake cake = new Cake() {
			
			@Override
			public void make() {
				System.out.println(cakeName + "케이크가 만들어 졌습니다!");
			}
		};
		cake.make();
	}
}
