package kr.co.skmk.Service.Orders;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.skmk.Model.DAO.Orders.OrdersDAO;
import kr.co.skmk.Model.DTO.Orders.OrderDTO;

@Service
public class OrdersServiceImpl implements OrdersService{
	
	@Inject
	OrdersDAO orderdao;
	
	@Override
	public void insertOrder(OrderDTO order) throws Exception {
		
		orderdao.insertOrder(order);
	}

}
