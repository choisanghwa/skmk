package kr.co.skmk.Model.DAO.Food;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.co.skmk.Model.DTO.Food.FoodDTO;

@Repository
public class FoodDAOImpl implements FoodDAO {

	private static final Logger logger = LoggerFactory.getLogger(FoodDAOImpl.class);
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public int insertFood(FoodDTO food) {
		// TODO Auto-generated method stub
		int result = sqlSession.insert("food.insertFood", food);
		food.setFoodCode((String) sqlSession.selectOne("food.searchFoodCode", food));
		sqlSession.insert("food.insertFoodImage", food);
		return result;
	}

	@Override
	public FoodDTO searchFood(FoodDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
