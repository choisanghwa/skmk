package kr.co.skmk.Model.DAO.GuestBook;

import java.util.List;

import kr.co.skmk.Model.DTO.GuestBook.GuestBookDTO;

public interface GuestBookDAO {
	public int insertGuestBook(GuestBookDTO guestBooks);
	public List<GuestBookDTO> getGuestBookList(String shopCode);
}
