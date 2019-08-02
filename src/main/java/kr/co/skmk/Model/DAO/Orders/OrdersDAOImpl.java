package kr.co.skmk.Model.DAO.Orders;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.skmk.Model.DAO.Food.FoodDAOImpl;

public class OrdersDAOImpl implements OrdersDAO {
	
	@Inject
	SqlSession sqlSession;
	
	private static String namespace = "orders";
	private static final Logger logger = LoggerFactory.getLogger(FoodDAOImpl.class);
	
	@Override
	public int insertOrder(OrdersDAO order) throws Exception {
		// TODO Auto-generated method stub
			
		return sqlSession.insert(namespace+".insertOrder",order);
	}

}
