package pub2504.network.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;


// 요청 / 응답 처리하는 Thread

public class ClientHandler implements Runnable{
   
   private Socket clientSocket; // 클라이언트 소켓
   
   // ClientHandler는 Socket을 가지고 있음 = ClientHandler 하나가 클라이언트 한 명
   // List<ClientHandler> : 접속한 모든 클라이언트
   private List<ClientHandler> clients; 
   private PrintWriter out; // 클라이언트가 서버에 문자를 송신하는 스트림
   private BufferedReader in; // 서버가 보낸 문자를 수신하는 스트림
   
   public ClientHandler(Socket clientSocket, List<ClientHandler> clients) throws IOException{
      this.clientSocket = clientSocket;
      this.clients = clients;
      this.out = new PrintWriter(clientSocket.getOutputStream(), true);
      this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
   }
   
   @Override
   public void run() {
      
      try {
         
         String line = ""; // 서버에서 보내는 한 라인의 문자열을 저장 변수
         while ((line = in.readLine()) != null) { //서버에서 받는 문자열이 있는 동안 반복
            for(ClientHandler clientHandler : clients) {
               clientHandler.out.println(line); // 다른 클라이언트들에게 문자열을 전송
            }
         }
         
      } catch (IOException ioe) {
         System.out.println("클라이언트 종료! " + ioe.getMessage());
      } finally {
         try {
            in.close();
            out.close();
            clientSocket.close();
         } catch(IOException ioe) {
            ioe.printStackTrace();
         }
         clients.remove(this); // 클라이언트 종료시 List에서 제거
      }
      
   }
   

} //class
