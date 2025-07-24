package pub2504.jdbc.board.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pub2504.jdbc.board.constant.BoardConstant;

// 커넥션 유틸리티 클래스
// 역할: 커넥션 관련된 기능을 제공

// Singleton 패턴 : 객체 생성을 하나만 하기 위한 디자인 패턴
// private, static 멤버변수
// private 생성자
// public 생성된 객체 반환 메소드

public final class ConnectionUtil {

	private static ConnectionUtil connectionUtil = new ConnectionUtil();
	
	private Connection conn;
	
	private ConnectionUtil() {
	}

	public static ConnectionUtil getConnectionUtil() {
		return connectionUtil;
	}
	
	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(
				BoardConstant.JDBC_URL,
				BoardConstant.USERNAME,
				BoardConstant.PASSWORD
			);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return conn;
	}
	
	public void closeAll(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
}
