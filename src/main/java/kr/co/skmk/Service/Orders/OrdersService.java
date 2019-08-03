package kr.co.skmk.Service.Orders;

import kr.co.skmk.Model.DAO.Orders.OrdersDAO;
import kr.co.skmk.Model.DTO.Orders.OrderDTO;

public interface OrdersService {
	public void insertOrder(OrderDTO dto) throws Exception;
}
