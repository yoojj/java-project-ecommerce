package ex.ecommerce.admin.web.adminboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ex.ecommerce.common.constant.SessionConstant;

@Controller
@SessionAttributes(SessionConstant.ADMIN_KEY)
public class AdminBoardController {

	@GetMapping(value={"board/", "board/list"})
	public String adminBoardPage(Model model) throws Exception {
		
		model.addAttribute("boardOn", true);
		
		return "admin/board/list";
	}
	
}