package kr.co.skmk.Controller.Shop;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.skmk.Controller.Index.IndexController;
import kr.co.skmk.Model.DTO.Member.MemberDTO;
import kr.co.skmk.Model.DTO.Shop.ShopDTO;
import kr.co.skmk.Service.Shop.ShopService;

@Controller
public class ShopController {

	@Inject
	ShopService shopService;
	
	@ResponseBody
	@RequestMapping("/shop/register")
	public String register(@ModelAttribute ShopDTO dto, HttpSession session) {
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		dto.setMemberMail(member.getMemberMail());
		return Integer.toString(shopService.insertShop(dto));
	}
	
	@RequestMapping(value="/shop/successInsertShop", method=RequestMethod.GET)
	public String successRegister(Model model, HttpSession session) {
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		ShopDTO shop = shopService.searchShop(member.getMemberMail());
		
		if(shop != null) {
			session.setAttribute("shop", shop);
		} else {
			
		}
		
		model.addAttribute("page", "main/main.jsp");
		return "index";
	}
	
	@RequestMapping(value="/shop/goRegisterShop", method=RequestMethod.GET)
	public String registerMember(Model model) {
		model.addAttribute("page", "shop/registerShop.jsp");
		return "index";
	}
}
