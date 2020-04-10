package ex.ecommerce.admin.web.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import ex.ecommerce.admin.module.member.AdminRegDTO;
import ex.ecommerce.admin.module.member.AdminSessionDTO;
import ex.ecommerce.admin.module.member.impl.AdminMemberServiceImpl;
import ex.ecommerce.common.constant.SessionConstant;
import ex.ecommerce.common.module.result.CodeEnum;
import ex.ecommerce.common.module.result.Result;

@Controller 
@SessionAttributes(SessionConstant.ADMIN_KEY)
public class AdminMemberController {
	
	private AdminMemberServiceImpl memberService;

	public AdminMemberController(AdminMemberServiceImpl memberService) {
		this.memberService = memberService;
	}
	
	
	
	@GetMapping(value={"member/", "member/list"})
	public String adminMemberListPage(Model model) throws Exception {
		
		model.addAttribute("result", memberService.selectList());
		model.addAttribute("memberOn", true);
		
		return "admin/member/list";
	}
	
	@PostMapping(value="member/ajax.adminRegIdCheck")
	@ResponseBody
	public Result adminRegIdCheckAjax(@RequestBody Map<String, Object> data) throws Exception {
		
		final String id = (String) data.get("id");

		final Result result = memberService.selectId(StringUtils.trimWhitespace(id));
		
		return result;
	}
	
	@PostMapping(value="member/ajax.adminReg")
	@ResponseBody
	public Result adminRegAjax(@Valid @RequestBody final AdminRegDTO regDTO, Errors valid,
			@ModelAttribute(SessionConstant.ADMIN_KEY) final AdminSessionDTO sessionDTO) throws Exception {
	
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
			
			regDTO.setRegAdmin(sessionDTO.getId());
			
			result = memberService.insert(regDTO);
			
		}
		

		return result;
	}
	
}