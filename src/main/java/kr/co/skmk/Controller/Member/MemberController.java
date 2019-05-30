package kr.co.skmk.Controller.Member;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.skmk.Controller.Upload.UploadController;
import kr.co.skmk.Model.DTO.Member.MemberDTO;
import kr.co.skmk.Service.Member.MemberService;

// AJAX 처리 전용 컨트롤러
@RestController // 스프링 4.0 이상부터 사용 가능
public class MemberController {

	@Inject //MemberService 객체가 자동으로 주입됨.
	MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// @ResponseBody // @Json 방식으로 데이터 리턴 - RestController 에서는 생략 가능
	@RequestMapping ("/member/register")
	public String register(MultipartFile file, HttpServletRequest request) throws IOException, Exception {
		
		MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;

		System.out.println(file);
		
		// logger.info("파일 이름:" + file.getOriginalFilename());
		// String savedName = file.getOriginalFilename();
		// logger.info("파일 크기:" + file.getSize());
		// logger.info("컨텐트 타입 :" + file.getContentType());
		// savedName = UploadController.uploadFile(savedName, file.getBytes());
		
		// dto.setMemberImage(savedName);
		
		// return Integer.toString(memberService.insertMember(dto));
		return "1";
	}
		
	@RequestMapping(value="/member/successRegister", method=RequestMethod.GET)
	public String successRegister(Model model) {
		model.addAttribute("page", "login/login.jsp");
		return "index";
	}
}
