package kr.co.skmk.Model.DAO.Member;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.co.skmk.Model.DTO.Member.MemberDTO;

@Repository // 서버가 startup 될 때 이 클레스가 메모리에 자동으로 등록됨
public class MemberDAOImpl implements MemberDAO {

	// 로깅 처리를 위한 객체 선언
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	// SqlSession 객체를 개발자가 직접 생성하지 않고 스프링에서 생성하여 주입시켜 줌
	// 의존관계 주입(Dependency Injection, DI)
	// 느슨한 결합
	// IoC(Inversion of Control, 제어의 역전)
	@Inject
	SqlSession sqlSession;
	
	@Override
	public int insertMember(MemberDTO member) {
		return sqlSession.insert("member.insertMember", member);
	}

	@Override
	public MemberDTO loginMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.loginMember", dto);
	}

	@Override
	public MemberDTO getUserInfoByMail(String memberMail) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.getUserInfoByMail", memberMail);
	}

	@Override
	public String getMemberMailByShopCode(String shopCode) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.getMemberMailByShopCode", shopCode);
	}

}
