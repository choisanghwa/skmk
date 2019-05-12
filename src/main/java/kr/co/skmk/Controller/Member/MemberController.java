package kr.co.skmk.Controller.Member;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.skmk.Model.DTO.Member.MemberDTO;
import kr.co.skmk.Service.Member.MemberService;

// AJAX 처리 전용 컨트롤러
@RestController // 스프링 4.0 이상부터 사용 가능
public class MemberController {

	@Inject //MemberService 객체가 자동으로 주입됨.
	MemberService memberService;
	
	// @ResponseBody // @Json 방식으로 데이터 리턴 - RestController 에서는 생략 가능
	@RequestMapping ("/member/register")
	public String register(@ModelAttribute MemberDTO dto) {
		return Integer.toString(memberService.insertMember(dto));
	}
		
	@RequestMapping(value="/member/successRegister", method=RequestMethod.GET)
	public String successRegister(Model model) {
		model.addAttribute("page", "login/login.jsp");
		return "index";
	}
}
