package ex.ecommerce.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ex.ecommerce.common.constant.SessionConstant;

@Controller
@SessionAttributes(SessionConstant.ADMIN_KEY)
public class AdminMainController {
	
	@GetMapping(value={"/", "index", "main"})
	public String adminMainPage() throws Exception {
		
		return "main";
	}

}