package kr.co.skmk.Model.DAO.Member;

import kr.co.skmk.Model.DTO.Member.MemberDTO;

public interface MemberDAO {

	public int insertMember(MemberDTO member);
	public boolean loginMember(MemberDTO dto);
}
