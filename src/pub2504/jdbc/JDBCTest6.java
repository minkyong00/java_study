package pub2504.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pub2504.util.ConnectionUtil;

// JDBC에서의 Transaction 처리

public class JDBCTest6 {

	public static void main(String[] args) {
		
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			
			// 0. autocommit 여부 확인
			// auto commit 상태에서는 SQL실행 시 마다 커밋이 되므로 트랜잭션 처리 불가
			System.out.println(conn.getAutoCommit());
			
			// 1. autocommit을 false로 설정
			conn.setAutoCommit(false);
			System.out.println(conn.getAutoCommit());
			
			// 2-1. insert
			String insertSQL = " INSERT INTO PERSON VALUES(SEQ_PERSON.NEXTVAL, ?, ?) ";
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, "을지문덕");
			pstmt.setInt(2, 80);
			System.out.println(pstmt.executeUpdate()>0 ? "입력 완료!" : "입력 실패!");
			
			// 예외 발생
			int i = 100 / 0;
			
			// 2-2. delete
			String deleteSQL = " DELETE PERSON WHERE PNAME=? ";
			pstmt = conn.prepareStatement(deleteSQL);
			pstmt.setString(1, "을지문덕");
			System.out.println(pstmt.executeUpdate()>0 ? "삭제 완료!" : "삭제 실패!");
			
			// 3-정상종료. commit: 트랜잭션 완료 or 종료
			// insert 작업과 delete 작업이 모두 완료
			conn.commit();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				// 3-예외발생. 모든 작업이 작업 전 상태로 돌아감
				conn.rollback();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		
		ConnectionUtil.closeConnection(conn, pstmt, null);
		
		
	}
	
}
