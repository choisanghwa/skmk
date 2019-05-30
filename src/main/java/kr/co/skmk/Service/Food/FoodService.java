package kr.co.skmk.Service.Food;

import kr.co.skmk.Model.DTO.Food.FoodDTO;

public interface FoodService {

	public int insertFood(FoodDTO food);
	public FoodDTO searchFood(FoodDTO dto);
}
