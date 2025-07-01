package pub2504.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) {
		
		// 클라이언트 소켓
		Socket clientSocket = null;
		
		// 서버에 문자를 송신할 문자 출력 스트림
		PrintWriter pw = null;
		
		// 서버에서 보낸 문자를 수신할 문자 입력 스트림
		BufferedReader br = null;
		
		try {
			
			// 클라이언트 소켓 생성
			clientSocket = new Socket("192.168.8.6", 5000); // 서버IP, 포트번호
			
			// 클라이언트 소켓에서 바이트출력스트림을 얻어서 문자출력스트림으로 변환한 후
			// PrintWriter로 반환
			pw = new PrintWriter(
				new OutputStreamWriter(clientSocket.getOutputStream(), "UTF-8")
			);
			
			pw.println("클라이언트가 보낸 메세지: TCPServer 하이!");
			pw.flush();
			
			// 서버에서 보낸 문자열 입력 스트림
			// 클라이언트 소켓에서 바이트 입력스트림을 얻어서 문자입력스트림으로 변환한 후
			// BufferedReader로 반환
			br = new BufferedReader(
				new InputStreamReader(clientSocket.getInputStream(), "UTF-8")
			);
			
			System.out.println("서버가 보낸 메세지 : " + br.readLine());
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				br.close();
				pw.close();
				clientSocket.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}
	
}
