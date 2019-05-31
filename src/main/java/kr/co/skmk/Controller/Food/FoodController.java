package kr.co.skmk.Controller.Food;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.skmk.Controller.Upload.UploadController;
import kr.co.skmk.Model.DTO.Food.FoodDTO;
import kr.co.skmk.Model.DTO.Member.MemberDTO;
import kr.co.skmk.Model.DTO.Shop.ShopDTO;
import kr.co.skmk.Service.Food.FoodService;

@Controller
public class FoodController {

	@Inject
	FoodService foodService;
	
	@ResponseBody
	@RequestMapping("/food/insertFood")
	public String register(@ModelAttribute FoodDTO dto, HttpSession session) {

		if(dto.getFoodImage() == null) {
			dto.setFoodImage(new ArrayList<String>());
		}
		
		dto.getFoodImageFile().forEach(x -> {
			try {
				dto.getFoodImage().add(
						UploadController.uploadFile(
						x.getOriginalFilename(), x.getBytes(), "food"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		ShopDTO shop = (ShopDTO) session.getAttribute("shop");
		dto.setShopCode(shop.getShopCode());

		return Integer.toString(foodService.insertFood(dto));
	}
	
	@RequestMapping(value="/food/goInsertFood", method=RequestMethod.GET)
	public String registerMember(Model model) {
		model.addAttribute("page", "food/registerFood.jsp");
		return "index";
	}
}
