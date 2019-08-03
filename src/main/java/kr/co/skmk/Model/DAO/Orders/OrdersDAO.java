package kr.co.skmk.Model.DAO.Orders;

import kr.co.skmk.Model.DTO.Orders.OrderDTO;

public interface OrdersDAO {
	public void insertOrder(OrderDTO order) throws Exception;
}
