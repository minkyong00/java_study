package pub2504.network.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.function.Consumer;

// 멀티채팅 클라이언트
public class ChatClient {

	private Socket socket; // 클라이언트 소켓
	private PrintWriter out; // 클라이언트에서 서버로 보내는 문자열 출력 스트림
	private BufferedReader in; // 서버에서 클라이언트에 보내는 문자열 입력 스트림
	private Consumer<String> onMessageReceived; // 문자열 소비자
	
	public ChatClient(String serverIP, int serverPort, Consumer<String> onMessageReceived)
		throws IOException {
		this.socket = new Socket(serverIP, serverPort); // 클라이언트 소켓 생성
		this.out = new PrintWriter(socket.getOutputStream(), true);
		this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		this.onMessageReceived = onMessageReceived;
	}
	
	// 서버에 문자열 출력하는 메소드
	public void sendMessage(String msg) {
		out.println(msg);
	}
	
	public void startClient() {
		
		new Thread(() -> {
			try {
				String line = ""; // 서버에서 받은 문자열 저장 변수
				// 서버에서 받은 문자열이 있는 동안 반복
				while((line=in.readLine()) != null) {
					onMessageReceived.accept(line);
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}).start();
		
	}
	
	public static void main(String[] args) throws IOException {
		
		// 클라이언트 객체 생성
		ChatClient client = new ChatClient("192.168.8.7", 5000, System.out::println);
		
		// 클라이언트 쓰레드 생성
		client.startClient();
		
		// 키보드를 통해 입력한 문자열의 입력 스트림
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while((line=in.readLine()) != null) { // 서버에서 받은 문자열이 있는 동안 반복
			client.sendMessage(line); // 서버로 문자열 전송
		}
		
	}
	
} // class
