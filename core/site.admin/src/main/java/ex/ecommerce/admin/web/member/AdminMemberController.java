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

import at.favre.lib.crypto.bcrypt.BCrypt;
import ex.ecommerce.admin.annotation.AdminLevelCheck;
import ex.ecommerce.admin.module.member.AdminRegDTO;
import ex.ecommerce.admin.module.member.AdminSessionDTO;
import ex.ecommerce.admin.module.member.AdminUpdateDTO;
import ex.ecommerce.admin.module.member.impl.AdminMemberServiceImpl;
import ex.ecommerce.common.constant.AdminLevelEnum;
import ex.ecommerce.common.constant.SessionConstant;
import ex.ecommerce.common.module.result.Result;
import ex.ecommerce.common.vo.Paging;

@Controller 
@SessionAttributes(SessionConstant.ADMIN_KEY)
@AdminLevelCheck(level=AdminLevelEnum.LEVEL_1) 
public class AdminMemberController {

	private AdminMemberServiceImpl memberService;

	public AdminMemberController(AdminMemberServiceImpl memberService) {
		this.memberService = memberService;
	}
	


	@GetMapping(value={"member", "member/", "member/list"})
	public String adminMemberListPage(final Model model, final Paging paging) throws Exception {
		
		model.addAttribute("result", memberService.selectList(paging));
		model.addAttribute("memberOn", true);
		
		return "admin/member/list";
	}
	
	@PostMapping(value="member/ajax.adminIdCheckReg")
	@ResponseBody
	public Result adminIdCheckRegAjax(@RequestBody final Map<String, Object> data) throws Exception {
		
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
			result.setResult(error);
			
		} else {
			
			// 임시 -- PwdEncryptionFilter 사용시 비번 체크 문제
			final String pwd = BCrypt.withDefaults().hashToString(12, regDTO.getPwd().toCharArray());
			
			regDTO.setPwd(pwd);
			regDTO.setRegAdmin(sessionDTO.getId());
			
			result = memberService.insert(regDTO);
			
		}
		
		return result;
	}

	@PostMapping(value="member/ajax.adminPwdReset")
	@ResponseBody
	public Result adminPwdResetAjax(@RequestBody final Map<String, Object> data) throws Exception {
		
		final String pwdResetAdminId = (String) data.get("pwdResetAdminId");
		
		final Result result = memberService.updatePwd(pwdResetAdminId);
		
		return result;
	}
	
	@PostMapping(value="member/ajax.adminUpdate")
	@ResponseBody
	public Result adminUpdateAjax(@RequestBody final AdminUpdateDTO updateDTO, 
			@ModelAttribute(SessionConstant.ADMIN_KEY) final AdminSessionDTO sessionDTO) throws Exception {
	
		final Result result = memberService.update(updateDTO);

		return result;
	}

	@PostMapping(value="member/ajax.adminDelete")
	@ResponseBody
	public Result adminDeleteAjax(@RequestBody final Map<String, Object> data, 
			@ModelAttribute(SessionConstant.ADMIN_KEY) final AdminSessionDTO sessionDTO) throws Exception {
		
		final String id = sessionDTO.getId();
		final String pwd = (String) data.get("pwd");
		final String deleteAdminId = (String) data.get("deleteAdminId");

		final Result result = memberService.delete(id, pwd, deleteAdminId);

		return result;
	}
	
}