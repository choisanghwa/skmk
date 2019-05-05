package kr.co.skmk;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OracleConnectionTest {

	// 로깅 처리를 위한 코드
	private static final Logger logger = LoggerFactory.getLogger(OracleConnectionTest.class);
	
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin://@skmk.c0a4wjwcjnno.ap-northeast-2.rds.amazonaws.com:1521/ORCL";
	private static final String USER = "admin";
	private static final String PW = "azxcvbnm";
	
	@Test // JUnit이 테스트 하는 코드
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		
		try (Connection conn = DriverManager.getConnection(URL, USER, PW)) {
			System.out.println("AWS 데이터베이스 접속 성공");
			logger.info("AWS 데이터베이스 접속 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
