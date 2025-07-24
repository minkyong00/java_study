package pub2504.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pub2504.util.ConnectionUtil;

// Statement 활용한 CRUD

public class JDBCTest2 {

	public static void main(String[] args) {
		
		Connection conn = ConnectionUtil.getConnection();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			// Statement  객체 생성
			stmt = conn.createStatement();
			
			int result;
			
			// insert
			// 쿼리문 앞뒤로 한칸씩 공백
			String insertSQL 
				= " INSERT INTO PERSON "
					+ " VALUES(SEQ_PERSON.NEXTVAL, '홍길동', 20) ";
			
			// SQL을 실행하고 insert된 행의 수를 리턴
			result = stmt.executeUpdate(insertSQL);
			
			if(result>0) {
				System.out.println("입력 성공!");
			} else {
				System.out.println("입력 실패!");
			}

			// SELECT
			String selectSQL 
				= " SELECT PID, PNAME, PAGE FROM PERSON ORDER BY PID DESC ";
			
			// select쿼리를 실행한 후 결과행을 가리키는 커서(ResultSet)를 리턴
			rs = stmt.executeQuery(selectSQL);
			
			if(rs!=null) {
				while(rs.next()) { // 커서 이동
					// 커서가 가리키는 행의 컬럼인덱스를 통해 컬럼값을 가져와 출력
					System.out.println(
//						rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3)
						rs.getInt("PID") + " " + rs.getString("PNAME") 
							+ " " + rs.getInt("PAGE")
					);					
				}
			}
			
			// UPDATE
			String updateSQL 
				= " UPDATE PERSON SET PNAME='이순신' WHERE PID=1 ";
			
			result = stmt.executeUpdate(updateSQL);
			
			if(result>0) {
				System.out.println("수정 성공!");
			} else {
				System.out.println("수정 실패!");
			}
			
			// DELETE
			String deleteSQL
				= " DELETE PERSON WHERE PID=8 ";
			
			result = stmt.executeUpdate(deleteSQL);
			
			if(result>0) {
				System.out.println("삭제 성공!");
			} else {
				System.out.println("삭제 실패!");
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		ConnectionUtil.closeConnection(conn, stmt, rs);
		
	}
	
}
