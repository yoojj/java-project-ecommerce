package ex.ecommerce.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ex.ecommerce.common.constant.SessionConstant;

@Controller
public class ConstantController {

	@PostMapping(value="ajax.adminSessionConstant") 
	@ResponseBody 
	public String adminSessionConstant() throws Exception {
		return SessionConstant.ADMIN_KEY;
	}

	@PostMapping(value="ajax.userSessionConstant") 
	@ResponseBody 
	public String userSessionConstant() throws Exception {
		return SessionConstant.USER_KEY;
	}
	
}