package pub2504.jdbc.board.service;

import java.sql.SQLException;
import java.util.List;

import pub2504.jdbc.board.model.Member;

// Service 패턴

public interface MemberService {

	public abstract List<Member> listMember() throws SQLException;
	
	public abstract Member getMember(String mid) throws SQLException;
	
	public abstract int registMember(Member member) throws SQLException;
	
	public abstract int modifyMember(Member membar) throws SQLException;
	
	public abstract int removeMember(String mid) throws SQLException;
	
}
