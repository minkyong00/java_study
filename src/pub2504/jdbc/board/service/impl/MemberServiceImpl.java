package pub2504.jdbc.board.service.impl;

import java.sql.SQLException;
import java.util.List;

import pub2504.jdbc.board.dao.MemberDao;
import pub2504.jdbc.board.dao.impl.MemberDaoImpl;
import pub2504.jdbc.board.model.Member;
import pub2504.jdbc.board.service.MemberService;

// 인터페이스 구현 클래스
public class MemberServiceImpl implements MemberService {
	
	private MemberDao memberDao;
	
	public MemberServiceImpl() {
		memberDao = new MemberDaoImpl();
	}

	@Override
	public List<Member> listMember() throws SQLException {
		return memberDao.listMember();
	}

	@Override
	public Member getMember(String mid) throws SQLException {
		return memberDao.getMember(mid);
	}

	@Override
	public int registMember(Member member) throws SQLException {
		return memberDao.registMember(member);
	}

	@Override
	public int modifyMember(Member membar) throws SQLException {
		return memberDao.modifyMember(membar);
	}

	@Override
	public int removeMember(String mid) throws SQLException {
		return memberDao.removeMember(mid);
	}

}
