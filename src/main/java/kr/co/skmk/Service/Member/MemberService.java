package kr.co.skmk.Service.Member;

import kr.co.skmk.Model.DTO.Member.MemberDTO;

public interface MemberService {
	
	public int insertMember(MemberDTO member);
	public MemberDTO loginMember(MemberDTO dto);
	public MemberDTO getUserInfoByMail(String memberMail);
	public String getMemberMailByShopCode(String shopCode);
}
