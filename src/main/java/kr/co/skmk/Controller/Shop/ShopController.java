package kr.co.skmk.Controller.Shop;

import kr.co.skmk.Controller.Index.IndexController;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;
import java.util.zip.GZIPInputStream;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.skmk.Controller.Index.IndexController;
import kr.co.skmk.Controller.Member.MemberController;
import kr.co.skmk.Controller.Upload.UploadController;
import kr.co.skmk.Model.DTO.Food.FoodDTO;
import kr.co.skmk.Model.DTO.Member.MemberDTO;
import kr.co.skmk.Model.DTO.Shop.ShopDTO;
import kr.co.skmk.Service.Shop.ShopService;

@Controller
public class ShopController {

	@Inject
	ShopService shopService;
	
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@ResponseBody
	@RequestMapping (value = "/shop/checkShopCode", method = RequestMethod.GET)
	public String checkShopCode(String shopCode, HttpServletRequest request, HttpSession session) throws IOException, Exception {
				
		if(shopService.searchShop(shopCode) == null) {
			return "0";
		}
		else
			return "1";
	}
	
	
	@ResponseBody
	@RequestMapping (value = "/shop/register", method = RequestMethod.POST)
	public String register(@ModelAttribute ShopDTO dto, MultipartHttpServletRequest request, HttpSession session) throws IOException, Exception {
				
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
		ShopDTO shop = shopService.searchShop(member.getMemberMail().substring(0, member.getMemberMail().indexOf("@")));
		
		if(shop != null) {
			session.setAttribute("shop", shop);
		} else {
			
		}
		
		model.addAttribute("page", "main/main.jsp");
		return "index";
	}
	
	@RequestMapping(value="/shop/goRegisterShop", method=RequestMethod.GET)
	public String registerMember(Model model, HttpSession session) {
		MemberDTO loginMember = (MemberDTO) session.getAttribute("member");
		session.setAttribute("url", loginMember.getMemberMail().substring(0, loginMember.getMemberMail().indexOf("@")));
		
		model.addAttribute("page", "shop/registerShop.jsp");
		return "index";
	}
		
	@ResponseBody
	@RequestMapping (value = "/shop/makeQR", method = RequestMethod.POST)
	public JSONObject makeQR(HttpSession session, HttpServletRequest request) throws IOException, Exception {
		JSONObject result = new JSONObject();
		
		try {	
			ShopDTO dto = (ShopDTO) session.getAttribute("shop");
			if(dto != null) {
				String isMyShop = (String) session.getAttribute("isMyShop");
				if(Integer.parseInt(isMyShop) == 1) {
					
					URL url=new URL(IndexController.QR_GOOGLE_API_PATH + request.getRequestURL().toString().replace(request.getRequestURI(),"") + "/skmk/qr/" + dto.getShopCode());
					URLConnection ucon=url.openConnection();
					
					HttpURLConnection httpConn = (HttpURLConnection)ucon;
					httpConn.setRequestMethod("GET");
					httpConn.setRequestProperty("Connection", "Keep-Alive" );
					httpConn.setRequestProperty("Content-Type", "image/png");
					httpConn.connect();
				      
					if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {

						String path = IndexController.FILE_QR_PATH;
						File dir = new File(path);
						
						if(dir.isDirectory() == false) {
							dir.mkdirs();
						}
						dir = null;
						
						InputStream is = httpConn.getInputStream(); // 입력스트림을 얻자
																
						UUID uid = UUID.randomUUID();
						String fileName = uid.toString() + "_" + dto.getShopCode() + ".png";
						
						FileOutputStream outputStream = new FileOutputStream(fileName);
						
						if ("gzip".equals(httpConn.getContentEncoding())) {
							System.out.println("zipped image");
							is = new GZIPInputStream(is);
						}
						
						int bytesRead = -1;
						byte[] buffer = new byte[2048];
						while ((bytesRead = is.read(buffer)) != -1) {
							outputStream.write(buffer, 0, bytesRead);
						}
						
						File target = new File(path, fileName);
						FileCopyUtils.copy(buffer, target);
						
						dto.setShopQR(fileName);
						if(shopService.insertShopQR(dto) == 1) {
							result.put("shopQR", dto.getShopQR());
						}
						
						is.close();
						outputStream.close();

					}					
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
