package kr.co.skmk.Controller.Index;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.skmk.Controller.Login.LoginController;
import kr.co.skmk.Model.DTO.Member.MemberDTO;

@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	public static String RESOURCE_PATH;
	public static String FILE_MEMBER_PATH;
	public static String FILE_SHOP_PATH;
	public static String FILE_FOOD_PATH;
	public static String FILE_QR_PATH;
	
	public static String QR_GOOGLE_API_PATH = "http://chart.googleapis.com/chart?cht=qr&chs=200x200&chl=";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model model, HttpServletRequest request) {		

		RESOURCE_PATH = request.getServletContext().getRealPath("/resources").replace("\\",  "/");
		FILE_MEMBER_PATH = request.getServletContext().getRealPath("/resources/image/member").replace("\\",  "/");
		FILE_SHOP_PATH = request.getServletContext().getRealPath("/resources/image/shop").replace("\\",  "/");
		FILE_FOOD_PATH = request.getServletContext().getRealPath("/resources/image/food").replace("\\",  "/");
		FILE_QR_PATH = request.getServletContext().getRealPath("/resources/image/qr").replace("\\",  "/");
		
		model.addAttribute("page", "login/login.jsp");
		return "index";
	}
	
}
