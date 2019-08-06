package kr.co.skmk.Service.Shop;

import kr.co.skmk.Model.DTO.Shop.ShopDTO;

public interface ShopService {

	public int insertShop(ShopDTO shop);
	public ShopDTO searchShop(String shopCode);
	public int insertShopQR(ShopDTO dto);
}
