package kr.co.skmk.Service.Orders;

import kr.co.skmk.Model.DAO.Orders.OrdersDAO;

public interface OrdersService {
	public int insertOrder(OrdersDAO order) throws Exception;
}
