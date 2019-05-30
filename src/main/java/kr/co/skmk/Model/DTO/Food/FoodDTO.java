package kr.co.skmk.Model.DTO.Food;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FoodDTO {

	private String shopCode;
	private String foodCode;
	private String foodName;
	private String foodPrice;
	private List<FoodImageDTO> foodImageFiles;
	private List<MultipartFile> foodImage;
	
	public String getShopCode() {
		return shopCode;
	}
	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}
	public String getFoodCode() {
		return foodCode;
	}
	public void setFoodCode(String foodCode) {
		this.foodCode = foodCode;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(String foodPrice) {
		this.foodPrice = foodPrice;
	}
	public List<FoodImageDTO> getFoodImageFiles() {
		return foodImageFiles;
	}
	public void setFoodImageFiles(List<FoodImageDTO> foodImageFiles) {
		this.foodImageFiles = foodImageFiles;
	}
	public List<MultipartFile> getFoodImage() {
		return foodImage;
	}
	public void setFoodImage(List<MultipartFile> foodImage) {
		this.foodImage = foodImage;
	}
}
