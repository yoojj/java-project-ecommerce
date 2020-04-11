package ex.ecommerce.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import ex.ecommerce.admin.module.member.AdminSessionDTO;
import ex.ecommerce.admin.module.member.impl.AdminMemberServiceImpl;
import ex.ecommerce.admin.module.member.impl.AdminProfileServiceImpl;
import ex.ecommerce.common.constant.SessionConstant;

@Controller 
@SessionAttributes(SessionConstant.ADMIN_KEY)
public class AdminProfileController {
	
	private AdminProfileServiceImpl profileService;

	public AdminProfileController(AdminProfileServiceImpl profileService) {
		this.profileService = profileService;
	}
	
	
	
	@GetMapping(value="profile")
	public String adminProfilePage(@ModelAttribute(SessionConstant.ADMIN_KEY) final AdminSessionDTO sessionDTO, 
			Model model) throws Exception {
	
		model.addAttribute("profileOn", true);
		
		return "admin/profile";
	}
	
}