package pub2504.network;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

// ChatGPT 서버에 프롬프트 보내고 결과 응답
// 1. 라이브러리 : jackson-databind-2.19.1, jackson-core-2.19.1,
//                    jackson-annotations-2.19.1, okhttp 3.14.9, okio3.13.0
// 2. OpenAI API 키 (https://platform.openai.com)
//     키발급 : 계정아이콘 > your profile > 좌측메뉴 API keys

public class OpenAIChatbot {
    private static final String API_KEY = System.getenv("OPEN_API_KEY"); // OpenAI API 키 입력
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";

    public static void main(String[] args) throws IOException {
       
        String prompt = "개와 고양이의 생물학적 차이점을 알려줘!";

        String response = getChatGPTResponse(prompt);
        System.out.println("ChatGPT 응답: " + response);
    }

    // 프롬포트 입력받아 ChatGPT 응답을 문자열로 반환하는 메소드
    public static String getChatGPTResponse(String prompt) throws IOException {
        
    	// Http통신 라이브러리, Http Client
    	OkHttpClient client = new OkHttpClient();
    	
    	// Jackson 라이브러리, 객체와 JSON 매핑
        ObjectMapper objectMapper = new ObjectMapper();

        // JSON 요청 본문 구성
        // model : ChatGPT버전
        // messages : role - system: ChatGPT 역할부여,
        //                   assistant: 이전 응답을 다음 요청에 기억해서 반영,
        //                   user: 프롬포트 (content에 프롬포트를 넣어 줌)
        // max_tokens : 최대 토큰(단어) 수
        String json = "{"
                + "\"model\": \"gpt-4o\","
                + "\"messages\": [{\"role\": \"system\", \"content\": \"You are a helpful assistant.\"},"
                + "{\"role\": \"user\", \"content\": \"" + prompt + "\"}],"
                + "\"max_tokens\": 350"
                + "}";
        System.out.println(json);

        // 요청바디 : 요청하는 데이터 타입과 요청데이터
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);

        // HTTP 요청 구성
        Request request = new Request.Builder()
                .url(API_URL) // 요청URL
                .header("Authorization", "Bearer " + API_KEY) // 인증키
                .header("Content-Type", "application/json") // 요청메세지가 JSON
                .post(body) // 요청바디에 메세지 추가
                .build(); // 요청 구성

        // 응답 처리
        // 요청 실행해서 응답 획득
        try (Response response = client.newCall(request).execute()) {
            // 응답실패 시 예외 처리
        	if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        	
        	// 요청 문자열을 JsonNode객체로 변환
            JsonNode jsonResponse = objectMapper.readTree(response.body().string());
            // 응답 문자열을 리턴
            return jsonResponse.get("choices").get(0).get("message").get("content").asText();
        }
    }
    
}
