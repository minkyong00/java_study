package pub2504.network;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/*

[공공API 활용 실습2]
역명 입력하면 해당 역의 시간표 출력
역명_timetable.csv로 저장
*/

public class ExPubAPI2 {
	
	private static String subwayCode = "";
	private static String subwayName = "";

	private static final String REQUEST_CODE_URL 
	= "http://openapi.seoul.go.kr:8088/46644750596d696e3832594e516569/json/SearchInfoBySubwayNameService/1/5/";

	private static final String REQUEST_URL 
    = "http://openapi.seoul.go.kr:8088/64414f66516d696e37376853656444/json/SearchSTNTimeTableByIDService/1/";
 
	private static final HttpClient client = HttpClient.newHttpClient();
	
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	public static void main(String[] args) {
		
		PrintWriter pw = null;
		OutputStreamWriter osw = null;
		
		try {
			
			subwayCode = getSubwayCode("선릉").get(0);
			subwayName = getSubwayCode("선릉").get(1);
			
			File file = new File("C:\\pub2504\\files\\" + subwayName + "_timetable.csv");
			// fileWriter를 만들 때 캐릭터셋을 지정해주지 않으면 운영환경에 따라 바뀜
			// -> csv 파일 한글이 깨짐
			osw = new OutputStreamWriter(new FileOutputStream(file), Charset.forName("EUC-KR"));
			List<String[]> data = getAPIData(getSubwayTimeCount());
			osw.write("출발시간,도착시간,종착역\n");
			System.out.println("출발시간,도착시간,종착역");
			for(String[] line : data) {
				osw.write(String.join(",", line) + "\n");
				System.out.println(String.join(",", line));
			}
			osw.close();
			
			System.out.println(test("선릉").get(0));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// api jsonObject로 변환
	private static JsonObject getJsonObect(String url, String api) throws Exception {
		
		HttpRequest request = 
				HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
		
		HttpResponse<String> response 
			= client.send(request, HttpResponse.BodyHandlers.ofString());
		
		JsonObject jsonObject 
			= gson.fromJson(response.body(), JsonObject.class).getAsJsonObject(api);
		
		return jsonObject;
	} // getJsonObject
	
	// 열차 시간표 출력 메소드
	private static List<String[]> getAPIData(String count) throws Exception {
		
		String url = REQUEST_URL + count + "/" + subwayCode + "/1/1/";
		JsonArray jsonArray 
			= getJsonObect(url, "SearchSTNTimeTableByIDService").getAsJsonArray("row");
		
		List<String[]> strList = new ArrayList<String[]>();
		for(JsonElement e : jsonArray) {
			JsonObject obj = e.getAsJsonObject();
			strList.add(new String[] {
				obj.get("ARRIVETIME").getAsString(),
				obj.get("LEFTTIME").getAsString(),
				obj.get("SUBWAYSNAME").getAsString()
			});
		}
		return strList;
   } // getAPIData  
	
	
	private static JsonArray test(String subwayName) throws Exception {
		
		String url = REQUEST_CODE_URL + subwayName;
//		JsonObject stationObj 
//			= getJsonObect(url, "SearchInfoBySubwayNameService")
//				.get("row").getAsJsonArray()
//				.get(1).getAsJsonObject();
		
		JsonArray stationArr = getJsonObect(url, "SearchInfoBySubwayNameService")
				.get("row").getAsJsonArray();
		
//		List<String> strList = Arrays.asList(
//				stationObj.get("STATION_CD").getAsString(),
//				subwayName
//		);
		
		return stationArr;
	}
	
	// 지하철역 입력하면 지하철 코드 출력
	// 한 역에 다른 호선도 추가해야함
	private static List<String> getSubwayCode(String subwayName) throws Exception {
		
		String url = REQUEST_CODE_URL + subwayName;
		JsonObject stationObj 
			= getJsonObect(url, "SearchInfoBySubwayNameService")
				.get("row").getAsJsonArray()
				.get(1).getAsJsonObject();
		
//		JsonArray stationArr = getJsonObect(url, "SearchInfoBySubwayNameService")
//				.get("row").getAsJsonArray();
		
		List<String> strList = Arrays.asList(
			stationObj.get("STATION_CD").getAsString(),
			subwayName
		);
		
		return strList;
	} // getSubwayCode

	// 지하철역 시간표 전체 개수 출력
	private static String getSubwayTimeCount() throws Exception {
		//http://openapi.seoul.go.kr:8088/46644750596d696e3832594e516569/json/SearchInfoBySubwayNameService/1/5/선릉
		String url = REQUEST_URL + "120/" + subwayCode + "/1/1";
		String count 
			= getJsonObect(url, "SearchSTNTimeTableByIDService")
				.get("list_total_count").getAsString();
		return count;
	} // getSubwayTimeCount

}
