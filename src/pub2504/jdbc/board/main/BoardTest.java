package pub2504.jdbc.board.main;

import pub2504.jdbc.board.util.ConnectionUtil;

public class BoardTest {

	public static void main(String[] args) {
		
		// Connection 테스트
		System.out.println(ConnectionUtil.getConnectionUtil().getConnection());
		
	}
	
}
