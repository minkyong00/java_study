package pub2504.jdbc.board.main;

import java.sql.SQLException;
import java.util.List;

import pub2504.jdbc.board.model.Member;
import pub2504.jdbc.board.service.MemberService;
import pub2504.jdbc.board.service.impl.MemberServiceImpl;

public class MemberServiceTest {

	public static void main(String[] args) {
		
		try {
			
			MemberService memberService = new MemberServiceImpl();
			
			// registMember
//			Member member 
//				= new Member("HONG", "HONG", "홍길동", null, null);
//			int result = memberService.registMember(member);
//			if(result>0) System.out.println("입력 성공!");
			
			// listMember
//			List<Member> memberList = memberService.listMember();
//			memberList.stream().forEach(System.out::println);
			
			// getMember
//			Member member = memberService.getMember("HONG");
//			System.out.println(member);
			
			// modifyMember
//			Member member 
//				= new Member("HONG", "HONG", "수정홍길동", null, null);
//			int result = memberService.modifyMember(member);
//			if(result>0) System.out.println("수정 완료!");
			
			// removeMember
			int result = memberService.removeMember("HONG");
			if(result>0) System.out.println("삭제 완료!");
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
	}
	
}
