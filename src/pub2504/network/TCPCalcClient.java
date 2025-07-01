package pub2504.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

// [TCP 실습]
// 서버에 정수 2개와 연산자(+,-*,/)를 보내고
// 결과를 받아서 출력하는 TCP Client

public class TCPCalcClient {

	public static void main(String[] args) {
		
		Socket clientSocket = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		
		try {
			
			clientSocket = new Socket("192.168.8.7", 5000);
			
			pw = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream(), "UTF-8"));
			
			// printf 사용할 때 readLine으로 받을 경우 \n을 추가해야함
			// -> \n을 추가하지 않으면 readLine에서 읽을 때 줄이 끝나지 않음
			pw.printf("%d, %d, %s \n", 1, 2, "*");
			pw.flush();
			
			br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));
			System.out.println("서버가 보낸 메세지: " + br.readLine());
			
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				pw.close();
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
