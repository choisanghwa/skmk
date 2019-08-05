package kr.co.skmk.Service.Orders;

import kr.co.skmk.Model.DAO.Orders.OrdersDAO;
import kr.co.skmk.Model.DTO.Orders.OrderDTO;

public interface OrdersService {
	public int insertOrder(OrderDTO dto) throws Exception;
}
