package kr.co.skmk.Model.DTO.Orders;

public class OrderDTO {
	private String ordercode;
	private date orderdata;
	private String foodcode;
	private String shopcode;
	private String membermail;
	private String ordercount;
	public String getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}
	public date getOrderdata() {
		return orderdata;
	}
	public void setOrderdata(date orderdata) {
		this.orderdata = orderdata;
	}
	public String getFoodcode() {
		return foodcode;
	}
	public void setFoodcode(String foodcode) {
		this.foodcode = foodcode;
	}
	public String getShopcode() {
		return shopcode;
	}
	public void setShopcode(String shopcode) {
		this.shopcode = shopcode;
	}
	public String getMembermail() {
		return membermail;
	}
	public void setMembermail(String membermail) {
		this.membermail = membermail;
	}
	public String getOrdercount() {
		return ordercount;
	}
	public void setOrdercount(String ordercount) {
		this.ordercount = ordercount;
	}
	
	

}
