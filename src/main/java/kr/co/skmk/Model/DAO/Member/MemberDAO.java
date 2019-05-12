package kr.co.skmk.Model.DAO.Member;

import kr.co.skmk.Model.DTO.Member.MemberDTO;

public interface MemberDAO {

	public void insertMember(MemberDTO member);
	public boolean checkPw(String userMail, String password);
}
