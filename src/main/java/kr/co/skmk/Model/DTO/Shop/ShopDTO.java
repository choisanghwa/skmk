package kr.co.skmk.Model.DTO.Shop;

import org.springframework.web.multipart.MultipartFile;

public class ShopDTO {
	
	private String shopCode;
	private String shopName;
	private String shopAddress;
	private String shopLogo;
	private String shopLicense;
	private String memberMail;
	private MultipartFile shopLogoFile;
	private String shopQR;
	
	public String getShopCode() {
		return shopCode;
	}
	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	public String getShopLogo() {
		return shopLogo;
	}
	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}
	public String getShopLicense() {
		return shopLicense;
	}
	public void setShopLicense(String shopLicense) {
		this.shopLicense = shopLicense;
	}
	public String getMemberMail() {
		return memberMail;
	}
	public void setMemberMail(String memberMail) {
		this.memberMail = memberMail;
	}
	public MultipartFile getShopLogoFile() {
		return shopLogoFile;
	}
	public void setShopLogoFile(MultipartFile shopLogoFile) {
		this.shopLogoFile = shopLogoFile;
	}
	public String getShopQR() {
		return shopQR;
	}
	public void setShopQR(String shopQR) {
		this.shopQR = shopQR;
	}
}
