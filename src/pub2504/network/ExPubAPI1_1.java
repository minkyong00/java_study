package pub2504.network;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/*
[공공API 활용 실습 1]
- data.go.kr
- 기상청 오픈API
- 1) 2025년 6월 1일부터 6월 7일까지 서울지역 시간별 기온을 시간과 함께 출력
- 2) 날짜, 시간, 기온을 아래 형식으로 202506temp.csv로 저장
     형식) 2025/06/01,00:00,15.4c
            2025/06/01,01:00,14.5c
            ...
*/

public class ExPubAPI1_1 {
   
   private static final String REQUEST_URL 
      = "http://apis.data.go.kr/1360000/AsosHourlyInfoService/getWthrDataList?serviceKey=bafEXsp3A%2FiNM6SrdTReCSgGSp3PZcxqoiD08onBtPTnKgLGfaCfkXnJa15dbR8zVjWpmN99qG5QMrpT%2FjWbuQ%3D%3D&numOfRows=167&pageNo=1&dataCd=ASOS&dateCd=HR&stnIds=108&endDt=20250629&endHh=01&startHh=01&startDt=20250601&dataType=json";
   
   private static final HttpClient client = HttpClient.newHttpClient();   
   
   public static void main(String[] args) {
      
      
      try {
         
         String apiData = getAPIData();
         
         final PrintWriter pw = new PrintWriter(new FileWriter(
               new File("C:\\pub2504\\files\\202506temp.csv")
               ));         
         
         Gson gson = new GsonBuilder().setPrettyPrinting().create();
         JsonObject jsonObject = gson.fromJson(apiData, JsonObject.class);
         JsonArray jsonArray = jsonObject
            .get("response").getAsJsonObject()
            .get("body").getAsJsonObject()
            .get("items").getAsJsonObject()
            .get("item").getAsJsonArray();
         jsonArray.asList().stream().forEach(obj -> {
            final String line = 
               ((JsonObject)obj).get("tm").getAsString()
               .replaceAll("-", "/").replaceAll(" ", ",") 
               + "," + ((JsonObject)obj).get("ta").getAsString() + "C";
            System.out.println(line);
            pw.println(line);
         });
         pw.close();
         
      } catch (Exception ex) {
         ex.printStackTrace();
      } 
      
   }
   
   private static String getAPIData() throws Exception {
      HttpRequest request = HttpRequest.newBuilder()
         .uri(URI.create(REQUEST_URL)).GET().build();
      HttpResponse<String> response 
      = client.send(request, HttpResponse.BodyHandlers.ofString());
      return response.body();
   } // getAPIData   

}













