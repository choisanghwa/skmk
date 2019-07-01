package kr.co.skmk.Service.Shop;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import kr.co.skmk.Model.DAO.Shop.ShopDAO;
import kr.co.skmk.Model.DTO.Shop.ShopDTO;

@Service
public class ShopServiceImpl implements ShopService {

	@Inject // 스프링 컨테이너가 만든 dao 객체가 연결됨 (의존관계 주입)
	ShopDAO shopDao;
	
	@Override
	public int insertShop(ShopDTO shop) {
		// TODO Auto-generated method stub
		return shopDao.insertShop(shop);
	}

	@Override
	public ShopDTO searchShop(String shopCode) {
		// TODO Auto-generated method stub
		return shopDao.searchShop(shopCode);
	}

}
