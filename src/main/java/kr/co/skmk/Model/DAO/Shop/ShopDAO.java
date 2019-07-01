package kr.co.skmk.Model.DAO.Shop;

import kr.co.skmk.Model.DTO.Shop.ShopDTO;

public interface ShopDAO {

	public int insertShop(ShopDTO shop);
	public ShopDTO searchShop(String shopCode);
}
