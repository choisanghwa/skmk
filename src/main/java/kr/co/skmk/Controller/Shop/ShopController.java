package kr.co.skmk.Controller.Shop;

import java.io.IOException;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.skmk.Controller.Index.IndexController;
import kr.co.skmk.Controller.Member.MemberController;
import kr.co.skmk.Controller.Upload.UploadController;
import kr.co.skmk.Model.DTO.Member.MemberDTO;
import kr.co.skmk.Model.DTO.Shop.ShopDTO;
import kr.co.skmk.Service.Shop.ShopService;

@Controller
public class ShopController {

	@Inject
	ShopService shopService;
	
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@ResponseBody
	@RequestMapping (value = "/shop/register", method = RequestMethod.POST)
	public String register(@ModelAttribute ShopDTO dto, MultipartHttpServletRequest request, HttpSession session) throws IOException, Exception {
		
		System.out.println(dto);
		
		String savedName = UploadController.uploadFile(
				dto.getShopLogoFile().getOriginalFilename(),
				dto.getShopLogoFile().getBytes(), "shop");
	
		dto.setShopLogo(savedName);
		
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
