package pub2504.jdbc.board.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pub2504.jdbc.board.dao.MemberDao;
import pub2504.jdbc.board.model.Member;
import pub2504.jdbc.board.util.ConnectionUtil;

public class MemberDaoImpl implements MemberDao {

	private Connection conn;
	private PreparedStatement pstmt;
	ResultSet rs;

	public MemberDaoImpl() {
		conn = ConnectionUtil.getConnectionUtil().getConnection();
	}

	@Override
	public List<Member> listMember() throws SQLException {
		String sql = " select mid, mpass, mname, mregdate, mdelyn " + " from member ";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<Member> memberList = new ArrayList<Member>();
		if (rs != null) {
			while (rs.next()) {
				Member member = new Member();
				member.setMid(rs.getString("mid"));
				member.setMpass(rs.getString("mpass"));
				member.setMname(rs.getString("mname"));
				member.setMregdate(rs.getTimestamp("mregdate"));
				member.setMdelyn(rs.getString("mdelyn"));
				memberList.add(member);
			}
		}
		return memberList;
	}

	@Override
	public Member getMember(String mid) throws SQLException {
		String sql = " select mid, mpass, mname, mregdate, mdelyn " 
			+ " from member where mid=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mid);
		rs = pstmt.executeQuery();
		Member member = new Member();
		if (rs != null) {
			while (rs.next()) {
				member.setMid(rs.getString("mid"));
				member.setMpass(rs.getString("mpass"));
				member.setMname(rs.getString("mname"));
				member.setMregdate(rs.getTimestamp("mregdate"));
				member.setMdelyn(rs.getString("mdelyn"));
			}
		}
		return member;
	}

	@Override
	public int registMember(Member member) throws SQLException {
		String sql = " insert into member values(?, ?, ?, systimestamp, 'N') ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getMid());
		pstmt.setString(2, member.getMpass());
		pstmt.setString(3, member.getMname());
		return pstmt.executeUpdate();
	}

	@Override
	public int modifyMember(Member member) throws SQLException {
		String sql = " update member set mname=? where mid=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getMname());
		pstmt.setString(2, member.getMid());
		return pstmt.executeUpdate();
	}

	@Override
	public int removeMember(String mid) throws SQLException {
		String sql = " delete member where mid=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mid);
		return pstmt.executeUpdate();
	}

}
