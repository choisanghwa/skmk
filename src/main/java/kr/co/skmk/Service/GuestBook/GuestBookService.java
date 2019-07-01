package kr.co.skmk.Service.GuestBook;

import java.util.List;

import kr.co.skmk.Model.DTO.GuestBook.GuestBookDTO;

public interface GuestBookService {
	public int insertGuestBook(GuestBookDTO guestBooks);
	public List<GuestBookDTO> getGuestBookList(String shopCode);
}
