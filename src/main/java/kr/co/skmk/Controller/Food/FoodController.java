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
	public JSONObject getFoodDetail(@ModelAttribute FoodDTO dto, HttpSession session) {		
		return makeResult(foodService.getFoodDetail(dto));
	}
	
	@ResponseBody
	@RequestMapping(value="/qr/{shopCode}", method=RequestMethod.GET)
	JSONArray getFoodList(@PathVariable("shopCode") String shopCode, HttpSession session) {
		JSONArray result = new JSONArray();
		List<FoodDTO> list = foodService.getFoodList(shopCode);
		return getByJsonArray(list);
	}
	
	public JSONArray getByJsonArray(List<FoodDTO> list) {
		JSONArray result = new JSONArray();
		
		for (FoodDTO dto : list) {
			JSONObject obj = parseJSONObject(dto);
			result.add(obj);
		}
		
		return result;
	}
	
	public JSONObject parseJSONObject(FoodDTO dto) {
		
		JSONObject result = new JSONObject();
		result.put("shopCode", dto.getShopCode());
		result.put("foodCode", dto.getFoodCode());
		result.put("foodName", dto.getFoodName());
		result.put("shopPrice", dto.getFoodPrice());
		result.put("getfoodImage", dto.getFoodImage());
		
		return result;
	}
	
	private JSONObject makeResult(FoodDTO dto) {
		JSONObject result = new JSONObject();
		
		result.put("shopCode", dto.getShopCode());
		result.put("foodCode", dto.getFoodCode());
		result.put("foodName", dto.getFoodName());
		result.put("shopPrice", dto.getFoodPrice());
		result.put("result", dto.getFoodImage());
		return result;
	}
}
