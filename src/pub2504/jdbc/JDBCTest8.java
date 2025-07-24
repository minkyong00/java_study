package pub2504.jdbc;

import java.sql.SQLException;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.CachedRowSet;

import com.github.vldrus.sql.rowset.CachedRowSetWrapper;

// RowSet : ResultSet의 기능을 확장한 JavaBeans 스타일의 객체
//          데이터베이스 연결이 끊긴 상태에서 작동 가능한 CachedRowSet 제공
// https://mvnrepository.com/artifact/com.github.vldrus/cachedrowset-wrapper/1.0.2
// cachedrowset-wrapper-1.0.2.jar

public class JDBCTest8 {

	public static void main(String[] args) {
		
		try {

			CachedRowSetWrapper crs = new CachedRowSetWrapper();
			
			// 결과행(RowSet)에 대한 이벤트 처리
			crs.addRowSetListener(new RowSetListener() {
				@Override
				public void rowSetChanged(RowSetEvent event) {
					System.out.println("RowSet 변경됨!");
				}
				@Override
				public void rowChanged(RowSetEvent event) {
					System.out.println("행이 변경됨!");
				}
				@Override
				public void cursorMoved(RowSetEvent event) {
					System.out.println("커서 이동함!");
				}
			});

			// 데이터베이스 접속 정보 설정
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("JDBC");
			crs.setPassword("JDBC");
			
			// SQL 실행
			crs.setCommand(" SELECT PID, PNAME, PAGE FROM PERSON ");
			crs.execute(); // 이 시점에서만 데이터베이스에 연결
			
			// 데이터베이스 연결이 끊어져도 아래코드는 캐시를 통해 작동함!
			while(crs.next()) {
				System.out.println(
					crs.getInt(1) + " " + crs.getString(2) + " " + crs.getInt(3)	
				);
			}
			
			crs.close();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
	}
	
}
