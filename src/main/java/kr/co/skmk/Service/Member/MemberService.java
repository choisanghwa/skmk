package kr.co.skmk.Service.Member;

import kr.co.skmk.Model.DTO.Member.MemberDTO;

public interface MemberService {
	
	public int insertMember(MemberDTO member);
	public boolean loginMember(MemberDTO dto);
}
