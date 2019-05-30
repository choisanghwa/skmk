package kr.co.skmk.Model.DTO.Food;

import org.springframework.web.multipart.MultipartFile;

public class FoodImageDTO {
	
	private String FoodCode;
	private String FoodImage;
	private MultipartFile FoodImageFile;
	
	public String getFoodCode() {
		return FoodCode;
	}
	public void setFoodCode(String foodCode) {
		FoodCode = foodCode;
	}
	public String getFoodImage() {
		return FoodImage;
	}
	public void setFoodImage(String foodImage) {
		FoodImage = foodImage;
	}
	public MultipartFile getFoodImageFile() {
		return FoodImageFile;
	}
	public void setFoodImageFile(MultipartFile foodImageFile) {
		FoodImageFile = foodImageFile;
	}
}
