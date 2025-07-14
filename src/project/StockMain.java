package project;

import java.util.List;

public class StockMain {

	public static void main(String[] args) {

		// StockAPI 객체 생성
		// StockAPI stockapi = new StockAPI();

		// 배당일
		// stockapi.getApi("cashDvdnPayDt").stream().forEach(System.out:: println);
		
		SearchisinCd SC = new SearchisinCd();
		
		//System.out.println(SC.getIsinCd("삼성전자"));
		//System.out.println(SC.getIsinCd("대한항공"));
	
//		System.out.println(new StockAPI_2(SC).getApi("dvdnBasDt", "삼성전자"));
		
//		System.out.println(new StockAPI_2(new SearchisinCd()).getExDate("dvdnBasDt", "삼성전자"));
		
		System.out.println(new StockAPI_2(new SearchisinCd()).isGoodStock("하나금융지주"));
		
	} // main
	
} // class












