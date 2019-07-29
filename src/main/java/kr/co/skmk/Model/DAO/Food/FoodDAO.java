package kr.co.skmk.Model.DAO.Food;

import java.util.List;

import kr.co.skmk.Model.DTO.Food.FoodDTO;

public interface FoodDAO {

	public int insertFood(FoodDTO food);
	public List<FoodDTO> getFoodList(String shopCode);
	public List<String> getFoodImage(String foodCode);
	public FoodDTO getFoodDetail(FoodDTO dto);
}
