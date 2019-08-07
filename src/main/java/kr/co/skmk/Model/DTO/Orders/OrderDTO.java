package kr.co.skmk.Model.DTO.Orders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class OrderDTO {
	
	private String orderCode;
	private Date orderDate;
	private String memberMail;
	private List<OrdersFoodsDTO> ordersFoods = new ArrayList<OrdersFoodsDTO>();
	
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getMemberMail() {
		return memberMail;
	}
	public void setMemberMail(String memberMail) {
		this.memberMail = memberMail;
	}
	public List<OrdersFoodsDTO> getOrdersFoods() {
		return ordersFoods;
	}
	public void setOrdersFoods(List<OrdersFoodsDTO> ordersFoods) {
		this.ordersFoods = ordersFoods;
	}
}
