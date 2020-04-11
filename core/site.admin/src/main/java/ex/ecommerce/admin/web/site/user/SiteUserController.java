package ex.ecommerce.admin.web.site.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ex.ecommerce.common.constant.SessionConstant;

@Controller 
@SessionAttributes(SessionConstant.ADMIN_KEY)
public class SiteUserController {
	
	private SiteUserServiceImpl userService;

	public SiteUserController(SiteUserServiceImpl siteUserService) {
		this.siteUserService = siteUserService;
	}
	
	
	
	@GetMapping(value={"admin/site/user", "admin/site/user/list"})
	public String siteUserPage(Model model) throws Exception {
		
		model.addAttribute("result", userService.selectList());
		model.addAttribute("siteUserOn", true);
		
		return "admin/site/user/list";
	}
	
}