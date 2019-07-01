package kr.co.skmk.Service.GuestBook;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.skmk.Model.DAO.GuestBook.GuestBookDAO;
import kr.co.skmk.Model.DTO.GuestBook.GuestBookDTO;

@Service
public class GuestBookServiceImpl implements GuestBookService {

	@Inject // 스프링 컨테이너가 만든 dao 객체가 연결됨 (의존관계 주입)
	GuestBookDAO guestsDao;
	
	@Override
	public int insertGuestBook(GuestBookDTO guestBooks) {
		// TODO Auto-generated method stub
		return guestsDao.insertGuestBook(guestBooks);
	}

	@Override
	public List<GuestBookDTO> getGuestBookList(String shopCode) {
		// TODO Auto-generated method stub
		return guestsDao.getGuestBookList(shopCode);
	}

}
