package ex.ecommerce.admin.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ex.ecommerce.admin.module.member.AdminLoginDTO;
import ex.ecommerce.admin.module.member.impl.AdminLoginServiceImpl;
import ex.ecommerce.common.constant.SessionConstant;
import ex.ecommerce.common.module.result.CodeEnum;
import ex.ecommerce.common.module.result.Result;

@SessionAttributes(SessionConstant.ADMIN_KEY)
@Controller 
public class AdminLoginController {
	
	private AdminLoginServiceImpl loginService;

	public AdminLoginController(AdminLoginServiceImpl loginService) {
		this.loginService = loginService;
	}
	
	
	
	@GetMapping(value="login")
	public String adminLoginPage() throws Exception {
		return "login";
	}
	
	@PostMapping(value="ajax.adminLogin")
	@ResponseBody
	public Result adminLoginAjax(@Valid @RequestBody final AdminLoginDTO loginDTO, Errors valid, 
			@RequestAttribute("ip") String ip, Model model) throws Exception {
	
		Result result = null;

		if(valid.hasErrors()) { 

			final List<FieldError> errors = valid.getFieldErrors();
			
			final Map<String, Object> error = new HashMap<>();

			for (FieldError e : errors)
				error.put(e.getField(), e.getDefaultMessage());
						
			result = new Result();
			result.setCode(CodeEnum.ERROR.getCode());
			result.setResult(error);
			
		} else {
			
			loginDTO.setClientIp(ip);
			
			result = loginService.select(loginDTO);
			
			if(result.getCode() == CodeEnum.SUCCESS.getCode()) {
				model.addAttribute(SessionConstant.ADMIN_KEY, result.getResult());
			}

		}

		return result;
	}

	@GetMapping(value="logout")
	public String adminLogout(SessionStatus sessionStatus) throws Exception {
		
		sessionStatus.setComplete();
		
		return "redirect:login";
	}
	
}