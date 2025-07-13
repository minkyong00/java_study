package project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StockMain2 {

	public static void main(String[] args) {

		// StockAPI 객체 생성
		StockAPI stockapi = new StockAPI();

		// 배당일
//		 stockapi.getApi("cashDvdnPayDt").stream()
//		 	.forEach(System.out:: println);

		// 배당금 * 주식 수로 얼마 받았을까 생각할 수 있다.
//		stockapi.getApi("stckGenrDvdnAmt").stream()
//		.map(e -> Integer.parseInt(e) * 100)
//		.forEach(System.out::println);
		 
		 // 배당락일 (배당일 이틀 전)
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		List<Date> dateList = new ArrayList<Date>();
		dateList = stockapi.getApi("cashDvdnPayDt").stream()
			.filter(day -> !day.isEmpty())
			.map(day -> {
				try {
					return sdf.parse(day.toString());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return null;
			}).toList();
		for(Date date : dateList) {
			calendar.setTime(date);
			System.out.println(calendar.get(Calendar.YEAR));
			System.out.println(calendar.get(Calendar.MONTH));
			System.out.println(calendar.get(Calendar.DATE) - 2);
		}
		
	} // main
} // class
