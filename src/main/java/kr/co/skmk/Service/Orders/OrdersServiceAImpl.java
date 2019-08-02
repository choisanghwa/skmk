package kr.co.skmk.Service.Orders;

import javax.inject.Inject;

import kr.co.skmk.Model.DAO.Orders.OrdersDAO;


public class OrdersServiceAImpl implements OrdersService{
	
	@Inject
	OrdersDAO orderdao;
	
	@Override
	public int insertOrder(OrdersDAO order) throws Exception {
		// TODO Auto-generated method stub
		return orderdao.insertOrder(order);
	}

}
