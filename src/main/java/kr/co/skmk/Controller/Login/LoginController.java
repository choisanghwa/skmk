package kr.co.skmk.Controller.Login;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.skmk.Controller.Index.IndexController;
import kr.co.skmk.Model.DTO.Food.FoodDTO;
import kr.co.skmk.Model.DTO.Member.MemberDTO;
import kr.co.skmk.Model.DTO.Shop.ShopDTO;
import kr.co.skmk.Service.Food.FoodService;
import kr.co.skmk.Service.Member.MemberService;
import kr.co.skmk.Service.Shop.ShopService;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Inject //MemberService 객체가 자동으로 주입됨.
	MemberService memberService;
	
	@Inject
	ShopService shopService;
	
	@Inject
	FoodService foodService;
	
	@RequestMapping(value="/login/registerMember", method=RequestMethod.GET)
	public String registerMember(Model model) {
		model.addAttribute("page", "member/registerMember.jsp");
		return "index";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("page", "login/login.jsp");
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value="/login/loginProcess", method=RequestMethod.POST)
	public String loginProcess(@ModelAttribute MemberDTO dto, Model model, HttpSession session) {
		
		dto = memberService.loginMember(dto);
		ShopDTO shop = new ShopDTO();
		String result;

		String path = IndexController.RESOURCE_PATH;
				
		if(dto != null) {
			
			if (dto.getMemberImage() == null) {
				dto.setMemberImage("./resources/image/unknown_userImage.png");
			}
			else {
				dto.setMemberImage("member/" + dto.getMemberImage());
			}
			session.setAttribute("status","success");
			session.setAttribute("member", dto);
			
			shop = shopService.searchShop(dto.getMemberMail());// 가게 생성 여부 확인		
			if(shop != null) {
				session.setAttribute("shop", shop);
				
				List<FoodDTO> foodList = foodService.getFoodList(shop.getShopCode());
				
				session.setAttribute("foodList", foodList);
				
			} else {
				
			}
			result = "1";

		} else {
			result = "0";
		}
		
		return result;
	}
	
	@RequestMapping(value="/login/logout", method=RequestMethod.GET)
	public String logout(Model model, HttpSession session) {
		
		session.invalidate();

		model.addAttribute("page", "login/login.jsp");
		return "index";
	}
}
