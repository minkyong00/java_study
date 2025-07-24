package pub2504.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pub2504.util.ConnectionUtil;

public class CLOBTest {
	
	public static void main(String[] args) {
		
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
//			String filePath = "c:/pub2504/files/clob.txt";
//			
//			// CLOB 데이터 입력
//			String insertSQL = " INSERT INTO LOB_STORAGE(LID, FILE_NAME, CLOB_DATA)"
//					+ " VALUES(SEQ_LOB_STORAGE.NEXTVAL, ?, ?) ";
//			
//			pstmt = conn.prepareStatement(insertSQL);
//			pstmt.setString(1, filePath);
//			
//			String longText = "";
//			StringBuilder sb = new StringBuilder();
//			for(int i=0; i<100000; i++) {
//				sb.append("Goodbye Java!");
//			}
//			longText = sb.toString();
//			
//			// 문자열의 문자를 입력받는 스트림
//			Reader reader = new StringReader(longText);
//			
//			// 테이블의 clob컬럼에 문자들을 출력하는 스트림
//			// 인자 : 위치지정자인덱스, 문자입력스트림, 문자길이
//			pstmt.setCharacterStream(2, reader, longText.length());
//						
//			System.out.println(pstmt.executeUpdate()>0 ? "입력 성공!" : "입력 실패!");
			
			// CLOB 데이터 출력
			String selectSQL = " SELECT CLOB_DATA FROM LOB_STORAGE WHERE LID=? ";
			
			pstmt = conn.prepareStatement(selectSQL);
			pstmt.setInt(1, 2);
			
			rs = pstmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				Reader reader = rs.getCharacterStream("CLOB_DATA");
				BufferedReader br = new BufferedReader(reader);
				String line = "";
				int charCount = 0;
				while((line=br.readLine()) != null) {
					System.out.println(line);
					charCount += line.length();
				}
				System.out.println(charCount + "개의 문자 출력 완료!");
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		ConnectionUtil.closeConnection(conn, pstmt, rs);
		
	} // main
	
} // class
