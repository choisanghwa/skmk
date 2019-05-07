package kr.co.skmk.LoginController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/registerMember", method=RequestMethod.GET)
	public String registerMember(Model model) {
		model.addAttribute("page", "member/registerMember.jsp");
		return "index";
	}
}
