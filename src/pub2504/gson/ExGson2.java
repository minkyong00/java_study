package pub2504.gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/*
   [Gson 변환 실습 2]
   https://newsapi.org/v2/top-headlines?country=us&apiKey=a52463f5568d430891e2595adf958dd4
   뉴스 제목이나 내용에 Trump가 들어간 뉴스 추출 후 출력
*/

public class ExGson2 {
   
   public static void main(String[] args) {
      
      BufferedReader br = null;
      
      try {
      
         br = new BufferedReader(
                  new InputStreamReader(
                        new URI("https://newsapi.org/v2/top-headlines?country=us&apiKey=a52463f5568d430891e2595adf958dd4")
                           .toURL().openConnection().getInputStream()
               )
         );
         
         String jsonStr = "";
         String line = "";
         while ((line=br.readLine()) != null) {
            jsonStr += line;
         }
//         System.out.println(jsonStr);
         
         Gson gson = new GsonBuilder().setPrettyPrinting().create();
         
         News newsObject = gson.fromJson(jsonStr, News.class);
//         System.out.println(newsObject);
         
         newsObject.getArticles().stream().filter(a -> a.getTitle().contains("Trump") || a.getContent().contains("Trump") 
		         		|| a.getDescription().contains("Trump")
		         	).forEach(System.out::println);
         
      } catch (Exception ex) {
         ex.printStackTrace();
      } finally {
         try {
            br.close();
         } catch (IOException ioe) {
            ioe.printStackTrace();
         }
      }
      
   } // main

} // class


