package pub2504.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 클라이언트가 정수 2개와 연산자(+,-,*,/)를 보내면
// 연산결과를 클라이언트에게 보내주는 TCP Server

public class TCPCalcServer {

	public static void main(String[] args) {
		
		ServerSocket ss = null;
		Socket dataSocket = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			
			ss = new ServerSocket(5000);
		
			if(ss != null) {
				System.out.println("서버소켓 생성됨! 클라이언트 대기중..");
			}
			
			while (true) {
				dataSocket = ss.accept();
				
				if(dataSocket != null) {
					br = new BufferedReader(
							new InputStreamReader(dataSocket.getInputStream()));
					
					String brRead = br.readLine();
					System.out.println("클라이언트가 보낸 data: " + brRead);
					
					String[] calcs = brRead.split("\\,");
					int num1 = Integer.parseInt(calcs[0].trim());
					int num2 = Integer.parseInt(calcs[1].trim());
					String calc = calcs[2].trim();
					
					pw = new PrintWriter(
							new OutputStreamWriter(dataSocket.getOutputStream()));
					pw.println("연산 결과: " + num1 + calc + num2 + "=" + getCalc(num1, num2, calc));
					pw.flush();
					
				}
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				br.close();
				pw.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}
	
	// 연산 메소드
	private static int getCalc(int num1, int num2, String calc) {
		
		int result = 0;
		switch (calc) {
			case "+":
				result = num1 + num2;
				break;
			case "-":
				result = num1 - num2;
				break;
			case "*":
				result = num1 * num2;
				break;
			case "/":
				result = num1 / num2;
				break;
		}
		return result;
		
	}
	
}
