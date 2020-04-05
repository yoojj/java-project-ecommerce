package ex.ecommerce.common.util;

import at.favre.lib.crypto.bcrypt.BCrypt;

public final class BCryptCheckUtil {

	public static boolean check(String pwd, String dbPwd) {
		
		final BCrypt.Result result = BCrypt.verifyer().verify(pwd.toCharArray(), dbPwd);
		
		if(result.verified == true) {
			return true;
		}
		
		return false;
	}
	
}