package pub2504.jdbc.board.service.impl;

import java.sql.SQLException;
import java.util.List;

import pub2504.jdbc.board.dao.BoardDao;
import pub2504.jdbc.board.dao.impl.BoardDaoImpl;
import pub2504.jdbc.board.model.Board;
import pub2504.jdbc.board.service.BoardService;

public class BoardServiceImpl implements BoardService{
	
	private BoardDao boardDao;
	
	public BoardServiceImpl() {
		boardDao = new BoardDaoImpl();
	}

	@Override
	public List<Board> listBoard() throws SQLException {
		return boardDao.listBoard();
	}

	@Override
	public Board getBoard(int bid) throws SQLException {
		return boardDao.getBoard(bid);
	}

	@Override
	public int registBoard(Board board) throws SQLException {
		return boardDao.registBoard(board);
	}

	@Override
	public int modifyBoard(Board board) throws SQLException {
		return boardDao.modifyBoard(board);
	}

	@Override
	public int removeBoard(int bid) throws SQLException {
		return boardDao.removeBoard(bid);
	}

}
