package pub2504.exjdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import pub2504.util.ConnectionUtil;

public class ExJDBC2 {
	
	public static void main(String[] args) {
		// 한 행의 데이터를 입력하는 프로시져 PROC_INSERT_STUDENT
		// STNO를 입력하면 이름을 반환하는 함수 FUNC_GET_STNAME
		
		Connection conn = ConnectionUtil.getConnection();
		CallableStatement cstmt = null;
		
		try {

			// PROC_INSERT_STUDENT 프로시져 호출
			cstmt = conn.prepareCall(" {call PROC_INSERT_STUDENT(?, ?, ?)} ");
			
			cstmt.setString(1, "권율");
			cstmt.setString(2, "kwon@kwon.com");
			cstmt.setString(3, "010-2222-3333");
			
			cstmt.execute();
			
			System.out.println("PROC_INSERT_STUDENT insert 성공!");
			
			// FUNC_GET_STNAME 함수 호출
			cstmt = conn.prepareCall(" {? = call FUNC_GET_STNAME(?)} ");
			
			cstmt.setInt(2, 2);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			
			cstmt.execute();
			
			System.out.println("FUNC_GET_STNAME 실행 값: " + cstmt.getString(1));
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		ConnectionUtil.closeConnection(conn, cstmt, null);
		
	} 

}
