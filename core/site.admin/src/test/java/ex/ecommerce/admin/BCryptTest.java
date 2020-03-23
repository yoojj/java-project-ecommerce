package ex.ecommerce.admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import at.favre.lib.crypto.bcrypt.BCrypt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:config/common-context.xml", 
		"classpath*:config/db-context.xml", "classpath*:config/mail-context.xml"})
@WebAppConfiguration
public class BCryptTest {

	@Test
	public void test() {
		
		String password = "0000";

		String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
		
		BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
		
		System.out.println("비밀번호 : " + password);
		System.out.println("암호화 : " + bcryptHashString );
		System.out.println("비교 : " + result.verified  );

	}
	
}