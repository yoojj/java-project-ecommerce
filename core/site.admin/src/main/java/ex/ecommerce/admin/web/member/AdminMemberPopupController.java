package ex.ecommerce.admin.web.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import ex.ecommerce.admin.module.member.impl.AdminServiceImpl;
import ex.ecommerce.common.constant.SessionConstant;
import ex.ecommerce.common.module.result.Result;

@Controller 
@SessionAttributes(SessionConstant.ADMIN_KEY)
public class AdminMemberPopupController {
	
	private AdminServiceImpl adminService;

	public AdminMemberPopupController(AdminServiceImpl adminService) {
		this.adminService = adminService;
	}
	
	
	
	@GetMapping(value="member/popup/{id}")
	public String adminMemberInfoPopup(@PathVariable final String id, Model model) throws Exception {

		final Result result = adminService.select(id);

		model.addAttribute("result", result);
		
		return "admin/member/popup";
	}
	
	@ResponseBody
	public Result adminUpdatePopupAjax() throws Exception {
		return null;
	}
	
}