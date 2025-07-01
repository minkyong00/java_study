package pub2504.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		
		// 클라이언트 소켓의 접속을 대기했다가 클라이언트 소켓과 데이터를 주고 받을 
		// 서버측의 소켓을 생성해 주는 ServerSocket
		ServerSocket ss = null;
		
		// 클라이언트가 접속하면 클라이언트 소켓과 교신할 소켓
		BufferedReader br = null;
		
		// 클라이언트가 보낸 문자열을 입력받을 스트림
		PrintWriter pw = null;
		
		// 클라이언트에게 문자열을 출력할 스트림
		Socket dataSocket = null;
		
		try {
			
			// 서버소켓 생성
			ss = new ServerSocket(5000); // 서버소켓 포트번호
			if (ss != null) { // 서버소켓이 생성되었다면
				System.out.println("ServerSocket 생성됨! 클라이언트 접속 대기중!");
			}
			
			// 클라이언트 접속을 무한 대기
			while (true) {
				// 클라이언트 접속을 기다렸다가 접속하면 클라이언트 소켓과 교신할 서버측 소켓을 생성 
				// accept: 블로킹 메소드(blocking method): 클라이언트가 접속할 때까지 대기했다가
				// 		   접속을 하면 클라이언트 소켓과 교신할 소켓을 반환
				dataSocket = ss.accept();
				System.out.println("클라이언트 접속함!");
				System.out.println(dataSocket);
				
				if(dataSocket != null) {
					
					// 클라이언트가 보낸 문자열을 읽어들이는 스트림
					br = new BufferedReader(
						new InputStreamReader(dataSocket.getInputStream())
					);
					System.out.println(
						"클라이언트가 보낸 문자열 : [" + dataSocket.getInetAddress()
						 + "]" + br.readLine()	
					);
					
					pw = new PrintWriter(
						new OutputStreamWriter(dataSocket.getOutputStream())
					);
					pw.println("[" + dataSocket.getInetAddress() + "]님 안녕하세요!");
					pw.flush();
					
				} // if
				
			} // while
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				pw.close();
				br.close();
				dataSocket.close();
				ss.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	} // main
	
} // class
