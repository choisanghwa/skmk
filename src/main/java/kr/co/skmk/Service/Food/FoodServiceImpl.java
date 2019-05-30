package kr.co.skmk.Service.Food;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.skmk.Model.DAO.Food.FoodDAO;
import kr.co.skmk.Model.DTO.Food.FoodDTO;

@Service
public class FoodServiceImpl implements FoodService {

	@Inject // 스프링 컨테이너가 만든 dao 객체가 연결됨 (의존관계 주입)
	FoodDAO foodDao;
	
	@Override
	public int insertFood(FoodDTO food) {
		// TODO Auto-generated method stub
		return foodDao.insertFood(food);
	}

	@Override
	public FoodDTO searchFood(FoodDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
