package kr.co.skmk.Service.Member;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import kr.co.skmk.Model.DAO.Member.MemberDAO;
import kr.co.skmk.Model.DTO.Member.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject // 스프링 컨테이너가 만든 dao 객체가 연결됨 (의존관계 주입)
	MemberDAO memberDao;
		
	@Override
	public int insertMember(MemberDTO member) {
		return memberDao.insertMember(member);
	}

	@Override
	public MemberDTO loginMember(MemberDTO member) {
		// TODO Auto-generated method stub
		MemberDTO result = memberDao.loginMember(member);
		result.setMemberImage("member/" + result.getMemberImage());
		return result;
	}

	@Override
	public MemberDTO getUserInfoByMail(String memberMail) {
		// TODO Auto-generated method stub
		MemberDTO result = memberDao.getUserInfoByMail(memberMail);
		result.setMemberImage("member/" + result.getMemberImage());
		return result;
	}

	@Override
	public String getMemberMailByShopCode(String shopCode) {
		// TODO Auto-generated method stub
		return memberDao.getMemberMailByShopCode(shopCode);
	}

}
