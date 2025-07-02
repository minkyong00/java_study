package pub2504.network;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

// [실습] Selenium을 활용해서 직방(zigbang.com) 웹사이트내의
//         역삼동 아파트 매매/전월세 정보를 크롤링하여 매물명과 가격정보 출력

public class ExSeleniumLand {
   
   public static void main(String[] args) {
      
      // 크롬드라이버 경로 설정
      System.setProperty("webdriver.chrome.driver", "C:\\pub2504\\driver\\chromedriver.exe");
      
      // 크롬드라이버 객체 생성
      WebDriver driver = new ChromeDriver();
      
      try {
         driver.get("https://apis.zigbang.com/apt/locals/prices/on-danjis?geohash=wydm7");
         Thread.sleep(3000);
         
         String pageSource = driver.getPageSource();
         // driver getPageSource() html로 가지고옴
         pageSource = pageSource.substring(
            pageSource.indexOf("<pre>")+5, pageSource.lastIndexOf("</pre>") 
         );
         
         Gson gson = new GsonBuilder().setPrettyPrinting().create();
         gson.fromJson(pageSource, JsonObject.class)
            .get("filtered").getAsJsonArray().asList().stream()
            .forEach(element -> {
               final JsonObject obj = element.getAsJsonObject();
               if (obj.get("price")!=null && !obj.get("price").isJsonNull()) {
                  final JsonObject sales = obj.get("price").getAsJsonObject()
                        .get("sales").getAsJsonObject();
                  String name = obj.get("name").getAsString();
                  String min = sales.get("min")==null || sales.get("min").isJsonNull() 
                        ? "미정" : sales.get("min").getAsString();
                  String max = sales.get("max")==null || sales.get("max").isJsonNull() 
                        ? "미정" : sales.get("max").getAsString();
                  System.out.println(name + "," + min + "~" + max);
               }
            });         
      } catch (Exception ex) {
         ex.printStackTrace();
      } finally {
         driver.quit(); // 드라이버 종료
      }
      
   } // main

} // class




























