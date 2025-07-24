package pub2504.jdbc.board.main;

import java.sql.SQLException;
import java.util.List;

import pub2504.jdbc.board.model.Board;
import pub2504.jdbc.board.service.BoardService;
import pub2504.jdbc.board.service.impl.BoardServiceImpl;

public class BoardServiceTest {
	
	public static void main(String[] args) {
		
		BoardService boardService = new BoardServiceImpl();
		
		try {
			
			// registerBoard
//			Board board = new Board(1, "자유게시판", null, null);
//			int result = boardService.registBoard(board);
//			if(result>0) System.out.println("insert 성공!");
			
//			List<Board> board = boardService.listBoard();
//			board.stream().forEach(System.out::println);
			
//			Board board = boardService.getBoard(1);
//			System.out.println(board);
			
//			Board board = new Board(1, "수정 자유게시판", null, null);
//			int result = boardService.modifyBoard(board);
//			if(result>0) System.out.println("수정 성공!");
			
			int result = boardService.removeBoard(1);
			if(result>0) System.out.println("삭제 성공!");
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
	}

}
