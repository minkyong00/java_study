package pub2504.exjdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pub2504.util.ConnectionUtil;

public class ExTodo_1 {
   
	// 하나만 생성해서 공유할 것들은 static
   private static Connection conn;
   private static List<TODO> todoList;
   
   public static void main(String[] args) {
      try {
    	 // 커넥션 획득
         conn = ConnectionUtil.getConnection();
         // 메뉴 선택 기능 호출
         selectMenu();
      } catch (SQLException sqle) {
         sqle.printStackTrace();
      } catch (IOException ioe) {
         ioe.printStackTrace();
      }
   } // main
   
   // 메뉴 선택 메소드
   private static void selectMenu() throws SQLException, IOException {
      
      System.out.println("#################################");
      System.out.println("메뉴(1.목록 2.등록 3.삭제 4.완료처리 5.종료)를 선택해 주세요!");
      System.out.println("#################################");
      
      Scanner scanner = new Scanner(System.in);
      
      switch (scanner.nextLine()) {
         case "1": selectTodoList(); break;
         case "2": {
            System.out.println("작성자명과 내용을 입력해 주세요! (형식:홍길동,바벨2000회)");
            String inputStr = scanner.nextLine();
            TODO todo = new TODO(
               0, 
               inputStr.substring(0, inputStr.indexOf(",")),
               inputStr.substring(inputStr.indexOf(",") + 1),
               null,
               "N"
            );
            insertTodo(todo);
            selectTodoList();
         }
         case "3": {
            System.out.println("삭제하실 TODO 번호를 입력해 주세요!");
            deleteTodo(scanner.nextLine());
            selectTodoList();
         }
         case "4": {
            System.out.println("완료처리하실 TODO 번호를 입력해 주세요!");
            updateTdyn(scanner.nextLine());
            selectTodoList();
         }
         case "5": {
            System.out.println("프로그램 종료!");
            System.exit(0);
         }
         default: {
            System.out.println("메뉴번호를 다시 입력해 주세요!");
            selectMenu();
         }
      }
      if (scanner!=null) scanner.close();
   }
   
   private static void selectTodoList() throws SQLException, IOException {
      todoList = new ArrayList<TODO>();
      String sql = " select tdno, tdwriter, tdcontent, tddate, tdyn from todo "
            + " order by tdno desc ";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();
      BufferedReader br = null;
      while(rs!=null && rs.next()) {
         br = new BufferedReader(rs.getCharacterStream("tdcontent"));
         String line = "";
         StringBuilder sb = new StringBuilder();
         while ((line=br.readLine()) != null) {
            sb.append(line);
         }
         String tdcontent = sb.toString();         
         todoList.add(
            new TODO(
                  rs.getInt("tdno"),
                  rs.getString("tdwriter"),
                  tdcontent,
                  rs.getTimestamp("tddate"),
                  rs.getString("tdyn")
            )
         );
      }
      if (br!=null) br.close();
      if (pstmt!=null) pstmt.close();
      if (rs!=null) rs.close();
      printList();
   }   
   
   private static void insertTodo(TODO todo) throws SQLException {
      String sql = " insert into todo(tdno, tdwriter, tdcontent) " 
         + " values(seq_todo.nextval, ?, ?) ";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, todo.getTdwriter());
      StringReader sr = new StringReader(todo.getTdcontent());
      pstmt.setCharacterStream(2, sr, todo.getTdcontent().length());
      pstmt.executeUpdate();
      if (sr!=null) sr.close();
      if (pstmt!=null) pstmt.close();
   }
   
   private static void deleteTodo(String tdno) throws SQLException {
      String sql = " delete todo where tdno=? ";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, tdno);
      pstmt.executeUpdate();   
      if (pstmt!=null) pstmt.close();
   }
   
   private static void updateTdyn(String tdno) throws SQLException {
      String sql = " update todo set tdyn='Y' where tdno=? ";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, tdno);
      pstmt.executeUpdate();   
      if (pstmt!=null) pstmt.close();
   }
   
   private static void printList() throws SQLException, IOException {
      if (todoList==null || todoList.isEmpty()) {
         System.out.println("=================================");
         System.out.println("등록된 TODO가 없습니다!");
         System.out.println("=================================");
      } else {
         System.out.println("\n[Todo List]");
         todoList.stream().forEach(System.out::println);
         System.out.println();
      }
      selectMenu();
   }   

} // class
































