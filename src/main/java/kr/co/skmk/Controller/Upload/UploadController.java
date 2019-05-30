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

	public static String uploadFile(String originalName, byte[] fileData) throws Exception {
		
		// 1) UUID 생성 (Universal Unique Identifier, 범용 고유 식별자)
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + originalName;
		File target = new File(IndexController.RESOURCE_PATH, savedName);
		
		// 임시 디렉토리에 저장된 업로드된 파일을
		// 지정된 디렉토리로 복사
		// FileCopyUtils.copy ( 바이트 배열, 파일 객체)
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}
}
