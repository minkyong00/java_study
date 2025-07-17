package model;

import java.io.IOException;
import java.util.ArrayList;
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

// 주식 배당금 정보 api를 담는 모델
public class StockDividendInfoModel {

	private static final String STOCK_API = "https://apis.data.go.kr/1160100/service/GetStocDiviInfoService/getDiviInfo?serviceKey=bafEXsp3A%2FiNM6SrdTReCSgGSp3PZcxqoiD08onBtPTnKgLGfaCfkXnJa15dbR8zVjWpmN99qG5QMrpT%2FjWbuQ%3D%3D&pageNo=1&numOfRows=100&resultType=json&isinCd=";

	// 통신 객체 (HTTP Client : HTTP 요청을 보내고 응답받는 객체)
	private static final OkHttpClient client = new OkHttpClient();
	// Gson 객체
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public StockDividendInfoModel() {
	}
	
	public static List<String> getApi(String str, String itmsNm) {

		String isinCd = StockInfoModel.getIsinCd(itmsNm);

		if (isinCd == null || isinCd.isEmpty()) {
			System.out.println("유효하지 않은 종목명입니다. " + itmsNm);
			return null;
		}

		// request 요청 객체 만들기
		Request request = new Request.Builder().url(STOCK_API + isinCd).build();
		// return 할 List를 여기에 생성
		List<String> cashDvdList = new ArrayList<String>();

		try {
			// client response
			Response response = client.newCall(request).execute();
			// 응답 요청 json에 저장
			String json = Objects.requireNonNull(response.body()).string();
//			System.out.println(request.url());
			// 아래에서 getAsJson으로 item 추출하기 위해 json 객체로 변환
			JsonObject jsonObj = gson.fromJson(json, JsonObject.class);
			// item 키를 jsonarray로 변경
			JsonArray itemArray = jsonObj.getAsJsonObject("response").getAsJsonObject("body").getAsJsonObject("items")
					.getAsJsonArray("item");

			// item 배열에서 원하는 요소를 리스트화 시키기
			cashDvdList = itemArray.asList().stream().map(JsonElement::getAsJsonObject)
					.map(obj -> obj.get(str).getAsString()).collect(Collectors.toList());

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		return cashDvdList;
	} // getApi
	

}
