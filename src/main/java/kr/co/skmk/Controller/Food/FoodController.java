package kr.co.skmk.Controller.Food;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@ResponseBody
	@RequestMapping(value="/food/getFoodDetail", method=RequestMethod.POST)
	public JSONArray getFoodDetail(@ModelAttribute FoodDTO dto, HttpSession session) {
		
		System.out.println(dto);
		JSONArray result = new JSONArray();
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/qr/{shopCode}", method=RequestMethod.GET)
	JSONArray getFoodList(@PathVariable("shopCode") String shopCode, HttpSession session) {
		JSONArray result = new JSONArray();
		List<FoodDTO> dto = foodService.getFoodList(shopCode);
		
		JSONObject obj = new JSONObject();
		obj.put("list", dto);
		result.add(obj);
		return result;
	}
}
