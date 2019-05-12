package kr.co.skmk.Controller.MemberController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.skmk.Model.DTO.Member.MemberDTO;

// AJAX 처리 전용 컨트롤러
@RestController // 스프링 4.0 이상부터 사용 가능
public class MemberController {

	// @ResponseBody // @Json 방식으로 데이터 리턴 - RestController 에서는 생략 가능
	@RequestMapping ("/member/register")
	public MemberDTO register() {
	
		MemberDTO result = new MemberDTO();		
		return result;
	}
}
