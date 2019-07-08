package kr.co.skmk.Model.DAO.Food;

import java.util.ArrayList;
import java.util.List;

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
	public List<FoodDTO> getFoodList(String shopCode) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("food.getFoodList", shopCode);
	}

	@Override
	public List<String> getFoodImage(String foodCode) {
		// TODO Auto-generated method stub
		List<String> list = sqlSession.selectList("food.getFoodImage", foodCode);
		List<String> result = new ArrayList();

		for(String image : list) {
			result.add("food/" + image);
		}
		return result;
	}

}
