package kr.co.skmk.Controller.Index;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	public static String RESOURCE_PATH;
	public static String FILE_MEMBER_PATH;
	public static String FILE_SHOP_PATH;
	public static String FILE_FOOD_PATH;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model model, HttpServletRequest request) {		

		RESOURCE_PATH = request.getServletContext().getRealPath("/resources").replace("\\",  "/");
		FILE_MEMBER_PATH = request.getServletContext().getRealPath("/resources/image/member").replace("\\",  "/");
		FILE_SHOP_PATH = request.getServletContext().getRealPath("/resources/image/shop").replace("\\",  "/");
		FILE_FOOD_PATH = request.getServletContext().getRealPath("/resources/image/food").replace("\\",  "/");
		
		model.addAttribute("page", "login/login.jsp");
		return "index";
	}
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("page", "main/main.jsp");
		return "index";
	}
		
}
