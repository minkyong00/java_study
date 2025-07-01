package pub2504.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPClient {

	public static void main(String[] args) {
		
		try {
			
			// 수신 포트
			int PORT = 9876;
			
			// 브로드캐스트 수신용 DatagramSocket
			DatagramSocket socket = new DatagramSocket(PORT);
			
			// 문자열 저장할 배열
			byte[] byteArr = new byte[1024];
			
			while(true) {
				
				// 수신용 DatagramPacket
				DatagramPacket packet = new DatagramPacket(byteArr, byteArr.length);
				
				System.out.println("수신 대기중...(포트:" + PORT + ")");
				
				// DatagramPacket 수신 대기
				socket.receive(packet);
				
				// 받은 문자열
				String receivedData = new String(packet.getData(), 0, packet.getLength());
				
				System.out.println("[" + packet.getAddress() + "] 가 보낸 메세지");
				System.out.println("받은 문자열 : " + receivedData);
				
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	} // main
	
} // class
