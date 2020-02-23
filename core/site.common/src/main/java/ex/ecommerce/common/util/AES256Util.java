package ex.ecommerce.common.util;

import java.io.UnsupportedEncodingException;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.springframework.util.StringUtils;

public final class AES256Util {
	
	// 256bit(32자)
	public static Key AES_KEY_SIZE;
	
	// 128bit(16자)
	private static String IV;
	
	public AES256Util(String key) throws UnsupportedEncodingException {
		
		AES256Util.IV = key.substring(0, 16);
		
		byte[] keyBytes = new byte[16];
		byte[] b = key.getBytes("UTF-8");

		int bLength = b.length;
		
		if(bLength > keyBytes.length) {
			bLength = keyBytes.length;
		}

		System.arraycopy(b, 0, keyBytes, 0, bLength);
		
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
 
		AES256Util.AES_KEY_SIZE = keySpec;
		
	};
	
	public String encode(String str) {

		String encode = null;
		
		try {
			
			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			
			c.init(Cipher.ENCRYPT_MODE, AES_KEY_SIZE, new IvParameterSpec(IV.getBytes("UTF-8")));
			
			byte[] byteStr = c.doFinal(str.getBytes());
			
			encode = new String(Base64.encodeBase64(byteStr));
			
		} catch (Exception e) {

			e.printStackTrace();
		} 

		return encode;
	}
	
	public String decode(String str) {
		
		// 임시 적용 
		String key = StringUtils.replace(str, " ", "+");
		
		String decode = null;
		
		try {
			
			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			
			c.init(Cipher.DECRYPT_MODE, AES_KEY_SIZE, new IvParameterSpec(IV.getBytes("UTF-8")));
			
			byte[] byteStr = Base64.decodeBase64(key.getBytes());
			
			decode = new String(c.doFinal(byteStr), "UTF-8");
			
		} catch (Exception e) {

			e.printStackTrace();
		} 
		
		return decode;
	}
	
}