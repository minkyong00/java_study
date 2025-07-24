package pub2504.jdbc.board.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pub2504.jdbc.board.dao.BoardDao;
import pub2504.jdbc.board.model.Board;
import pub2504.jdbc.board.util.ConnectionUtil;

public class BoardDaoImpl implements BoardDao {

	private Connection conn;
	private PreparedStatement pstmt;
	ResultSet rs;

	public BoardDaoImpl() {
		conn = ConnectionUtil.getConnectionUtil().getConnection();
	}

	@Override
	public List<Board> listBoard() throws SQLException {
		String sql = " select bid, bname, bregdate, bdelyn from board ";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<Board> boardList = new ArrayList<Board>();
		if(rs!=null) {
			while(rs.next()) {
				Board board = new Board();
				board.setBid(rs.getInt("bid"));
				board.setBname(rs.getString("bname"));
				board.setBregdate(rs.getTimestamp("bregdate"));
				board.setBdelyn(rs.getString("bdelyn"));
				boardList.add(board);
			}
		}
		return boardList;
	}

	@Override
	public Board getBoard(int bid) throws SQLException {
		String sql = " select bid, bname, bregdate, bdelyn from board where bid=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bid);
		rs = pstmt.executeQuery();
		Board board = new Board();
		if(rs!=null) {
			while(rs.next()) {
				board.setBid(rs.getInt("bid"));
				board.setBname(rs.getString("bname"));
				board.setBregdate(rs.getTimestamp("bregdate"));
				board.setBdelyn(rs.getString("bdelyn"));
			}
		}
		return board;
	}

	@Override
	public int registBoard(Board board) throws SQLException {
		String sql = " insert into board values(?, ?, systimestamp, 'N') ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, board.getBid());
		pstmt.setString(2, board.getBname());
		return pstmt.executeUpdate();
	}

	@Override
	public int modifyBoard(Board board) throws SQLException {
		String sql = " update board set bname=? where bid=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getBname());
		pstmt.setInt(2, board.getBid());
		return pstmt.executeUpdate();
	}

	@Override
	public int removeBoard(int bid) throws SQLException {
		String sql = " delete board where bid=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bid);
		return pstmt.executeUpdate();
	}

}
