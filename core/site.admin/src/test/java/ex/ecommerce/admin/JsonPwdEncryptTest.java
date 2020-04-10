package ex.ecommerce.admin;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class JsonPwdEncryptTest {

	@Test
	public void test() throws JsonProcessingException {
	
		final String json = "{\"id\":\"test\",\"pwd\":\"test\"}";
		
		final ObjectMapper om = new ObjectMapper();
		
		final JsonNode node = om.readValue(json, JsonNode.class);
		
		final String pwd = node.get("pwd").toString();
		
		final String pwdEncrypt = BCrypt.withDefaults().hashToString(12, pwd.toCharArray());
		
		((ObjectNode)node).put("pwd", pwdEncrypt); 
		
		System.out.println(node);
        
	}
}