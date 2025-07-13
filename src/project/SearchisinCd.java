package project;

import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

// isinCd 코드를 확인할 수 있는 api
public class SearchisinCd {
	private static final String SearchisinCd_API = "https://apis.data.go.kr/1160100/service/GetKrxListedInfoService/getItemInfo?serviceKey=nmjkcT8Dth%2Bs3Q7J%2Bfcbmh1FyAubIheEp81tQdV4b2LI1wHb2vTHbJu7YhGfjr95utZM5szJSjuEdfAZipJrHQ%3D%3D&numOfRows=1&pageNo=1&resultType=json&itmsNm=";

	// 통신 객체 (HTTP Client : HTTP 요청을 보내고 응답받는 객체)
	private static final OkHttpClient client = new OkHttpClient();
	// Gson 객체
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

	// 생성자 함수
	public SearchisinCd() {
	}

	/*
	 * IsinCd 를 가져오는 api get 요청 메소드
	 */
	public String getIsinCd(String itmsNm) {

		// request 요청 객체 만들기 itmsNm 파라미터에 원하는 종목명을 입력
		Request request = new Request.Builder().url(SearchisinCd_API + itmsNm).build();
		// return 할 isinCd 변수 초기화
		String isinCd = null;

		try {
			// client response
			Response response = client.newCall(request).execute();
			// 응답 요청 json에 저장
			String json = Objects.requireNonNull(response.body()).string();
			// 아래에서 getAsJson으로 item 추출하기 위해 json 객체로 변환
			JsonObject jsonObj = gson.fromJson(json, JsonObject.class);
			// item 키를 jsonarray로 변경
			JsonArray itemArray = jsonObj.getAsJsonObject("response").getAsJsonObject("body").getAsJsonObject("items")
					.getAsJsonArray("item");

			// 배열 안에 1개의 요소를 객체화 시킨다음 해당 키를 가져와서 string 화 한다.
			isinCd = itemArray.get(0).getAsJsonObject().get("isinCd").getAsString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isinCd;
	} // getIsinCd()

} // class
