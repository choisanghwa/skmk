package kr.co.skmk.Controller.Upload;

import java.io.File;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;

import kr.co.skmk.Controller.Index.IndexController;
import kr.co.skmk.Controller.Member.MemberController;

@Controller
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	public static String uploadFile(String originalName, byte[] fileData, String uploadPath) throws Exception {
		
		String path;
		String savedName;
		
		if(originalName.isEmpty()) {
			switch(uploadPath) {
				case "member" : savedName = "unknown_userImage.png"; break;
				case "shop" : savedName = "unknown_shopLogo.png"; break;
				case "food" : savedName = "unknown_foodImage.png"; break;
				case "qr" :savedName = null; break; // QR은 무조건 생성되기 때문에 null 처리 여부 필요 X.
				default : savedName = ""; // 디폴트로 빈칸 처리
			}
		} else {
			switch(uploadPath) {
				case "member" : path = IndexController.FILE_MEMBER_PATH; break;
				case "shop" : path = IndexController.FILE_SHOP_PATH; break;
				case "food" : path = IndexController.FILE_FOOD_PATH; break;
				case "qr" : path = IndexController.FILE_QR_PATH; break;
				default : path = IndexController.RESOURCE_PATH + "/image"; break;
			}
			
			// 1) UUID 생성 (Universal Unique Identifier, 범용 고유 식별자)
			UUID uid = UUID.randomUUID();
			savedName = uid.toString() + "_" + originalName;
			File target = new File(path, savedName);
			
			// 임시 디렉토리에 저장된 업로드된 파일을
			// 지정된 디렉토리로 복사
			// FileCopyUtils.copy ( 바이트 배열, 파일 객체)
			
			// 디렉토리 검사
			File dir = new File(path);
			
			if(dir.isDirectory() == false) {
				dir.mkdirs();
			}
			dir = null;
			
			FileCopyUtils.copy(fileData, target);
		}

		return savedName;
	}
}
