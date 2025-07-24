package pub2504.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import pub2504.util.ConnectionUtil;

// DatabaseMetaData : 데이터베이스에 대한 자체 정보
// ResultSetMetaData : 결과집합(행)들에 대한 자체 정보

public class JDBCTest7 {

	public static void main(String[] args) {
		
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			// DatabaseMetaData 객체 생성
			DatabaseMetaData dmd = conn.getMetaData();
		
			System.out.println(dmd.getDatabaseMajorVersion()); // 메이져 버전
			System.out.println(dmd.getDatabaseMinorVersion()); // 마이너 버전
			System.out.println(dmd.getDatabaseProductName()); // 제품명
			System.out.println(dmd.getDatabaseProductVersion()); // 전체 버전
			System.out.println(dmd.getDriverName()); // JDBC 드라이버명
			System.out.println(dmd.getMaxConnections()); // 최대 허용 연결 수 
			System.out.println(dmd.getURL()); // JDBC URL
			System.out.println(dmd.getUserName()); // 사용자 계정명
			System.out.println(dmd.getClass()); // 클래스명
			System.out.println(dmd.getConnection()); // 커넥션 객체 타입/참조값
			
			// ResultSet 객체 생성
			String selectSQL = " SELECT PID, PNAME, PAGE FROM PERSON ";
			pstmt = conn.prepareStatement(selectSQL);
			rs = pstmt.executeQuery();
			
			// ResultSetMetaData 객체 생성
			ResultSetMetaData srmd = rs.getMetaData();
			
			System.out.println(srmd.getColumnCount()); // 컬럼 수
			System.out.println(srmd.getColumnLabel(1)); // 1번 인덱스 컬럼명
			System.out.println(srmd.getColumnName(1)); //  1번 인덱스 컬럼명
			System.out.println(srmd.getColumnType(1)); // 컬럼 타입 값
			System.out.println(srmd.getColumnTypeName(1)); // 컬럼 타입 이름
			System.out.println(srmd.getTableName(1)); // 테이블명
			System.out.println(srmd.isAutoIncrement(1)); // 자동증가값 여부
			System.out.println(srmd.isNullable(1)); // 널 허용여부
			System.out.println(srmd.isReadOnly(1)); // 일기 전용 여부
			System.out.println(srmd.isWritable(1)); // 쓰기 가능 여부
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		
		ConnectionUtil.closeConnection(conn, pstmt, rs);
		
	}
	
}
