package pub2504.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {

	private static final String JDBC_URL 
		= "jdbc:oracle:thin:@localhost:1521:xe"; // JDBC URL
	private static final String USERNAME = "JDBC"; // 계정명
	private static final String PASSWORD = "JDBC"; // 계정 비밀번호
	private static Connection conn = null;
	
	public static Connection getConnection() {
		try {
			conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return conn;
	} // getConnection
	
	public static void closeConnection
		(Connection conn, Statement  stmt, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	} // closeConnection
	
} // class
