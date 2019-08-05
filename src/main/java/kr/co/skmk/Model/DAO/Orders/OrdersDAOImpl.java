package kr.co.skmk.Model.DAO.Orders;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.co.skmk.Model.DAO.Food.FoodDAOImpl;
import kr.co.skmk.Model.DTO.Orders.OrderDTO;

@Repository
public class OrdersDAOImpl implements OrdersDAO {
	
	@Inject
	SqlSession sqlSession;
	
	private static String namespace = "orders";
	private static final Logger logger = LoggerFactory.getLogger(FoodDAOImpl.class);
	
	@Override
	public void insertOrder(OrderDTO order) throws Exception {
		// TODO Auto-generated method stub
		 sqlSession.insert(namespace+".insertOrder",order);
	}

}
