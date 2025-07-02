package pub2504.network.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// 멀티 채팅 서버
public class ChatServer {
   
   // 클라이언트들의 리스트
   //  CopyOnWriteArrayList : 동기화 문제를 해결한 ArrayList
   private static List<ClientHandler> clients = new CopyOnWriteArrayList<ClientHandler>();
   
   public static void main(String[] args) {
      
      ServerSocket serverSocket = null;
      
      try {
      serverSocket = new ServerSocket(5000); // 서버 소켓
      System.out.println("서버 시작 클라이언트 대기 중");
      
      while(true) {
         // 클라이언트 접속을 받아들이면 클라이언트와 교신할 데이터소켓을 생성
         Socket dataSocket = serverSocket.accept();
         System.out.println("클라이언트 접속함 " + dataSocket);
         
         // 클라이언트 스레드 생성
         ClientHandler clientHandler = new ClientHandler(dataSocket, clients);
         clients.add(clientHandler); // 접속한 클라이언트를 리스트에 추가
         
         // 클라이언트 스레드 실행
         new Thread(clientHandler).start();
      } // while
      
      
      } catch (IOException ioe) {
         ioe.printStackTrace();
      }
      
      
   } // main
   

} // class
