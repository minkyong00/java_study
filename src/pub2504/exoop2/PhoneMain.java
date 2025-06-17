package pub2504.exoop2;

public class PhoneMain {
	
	public static void main(String[] args) {
		Application app = new Application("계산기", "Apple");
		Camera camera = new Camera("전면", "1200만", "디지털줌" );
		Display display = new Display("2560 × 1440","LED",17);
		Os os = new Os("ios","Apple",18);
		Storage storage = new Storage("ufs",128, 256);
		
		Phone phone = new Phone("애플", "iphone16", 8000, "KT", display, camera, storage, app, os);
		
		System.out.println(phone);
		System.out.println(display);
		System.out.println(camera);
		System.out.println(app);
		System.out.println(os);
		System.out.println(storage);
	}
}
