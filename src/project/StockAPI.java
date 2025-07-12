package project;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



public class StockAPI {
	private static final String STOCK_API = "https://apis.data.go.kr/1160100/service/GetStocDiviInfoService/getDiviInfo?serviceKey=bafEXsp3A%2FiNM6SrdTReCSgGSp3PZcxqoiD08onBtPTnKgLGfaCfkXnJa15dbR8zVjWpmN99qG5QMrpT%2FjWbuQ%3D%3D&pageNo=1&numOfRows=100&resultType=json&isinCd=KR7005930003";
	
	// 통신 객체 (HTTP Client : HTTP 요청을 보내고 응답받는 객체)
	private static final OkHttpClient client = new OkHttpClient();
	// Gson 객체
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	// 생성자 함수
	public StockAPI() {
	}
	
	// 공공데이터 API GET 요청 파라미터에 원하는 데이터 값 가져올 수 있게 작성
	public static List<String> getApi(String str) {
		// request 요청 객체 만들기
		Request request = new Request.Builder().url(STOCK_API).build();
		// return 할 List를 여기에 생성
		List<String> cashDvdList = new ArrayList<String>();
		
		try {
			// client response
			Response response = client.newCall(request).execute();
			// 응답 요청 json에 저장
			String json = Objects.requireNonNull(response.body()).string();
			// 아래에서 getAsJson으로 item 추출하기 위해 json 객체로 변환
			JsonObject jsonObj = gson.fromJson(json, JsonObject.class);
			// item 키를 jsonarray로 변경
	        JsonArray itemArray = jsonObj
	                .getAsJsonObject("response")
	                .getAsJsonObject("body")
	                .getAsJsonObject("items")
	                .getAsJsonArray("item");
			
	        // item 배열에서 원하는 요소를 리스트화 시키기
	        cashDvdList = itemArray.asList().stream()
	        .map(JsonElement::getAsJsonObject)
	        .map(obj -> obj.get(str).getAsString())
	        .collect(Collectors.toList());
	        
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
		// List 리턴
		return cashDvdList;
	} // getApi

	
	// 배당기준일
	// String인 날짜를 Date로 변환 후 List에 담음
	public static List<Date> getExDate() {
		
		// 연도월일로 날짜 format
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		// date 담을 ArrayList 생성
		List<Date> dateList = new ArrayList<Date>();
		// 배당 기준일을 문자열로 된 날짜를 가져와서
		dateList = StockAPI.getApi("dvdnBasDt").stream()
			.filter(day -> !day.isEmpty()) // null 제외
			.map(day -> {
				try {
					return sdf.parse(day.toString()); // format으로 date로 변경
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return null;
			}).toList();
		
		return dateList; // dateList로 반환
	} // getExDate
	
} // class