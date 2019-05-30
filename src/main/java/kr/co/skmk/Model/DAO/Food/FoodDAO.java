package kr.co.skmk.Model.DAO.Food;

import kr.co.skmk.Model.DTO.Food.FoodDTO;

public interface FoodDAO {

	public int insertFood(FoodDTO food);
	public FoodDTO searchFood(FoodDTO dto);
}
