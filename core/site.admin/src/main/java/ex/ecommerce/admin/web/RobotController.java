package ex.ecommerce.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RobotController {

	@RequestMapping(value = "/robots.txt")
	@ResponseBody
	public String robot() {
		return "User-agent: * \n Disallow: /admin/";
	}
	
}