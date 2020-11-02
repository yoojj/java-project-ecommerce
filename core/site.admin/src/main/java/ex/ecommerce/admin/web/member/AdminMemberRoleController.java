package ex.ecommerce.admin.web.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import ex.ecommerce.admin.module.member.impl.AdminMemberRoleServiceImpl;
import ex.ecommerce.common.constant.SessionConstant;
import ex.ecommerce.common.module.result.Result;

@Controller 
@SessionAttributes(SessionConstant.ADMIN_KEY)
public class AdminMemberRoleController {

	private AdminMemberRoleServiceImpl memberRoleService;

	public AdminMemberRoleController(AdminMemberRoleServiceImpl memberRoleService) {
		this.memberRoleService = memberRoleService;
	}
	
	
	
	@GetMapping(value="member/role")
	public String adminRolePage(Model model) throws Exception {
		
		model.addAttribute("result", memberRoleService.selectList());
		model.addAttribute("memberRoleOn", true);
		
		return "admin/member/role";
	}
	
	@PostMapping(value="member/ajax.adminRoleReg")
	@ResponseBody
	public Result adminRoleRegAjax() throws Exception {
		
		final Result result = memberRoleService.insert(null);
		
		return result;
	}
	
	@PostMapping(value="member/ajax.adminRoleModify")
	@ResponseBody
	public Result adminRoleModifyAjax() throws Exception {
		
		final Result result = memberRoleService.update();
		
		return result;
	}
	
	@PostMapping(value="member/ajax.adminRoleDelete")
	@ResponseBody
	public Result adminRoleDeleteAjax() throws Exception {
		
		final Result result = memberRoleService.delete();
		
		return result;
	}
	
}