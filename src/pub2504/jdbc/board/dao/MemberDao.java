package pub2504.jdbc.board.dao;

import java.sql.SQLException;
import java.util.List;

import pub2504.jdbc.board.model.Member;

public interface MemberDao {

	public abstract List<Member> listMember() throws SQLException;

	public abstract Member getMember(String mid) throws SQLException;

	public abstract int registMember(Member member) throws SQLException;

	public abstract int modifyMember(Member membar) throws SQLException;

	public abstract int removeMember(String mid) throws SQLException;

}
