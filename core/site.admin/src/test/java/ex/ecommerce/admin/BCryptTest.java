package ex.ecommerce.admin;

import org.junit.Test;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class BCryptTest {

	@Test
	public void test() {

		String password = "test";

		String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
		
		BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
		
		System.out.println("비밀번호 : " + password);
		System.out.println("암호화 : " + bcryptHashString );
		System.out.println("비교 : " + result.verified  );

	}
	
}