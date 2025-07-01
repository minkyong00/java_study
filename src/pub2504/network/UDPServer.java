package pub2504.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

	public static void main(String[] args) {
		try {
			
			// DatagramSocket 생성 (UDP 연결 담당)
			DatagramSocket socket = new DatagramSocket();
		
			// 브로드캐스트 설정 (유니캐스트-1:1 통신, 브로드캐스트-1:다 통신)
			socket.setBroadcast(true);
			
			// 브로드캐스트 메세지
			String message = "헬로우 에브리원";
			
			// 전송을 위해 문자열을 byte[]로 변환
			byte[] byteArr = message.getBytes();
			
			// 브로드캐스트 IP
			InetAddress broadcastIP
				= InetAddress.getByName("192.168.8.255");
			// 브로드캐스트 PORT
			int broadcastPort = 9876;
			
			// 전송데이터를 담은 DatagramPacket
			DatagramPacket packet = new DatagramPacket(
				byteArr, // 전송할 바이트 배열
				byteArr.length, // 바이트 배열의 길이
				broadcastIP, // 브로드캐스트 IP
				broadcastPort // 브로드캐스트 PORT
			); 
			
			// 전송
			socket.send(packet);
			
			System.out.println("브로드캐스트 완료");
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
}
