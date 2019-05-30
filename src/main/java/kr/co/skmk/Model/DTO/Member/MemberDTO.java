package kr.co.skmk.Model.DTO.Member;

import org.springframework.web.multipart.MultipartFile;

public class MemberDTO {
	
	private String memberMail;
	private String memberPassword;
	private String memberName;
	private String memberMobile;
	private String memberImage;
	private MultipartFile memberImageFile;
	
	public String getMemberMail() {
		return memberMail;
	}
	public void setMemberMail(String memberMail) {
		this.memberMail = memberMail;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberMobile() {
		return memberMobile;
	}
	public void setMemberMobile(String memberMobile) {
		this.memberMobile = memberMobile;
	}
	public String getMemberImage() {
		return memberImage;
	}
	public void setMemberImage(String memberImage) {
		this.memberImage = memberImage;
	}
	public MultipartFile getMemberImageFile() {
		return memberImageFile;
	}
	public void setMemberImageFile(MultipartFile memberImageFile) {
		this.memberImageFile = memberImageFile;
	}
	
}
