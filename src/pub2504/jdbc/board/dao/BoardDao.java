package pub2504.jdbc.board.dao;

import java.sql.SQLException;
import java.util.List;

import pub2504.jdbc.board.model.Board;

public interface BoardDao {

	public abstract List<Board> listBoard() throws SQLException;

	public abstract Board getBoard(int bid) throws SQLException;

	public abstract int registBoard(Board board) throws SQLException;

	public abstract int modifyBoard(Board board) throws SQLException;

	public abstract int removeBoard(int bid) throws SQLException;

}
