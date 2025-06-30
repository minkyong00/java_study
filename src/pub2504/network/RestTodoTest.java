package pub2504.network;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/*
[HttpClient를 활용한 REST통신]
EndPoint : http://localhost:7777/todos
		   http://192.168.8.13:7777/todos
내부 IP:192.168.8.254(강사PC)
내부 IP:192.168.8.7
Node의 Json서버 실행 : npx json-server --watch todos.json --host 0.0.0.0 --port 7777 --static ./public
					 - host 0.0.0.0 : 모든 요청을 다 받음
* window 명령
  - ipconfig /all : 로컬PC IP확인
  - netstat -na | find "7777" : 7777포트 확인
*/

public class RestTodoTest {
	
	// 요청 URL
	private static final String REQUEST_URL = "http://192.168.8.7:7777/todos";

	// HTTP Client 생성
	private static final HttpClient client = HttpClient.newHttpClient();

	public static void main(String[] args) {
		
		try {
			
//			doGet();
			doPost();
//			doPut();
//			doDelete();
//			doPatch();
//			doGetId("2");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	} // main
	
	private static void doGet() throws Exception{
		// GET 요청 생성
		HttpRequest request = HttpRequest.newBuilder()
		  .uri(URI.create(REQUEST_URL)).GET().build();
		printResponse(request, "GET");
	} // doGet
	
	private static void doPost() throws Exception {
		String requestBody = "{\"id\":\"10\", \"todo\":\"할일 김민경 post 요청\", \"completed\":true}";
		HttpRequest request = HttpRequest.newBuilder()
		  .uri(URI.create(REQUEST_URL))
		  .header("Content-Type", "application/json")
		  .POST(HttpRequest.BodyPublishers.ofString(requestBody))
		  .build();
		printResponse(request, "POST");
	} // doPost
	
	private static void doPut() throws Exception {
		String requestBody = "{\"id\":\"5\", \"todo\":\"할일5 put 수정\", \"completed\":false}";
		HttpRequest request = HttpRequest.newBuilder()
		  .uri(URI.create(REQUEST_URL + "/5"))
		  .header("Content-Type", "application/json")
		  .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
		  .build();
		printResponse(request, "PUT");
	} // doPut
	
	private static void doDelete() throws Exception {
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(REQUEST_URL + "/10"))
			.DELETE().build();
		printResponse(request, "DELETTE");
	} // doDelete
	
	private static void doPatch() throws Exception {
		String requestBody = "{\"todo\":\"할일10 수정\", \"completed\":true}";
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(REQUEST_URL + "/10"))
			.header("Content-Type", "application/json")
			.method("PATCH", HttpRequest.BodyPublishers.ofString(requestBody))
			.build();
		printResponse(request, "PETCH");
	} //doPatch
	
	private static void doGetId(String id) throws Exception {
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(REQUEST_URL + "/" + id))
			.GET()
			.build();
		printResponse(request, "GET");
	} // doGetId
	
	private static void printResponse(HttpRequest request, String requestMethod) 
		throws Exception {
		// 응답 객체 생성
		HttpResponse<String> response
		  = client.send(request, HttpResponse.BodyHandlers.ofString());
		// 응답 상태 코드와 응답 문자열 출력
		System.out.println(requestMethod + " - Status: " + response.statusCode());
		System.out.println(requestMethod + " - Body: " + response.body());
	} // printResponse
	
}
