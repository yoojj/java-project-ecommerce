package ex.ecommerce.admin.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import ex.ecommerce.admin.module.AdminLoginDTO;
import ex.ecommerce.admin.module.AdminLoginServiceImpl;
import ex.ecommerce.common.constant.SessionConstant;
import ex.ecommerce.common.result.Result;

@Controller 
@SessionAttributes(SessionConstant.ADMIN_KEY)
public class AdminLoginController {
	
	@Autowired
	private AdminLoginServiceImpl loginService;
	
	@GetMapping(value={"/", "login"})
	public String adminLogin(Model model) throws Exception {
		
		model.addAttribute("adminLoginForm", new AdminLoginDTO());
		
		return "login";
	}
	
	@PostMapping(value="adminLoginSubmit")
	public ModelAndView adminLoginSubmit(@Valid @ModelAttribute("adminLoginForm") AdminLoginDTO loginDTO,
			Errors valid) throws Exception {

		ModelAndView model = new ModelAndView();
		model.setViewName("login");

		if( valid.hasErrors() == false ) {
			Result result = loginService.select(loginDTO);
			model.addObject("result", result);

			if( result.getResult() != null ) {
				model.addObject(SessionConstant.ADMIN_KEY, result.getResult());
				model.setViewName("redirect:main");
			}

		}

		return model;
	}
	
	@GetMapping(value="logout")
	public String adminLogout(SessionStatus sessionStatus) throws Exception {
		
		sessionStatus.setComplete();
		
		return "redirect:login";
	}
	
}
