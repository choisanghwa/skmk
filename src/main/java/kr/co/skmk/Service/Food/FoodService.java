package kr.co.skmk.Service.Food;

import java.util.List;

import kr.co.skmk.Model.DTO.Food.FoodDTO;

public interface FoodService {

	public int insertFood(FoodDTO food);
	public List<FoodDTO> getFoodList(String shopCode);
}
