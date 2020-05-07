package ex.ecommerce.admin.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import ex.ecommerce.admin.module.member.AdminSessionDTO;
import ex.ecommerce.admin.module.member.impl.AdminServiceImpl;
import ex.ecommerce.common.constant.SessionConstant;
import ex.ecommerce.common.module.result.Result;

@Controller 
@SessionAttributes(SessionConstant.ADMIN_KEY)
public class AdminController {

	private AdminServiceImpl adminService;

	public AdminController(AdminServiceImpl adminService) {
		this.adminService = adminService;
	}
	
	
	
	@PostMapping(value="member/ajax.adminPwdCheck")
	@ResponseBody
	public Result adminPwdCheckAjax(@RequestBody Map<String, Object> data, 
			@ModelAttribute(SessionConstant.ADMIN_KEY) final AdminSessionDTO sessionDTO) throws Exception {

		final String id = sessionDTO.getId();
		final String pwd = (String) data.get("pwd");

		final Result result = adminService.selectPwd(id, pwd);

		return result;
	}
	
}