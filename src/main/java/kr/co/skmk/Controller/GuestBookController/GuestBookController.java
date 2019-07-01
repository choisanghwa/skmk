package kr.co.skmk.Controller.GuestBookController;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.skmk.Controller.Member.MemberController;
import kr.co.skmk.Controller.Upload.UploadController;
import kr.co.skmk.Model.DTO.GuestBook.GuestBookDTO;
import kr.co.skmk.Model.DTO.Member.MemberDTO;
import kr.co.skmk.Model.DTO.Shop.ShopDTO;
import kr.co.skmk.Service.GuestBook.GuestBookService;

@RestController
public class GuestBookController {

	@Inject
	GuestBookService guestService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping (value = "/guestBook/register", method = RequestMethod.POST)
	public JSONObject register(@ModelAttribute GuestBookDTO dto, HttpSession session) throws IOException, Exception {
		JSONObject result = new JSONObject();
		ShopDTO shop = (ShopDTO)session.getAttribute("shop");
		dto.setShopCode(shop.getShopCode());
		
		if(guestService.insertGuestBook(dto) == 1) {
			result.put("result",  1);
			result.put("guestList", getGuestBookList(guestService.getGuestBookList(shop.getShopCode())));
		} else {
			result.put("result",  0);
		};
		
		return result;

	}
	
	public static JSONArray getGuestBookList(List<GuestBookDTO> list) throws Exception {
		JSONArray result = new JSONArray();
		
		for(GuestBookDTO item : list) {
			JSONObject object = new JSONObject();
			object.put("guestBookTitle",item.getGuestBookTitle());
			object.put("guestBookContent",item.getGuestBookContent());
			object.put("guestBookTime",item.getGuestBookTime());
			result.add(object);
		}
		
		return result;
	}
}
