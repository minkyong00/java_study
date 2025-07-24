package pub2504.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pub2504.util.ConnectionUtil;

// BLOB (Binary Large OBject) : 최대 4G바이트까지 바이너리를 저장할 수 있는 타입
//                              동영상, 사운드, 이미지 ...

/*
CREATE TABLE LOB_STORAGE (
	LID NUMBER PRIMARY KEY,
	FILE_NAME NVARCHAR2(200),
	BLOB_DATA BLOB,
	CLOB_DATA CLOB
);
CREATE SEQUENCE SEQ_LOB_STORAGE;
*/

public class BLOBTest {

	public static void main(String[] args) {
		
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			//BLOB 데이터 입력
//			String insertSQL = " INSERT INTO LOB_STORAGE(LID, FILE_NAME, BLOB_DATA) "
//					+ " VALUES(SEQ_LOB_STORAGE.NEXTVAL, ?, ?) ";
//			
//			String filePath = "C:/pub2504/files/blob.jpg";
//			
//			pstmt = conn.prepareStatement(insertSQL);
//			pstmt.setString(1, filePath);
//			
//			File file = new File(filePath);
//			
//			// 파일에서 바이트를 읽는 스트림
//			FileInputStream fis = new FileInputStream(file);
//			
//			// 파일에서 읽은 바이트를 테이블의 blob 컬럼에 넣음
//			// 인자 : 위치지정자인덱스, InputStream, 바이트수
//			pstmt.setBinaryStream(2, fis, (int)file.length());
//			
//			System.out.println(pstmt.executeUpdate()>0 ? "이미지 입력 완료!" : "이미지 입력 실패!"); 
			
			// BLOB 데이터 조회
			String selectSQL = " SELECT BLOB_DATA FROM LOB_STORAGE WHERE LID=? ";
			pstmt = conn.prepareStatement(selectSQL);
			pstmt.setInt(1, 1);
			
			rs = pstmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				// 테이블의 blob컬럼의 바이너리를 입력하는 스트림
				InputStream is = rs.getBinaryStream("BLOB_DATA");
				// 읽은 바이너리를 파일에 출력하는 스트림
				FileOutputStream fos = new FileOutputStream("c:/pub2504/files/blob_copy.jpg");
				
				// 파일에 바이터리 출력
				byte[] buffer = new byte[1024];
				int readByte = 0;
				while((readByte = is.read(buffer)) != -1) {
					fos.write(buffer, 0, readByte);
				}
			}
			
			System.out.println("파일 생성 완료!");
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		ConnectionUtil.closeConnection(conn, pstmt, rs);
		
	} // main
	
} // class
