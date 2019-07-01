package kr.co.skmk.Controller.Login;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.skmk.Controller.GuestBookController.GuestBookController;
import kr.co.skmk.Controller.Index.IndexController;
import kr.co.skmk.Model.DTO.Food.FoodDTO;
import kr.co.skmk.Model.DTO.GuestBook.GuestBookDTO;
import kr.co.skmk.Model.DTO.Member.MemberDTO;
import kr.co.skmk.Model.DTO.Shop.ShopDTO;
import kr.co.skmk.Service.Food.FoodService;
import kr.co.skmk.Service.GuestBook.GuestBookService;
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
	
	@Inject
	GuestBookService guestService;
	
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
	public String loginProcess(@ModelAttribute MemberDTO dto, Model model, HttpSession session) throws Exception {
		
		return getUserInfo(memberService.loginMember(dto), model, session);
	}
	
	public String getUserInfo(MemberDTO loginMember, Model model, HttpSession session) throws Exception {
		loginMember = memberService.loginMember(loginMember);
		ShopDTO shop = new ShopDTO();
		String result;

		String path = IndexController.RESOURCE_PATH;
				
		if(loginMember != null) {
			
			if (loginMember.getMemberImage() == null) {
				loginMember.setMemberImage("./resources/image/unknown_userImage.png");
			}
			else {
				loginMember.setMemberImage("member/" + loginMember.getMemberImage());
			}
			session.setAttribute("status","success");
			session.setAttribute("member", loginMember);
			session.setAttribute("url", loginMember.getMemberMail().substring(0, loginMember.getMemberMail().indexOf("@")));
			
			shop = shopService.searchShop(loginMember.getMemberMail().substring(0, loginMember.getMemberMail().indexOf("@")));// 가게 생성 여부 확인		
			if(shop != null) {
				session.setAttribute("shop", shop);
				session.setAttribute("isMyShop", "1");
				
				List<FoodDTO> foodList = foodService.getFoodList(shop.getShopCode());
				List<GuestBookDTO> guestList = guestService.getGuestBookList(shop.getShopCode());
				
				session.setAttribute("foodList", foodList);
				session.setAttribute("guestList", GuestBookController.getGuestBookList(guestService.getGuestBookList(shop.getShopCode())));
			} else {
				
			}
			result = "1";

		} else {
			result = "0";
		}
		
		return result;
		
	}

	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(Model model, HttpSession session) {
		
		session.invalidate();

		model.addAttribute("page", "login/login.jsp");
		return "index";
	}
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main(Model model, HttpSession session) {
		session.setAttribute("url", "main");
		MemberDTO dto = (MemberDTO) session.getAttribute("member");
		try {
			if(dto != null) {
				
				String mail = dto.getMemberMail().substring(0, dto.getMemberMail().indexOf("@"));
				ShopDTO shop = shopService.searchShop(mail);
				session.setAttribute("shop", shop);
				
				if(shop == null) {
				} else {
					session.setAttribute("isMyShop", "1");
					
					List<FoodDTO> foodList = foodService.getFoodList(shop.getShopCode());
					List<GuestBookDTO> guestList = guestService.getGuestBookList(shop.getShopCode());
					
					session.setAttribute("foodList", foodList);
					session.setAttribute("guestList", GuestBookController.getGuestBookList(guestService.getGuestBookList(shop.getShopCode())));
				}
				model.addAttribute("page", "main/main.jsp");
			}
			else {
				model.addAttribute("page", "login/login.jsp"); // 7번
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return "index";
	}
	
	@RequestMapping(value="/{shopCode}")
	public String page(@PathVariable("shopCode") String shopCode, Model model, HttpSession session) throws Exception {
		
		session.setAttribute("url", shopCode);
		ShopDTO shop = shopService.searchShop(shopCode);
		session.setAttribute("shop", shop);
		
		MemberDTO dto = (MemberDTO)session.getAttribute("member");
		if (dto != null) {
			String memberMail = dto.getMemberMail();// 내껀지 아닌지 확인
			String result = memberService.getMemberMailByShopCode(shopCode);
			
			
			if(result != null) {
				if(memberMail.equals(result)) {
					session.setAttribute("isMyShop", "1");
				}
				else {
					session.setAttribute("isMyShop", "0");
				}
			}
			else {
				session.setAttribute("isMyShop", "0");
			}
		}
		
		if(shop != null) {
			List<FoodDTO> foodList = foodService.getFoodList(shop.getShopCode());
			List<GuestBookDTO> guestList = guestService.getGuestBookList(shop.getShopCode());
			
			session.setAttribute("foodList", foodList);
			session.setAttribute("guestList", GuestBookController.getGuestBookList(guestService.getGuestBookList(shop.getShopCode())));
		}
				
		model.addAttribute("page", "main/main.jsp");
		return "index";
	}
}
