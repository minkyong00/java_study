package pub2504.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import pub2504.util.ConnectionUtil;

// CallableStatement를 활용한 프로시져, 함수 호출
// CallableStatement를 사용하면 보안, 성능, 모듈화의 큰 장점이 있으므로
// 적극적으로 활용하자!

public class JDBCTest4 {

	public static void main(String[] args) {
		
		Connection conn = ConnectionUtil.getConnection();
		CallableStatement cstmt = null;

		try {
			
		// 프로시져 호출
		// 문법 : {call 프로시져명(파라미터리스트에 해당하는 위치지정자들)}
		// 첫 번째 IN파라미터: 자바에서 값 전달
		// 두 번째 IN OUT 파라미터: 자바에서 값 전달, 결과값을 디비에서 전달
		// OUT파라미터인 경우: registerOutParameter를 통해 등록해 줘야 함
		cstmt = conn.prepareCall(" {call CHANGENAME(?, ?)} ");
		
		// 프로시져 파라미터 설정
		cstmt.setInt(1, 3);
		cstmt.setString(2, "권율");
		cstmt.registerOutParameter(2, Types.NVARCHAR);	
		
		// 프로시져 실행
		cstmt.execute();
			
		System.out.println("프로시져 OUT PARAMETER의 값: " + cstmt.getString(2));
		
		// 함수 호출
		// 문법: {? = call 함수명(파라미터리스트에 해당하는 위치지정자들)}
		cstmt = conn.prepareCall(" {? = call GETNAME(?)} ");
		
		// 함수 파라미터 설정
		cstmt.setInt(2, 3);
		
		// 함수 리턴값 설정
		cstmt.registerOutParameter(1, Types.NVARCHAR);
		
		// 함수 실행
		cstmt.execute();
		
		System.out.println("함수 리턴 값: " + cstmt.getString(1));

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		ConnectionUtil.closeConnection(conn, cstmt, null);
		
	}
	
}
