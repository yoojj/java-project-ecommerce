package ex.ecommerce.admin.util;

import java.security.SecureRandom;
import java.util.Base64;

import org.junit.Test;

import ex.ecommerce.common.util.AES256Util;

public class AES256UtilTest {

	@Test
	public void test() throws Exception {
		
		String id = "testUserID";
		
		byte[] bytes = new byte[16];

		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		
		sr.nextBytes(bytes);
		
		String key = Base64.getEncoder().encodeToString(bytes);
		
		AES256Util aes256 = new AES256Util(key);
		
		String idEn = aes256.encode(id);
		
		String idDe = aes256.decode(idEn);
		
		System.out.println("입력값 : " + id);
		System.out.println("키 : " + key );
		System.out.println("암호화 : " + idEn);
		System.out.println("부호화 : " + idDe);
		
	}
	
}