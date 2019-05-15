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
		return memberDao.loginMember(member);
	}

}
