package ex.ecommerce.common.module.valid;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import ex.ecommerce.common.constant.ValidConstant;

@Controller
public class ValidController {

	@PostMapping(value="valid.json") 
	@ResponseBody 
	public Object validJson() throws Exception {
		return VALID_JSON();
	}

	private static final Object VALID_JSON() throws Exception {

		Map<String, Object> json = new HashMap<>();

		json.put("id",      new Valid(String.valueOf(ValidConstant.ID_MIN_NUM), ValidConstant.REG_ENG_NUM));
		json.put("pwd",     new Valid(String.valueOf(ValidConstant.PWD_MIN_NUM)));
		json.put("email",   new Valid(String.valueOf(ValidConstant.EMAIL_MIN_NUM), ValidConstant.REG_EMAIL));

		json.put("title",   new Valid(String.valueOf(ValidConstant.TITLE_MIN_NUM)));
		json.put("content", new Valid(String.valueOf(ValidConstant.CONTENT_MIN_NUM)));
		
		json.put("keyword", new Valid(String.valueOf(ValidConstant.KEYWORD_MIN_NUM)));
		
		return new ObjectMapper().writeValueAsString(json);
	}
	
}