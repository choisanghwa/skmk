package kr.co.skmk.Model.DAO.Shop;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.co.skmk.Model.DAO.Member.MemberDAOImpl;
import kr.co.skmk.Model.DTO.Shop.ShopDTO;

@Repository
public class ShopDAOImpl implements ShopDAO {

	private static final Logger logger = LoggerFactory.getLogger(ShopDAOImpl.class);
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public int insertShop(ShopDTO shop) {
		// TODO Auto-generated method stub
		return sqlSession.insert("shop.insertShop", shop);
	}

	@Override
	public ShopDTO searchShop(String shopCode) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("shop.searchShop", shopCode);
	}

}
