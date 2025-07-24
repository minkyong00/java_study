package pub2504.exjdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pub2504.util.ConnectionUtil;

/*
CREATE TABLE TODO(
	TDNO NUMBER PRIMARY KEY,
	TDWRITER NVARCHAR2(200) NOT NULL,
	TDCONTENT CLOB,
	TDDATE TIMESTAMP DEFAULT SYSTIMESTAMP,
	TDYN CHAR(1) DEFAULT 'N' CHECK (TDYN IN ('Y', 'N'))
); 
*/

public class ExTodo {

	public static void main(String[] args) {
		
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = null;
		
		try {
			sc = new Scanner(System.in);
			
			while(true) {
				askMenu(conn, pstmt, rs, sc);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			sc.close();
		}
		
		ConnectionUtil.closeConnection(conn, pstmt, rs);
	
	} // main
	
	private static void askMenu(Connection conn, PreparedStatement pstmt, ResultSet rs, Scanner sc) {
		
		System.out.println("#########################################################");
		System.out.println("메뉴번호(1.목록, 2.등록, 3.삭제, 4.완료처리, 5.종료)를 선택해주세요!");
		System.out.println("#########################################################");
		
		switch (Integer.parseInt(sc.nextLine())) {
			case 1: 
				getTodoList(conn, pstmt, rs);
				break;
			case 2:
				insertTodo(conn, pstmt, rs);
				break;
			case 3:
				deleteTodo(conn, pstmt, rs);
				break;
			case 4:
				updateTodo(conn, pstmt, rs);
				break;
			case 5:
				System.out.println("프로그램 종료");
				System.exit(0);
				break;
		}
		
	} // askMenu
	
	private static void getTodoList(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			String selectAllSQL = " SELECT * FROM TODO ORDER BY TDNO DESC ";
			pstmt = conn.prepareStatement(selectAllSQL);
			
			rs = pstmt.executeQuery();
			List<TODO> todoList = new ArrayList<TODO>();
			
			if(rs!=null) {
				System.out.println("[TODO List]");
				while(rs.next()) {
					Reader reader = rs.getCharacterStream("TDCONTENT");
					BufferedReader br = new BufferedReader(reader);
					String line = "";
					while((line=br.readLine()) != null) {
						todoList.add(new TODO(rs.getInt(1), rs.getString(2), line, rs.getTimestamp(4), rs.getString(5)));
					}
				}
			}
			
			// todo toString으로 출력하기
			int todoListLen = todoList.size();
			for(int i=0; i<todoListLen; i++) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
				System.out.println(
					"번호: " + todoList.get(i).getTdno() + ", 작성자: " + todoList.get(i).getTdwriter() + ", 내용: " 
						+ todoList.get(i).getTdcontent() + ", 등록일시: " + sdf.format(todoList.get(i).getTddate())
						+ ", 완료여부: " +  (todoList.get(i).getTdyn().equals("Y") ? "완료" : "미완료")
				);
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	} // getTodoList
	
	private static void insertTodo(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			
			System.out.println("작성자 이름과 내용을 입력해주세요! (형식: 홍길동,메모내용)");
			Scanner sc = new Scanner(System.in);
			
			String insertStr = sc.nextLine();
			String tdwriter = insertStr.substring(0, insertStr.indexOf(","));
			String tdcontent = insertStr.substring(insertStr.indexOf(",")+1, insertStr.length());
			
			String insertSQL = " INSERT INTO TODO(TDNO, TDWRITER, TDCONTENT) VALUES(SEQ_TODO.NEXTVAL, ?, ?) ";
			
			pstmt = conn.prepareStatement(insertSQL);
			
			pstmt.setString(1, tdwriter);
			
			Reader reader = new StringReader(tdcontent);
			pstmt.setCharacterStream(2, reader, tdcontent.length());
			
			if(pstmt.executeUpdate()>0) {
				getTodoList(conn, pstmt, rs);
			} else {
				System.out.println("insert 실패!");
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	} // insertTodo
	
	private static void deleteTodo(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			System.out.println("삭제하실 TODO 번호를 입력하세요!");
			Scanner sc = new Scanner(System.in);
			int stno = sc.nextInt();		
			
			String deleteSQL = " DELETE TODO WHERE TDNO=? ";
			pstmt = conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, stno);
			
			if(pstmt.executeUpdate()>0) {
				getTodoList(conn, pstmt, rs);
			} else {
				System.out.println("delete 실패!");
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	} // deleteTodo
	
	private static void updateTodo(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			
			System.out.println("완료처리하실 TODO 번호를 입력하세요!");
			Scanner sc = new Scanner(System.in);
			int tdno = sc.nextInt();
			
			String updateSQL = " UPDATE TODO SET TDYN=? WHERE TDNO=? ";
			pstmt = conn.prepareStatement(updateSQL);
			pstmt.setString(1, "Y");
			pstmt.setInt(2, tdno);
			
			if(pstmt.executeUpdate()>0) {
				getTodoList(conn, pstmt, rs);
			} else {
				System.out.println("update 실패!");
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
	} // updateTodo
	
} // class
