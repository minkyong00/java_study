package pub2504.jdbc;

import java.sql.Connection;

import pub2504.util.ConnectionUtil;

// DriverManager, Connection을 활용한 데이터베이스 연결

public class JDBCTest1 {

	// db가 바뀌게 되면 jar, 상수값만 바꾸면 됨
	public static void main(String[] args) {

		Connection conn = ConnectionUtil.getConnection();
		
			if(conn!=null) {
				System.out.println("데이터베이스 연결 성공!");
				System.out.println(conn);
			} else {
				System.out.println("데이터베이스 연결 실패!");
			}
			
			ConnectionUtil.closeConnection(conn, null, null);
			
	}
	
}
