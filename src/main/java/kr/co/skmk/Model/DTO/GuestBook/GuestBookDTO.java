package kr.co.skmk.Model.DTO.GuestBook;

import java.util.Date;

public class GuestBookDTO {

	private String shopCode;
	private String guestBookTitle;
	private String GuestBookContent;
	private Date GuestBookTime;
	private String guestBookCode;
	
	public String getShopCode() {
		return shopCode;
	}
	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}
	public String getGuestBookTitle() {
		return guestBookTitle;
	}
	public void setGuestBookTitle(String guestBookTitle) {
		this.guestBookTitle = guestBookTitle;
	}
	public String getGuestBookContent() {
		return GuestBookContent;
	}
	public void setGuestBookContent(String guestBookContent) {
		GuestBookContent = guestBookContent;
	}
	public Date getGuestBookTime() {
		return GuestBookTime;
	}
	public void setGuestBookTime(Date guestBookTime) {
		GuestBookTime = guestBookTime;
	}
	public String getGuestBookCode() {
		return guestBookCode;
	}
	public void setGuestBookCode(String guestBookCode) {
		this.guestBookCode = guestBookCode;
	}
}
