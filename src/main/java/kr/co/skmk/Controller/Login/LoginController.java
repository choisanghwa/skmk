package kr.co.skmk.Controller.Login;

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
import kr.co.skmk.Model.DTO.Member.MemberDTO;
import kr.co.skmk.Service.Member.MemberService;

@Controller
@RequestMapping("/login")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Inject //MemberService 객체가 자동으로 주입됨.
	MemberService memberService;
	
	@RequestMapping(value="/registerMember", method=RequestMethod.GET)
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
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
	public String loginProcess(@ModelAttribute MemberDTO dto, Model model, HttpSession session) {
		
		boolean result = memberService.loginMember(dto);
		String value;
		
		if(result) {
			value = "1";
			session.setAttribute("status","success");
		} else {
			value = "0";
		}

		return value;
	}
}
