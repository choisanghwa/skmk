package kr.co.skmk.Model.DTO.Food;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FoodDTO {

	private String shopCode;
	private String foodCode;
	private String foodName;
	private String foodPrice;
	private List<String> foodImage;
	private List<MultipartFile> foodImageFile;
	
	public FoodDTO(String shopCode, String foodCode, String foodName, String foodPrice, List<String> foodImage, List<MultipartFile> foodImageFile) {
		this.shopCode  = shopCode;
		this.foodCode  = foodCode;
		this.foodName  = foodName;
		this.foodPrice = foodPrice;
		this.foodImage = foodImage;
		this.foodImageFile = foodImageFile;
	}
	
	public FoodDTO() {
	}
	
	public FoodDTO(String shopCode) {
		this.shopCode = shopCode;
	}
	
	public FoodDTO(String foodName, String foodPrice, List<MultipartFile> foodImageFile) {
		this.foodName  = foodName;
		this.foodPrice = foodPrice;
		this.foodImageFile  = foodImageFile;
	}
	
	public FoodDTO(String foodCode, String foodName, String foodPrice, String shopCode) {
		this.shopCode  = shopCode;
		this.foodCode  = foodCode;
		this.foodName  = foodName;
		this.foodPrice = foodPrice;
	}
	
	public FoodDTO(String foodCode, String foodName, String foodPrice, String shopCode, List<MultipartFile> foodImageFile) {
		this.shopCode  = shopCode;
		this.foodCode  = foodCode;
		this.foodName  = foodName;
		this.foodPrice = foodPrice;
		this.foodImageFile  = foodImageFile;
	}
	
	public FoodDTO(String foodCode, String foodName, String foodPrice, List<MultipartFile> foodImageFile) {
		this.foodImageFile  = foodImageFile;
		this.foodCode  = foodCode;
		this.foodName  = foodName;
		this.foodPrice = foodPrice;
	}
	
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
	public List<String> getFoodImage() {
		return foodImage;
	}
	public void setFoodImage(List<String> foodImage) {
		this.foodImage = foodImage;
	}
	public List<MultipartFile> getFoodImageFile() {
		return foodImageFile;
	}
	public void setFoodImageFile(List<MultipartFile> foodImageFile) {
		this.foodImageFile = foodImageFile;
	}
}
