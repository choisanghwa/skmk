package kr.co.skmk.Service.Orders;

import javax.inject.Inject;

import kr.co.skmk.Model.DAO.Orders.OrdersDAO;
import kr.co.skmk.Model.DTO.Orders.OrderDTO;


public class OrdersServiceAImpl implements OrdersService{
	
	@Inject
	OrdersDAO orderdao;
	
	@Override
	public void insertOrder(OrderDTO order) throws Exception {
		
		orderdao.insertOrder(order);
	}

}
