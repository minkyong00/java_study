package pub2504.exjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pub2504.util.ConnectionUtil;

public class ExJDBC1 {

	public static void main(String[] args) {
		
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result;
		
		try {
			
			// insert
			String insertSQL = " INSERT INTO STUDENT VALUES(SEQ_STUDENT.NEXTVAL, ?, ?, ?) ";
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, "홍길동");
			pstmt.setString(2, "dong@dong.com");
			pstmt.setString(3, "010-1111-2222");
			
			result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("insert 성공!");
			} else {
				System.out.println("insert 실패!");
			}
			
			// selectAll
			String selectAllSQL = " SELECT STNO, STNAME, STEMAIL, STPHONE FROM STUDENT ";
			pstmt = conn.prepareStatement(selectAllSQL);
			
			rs = pstmt.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
					System.out.println(
							rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)
					);
				}
			}
			
			// selectOne
			String selectOneSQL = " SELECT STNO, STNAME, STEMAIL, STPHONE FROM STUDENT WHERE STNO=? ";
			pstmt = conn.prepareStatement(selectOneSQL);
			pstmt.setInt(1, 7);
			
			rs = pstmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				System.out.println(
						rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)
				);
			}
			
			// update
			String updateSQL = " UPDATE STUDENT SET STNAME=? WHERE STNO=? ";
			pstmt = conn.prepareStatement(updateSQL);
			pstmt.setString(1, "이순신");
			pstmt.setInt(2, 2);
			
			result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("update 성공!");
			} else {
				System.out.println("update 실패!");
			}

			// delete
			String deleteSQL = " DELETE STUDENT WHERE STNO=? ";
			pstmt = conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, 1);
			
			result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("delete 성공!");
			} else {
				System.out.println("delete 실패!");
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		
		ConnectionUtil.closeConnection(conn, pstmt, rs);
		
	}
	
}
