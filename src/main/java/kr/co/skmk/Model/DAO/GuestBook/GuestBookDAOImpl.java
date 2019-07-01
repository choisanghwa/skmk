package kr.co.skmk.Model.DAO.GuestBook;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.skmk.Model.DTO.GuestBook.GuestBookDTO;

@Repository
public class GuestBookDAOImpl implements GuestBookDAO {
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public int insertGuestBook(GuestBookDTO guestBooks) {
		// TODO Auto-generated method stub
		return sqlSession.insert("guestBook.insertGuestBook", guestBooks);
	}

	@Override
	public List<GuestBookDTO> getGuestBookList(String shopCode) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("guestBook.getGuestBookList", shopCode);
	}

}
