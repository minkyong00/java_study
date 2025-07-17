package model;

import java.util.Objects;

import javax.swing.DefaultListModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import vo.StockInfoVO;

// 주식 시세정보 api를 요청 객체로 불러와서 list에 담음
public class StockInfoModel {
	private static final String STOCKINFO_API = "https://apis.data.go.kr/1160100/service/GetStockSecuritiesInfoService/getStockPriceInfo?serviceKey=bafEXsp3A%2FiNM6SrdTReCSgGSp3PZcxqoiD08onBtPTnKgLGfaCfkXnJa15dbR8zVjWpmN99qG5QMrpT%2FjWbuQ%3D%3D&numOfRows=1&pageNo=1&resultType=json&itmsNm=";

	private DefaultListModel<StockInfoVO> stockInfoList = new DefaultListModel<StockInfoVO>();

	// 통신 객체 (HTTP Client : HTTP 요청을 보내고 응답받는 객체)
	private static final OkHttpClient client = new OkHttpClient();
	// Gson 객체
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public StockInfoModel() {
		
	}

	public DefaultListModel<StockInfoVO> getStockInfoList() {
		return stockInfoList;
	}

	public static String getIsinCd(String itmsNm) {

		Request request = new Request.Builder().url(STOCKINFO_API + itmsNm).build();
		String isinCd = null;

		try {
			Response response = client.newCall(request).execute();
			String json = Objects.requireNonNull(response.body()).string();
			JsonObject jsonObj = gson.fromJson(json, JsonObject.class);
			JsonArray itemArray = jsonObj.getAsJsonObject("response").getAsJsonObject("body").getAsJsonObject("items")
					.getAsJsonArray("item");

			isinCd = itemArray.get(0).getAsJsonObject().get("isinCd").getAsString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isinCd;

	} // getIsinCd

} // class
