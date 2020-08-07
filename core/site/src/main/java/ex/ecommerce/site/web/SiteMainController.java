package ex.ecommerce.site.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteMainController {

	@GetMapping(value={"/", "index", "main"})
	public String siteMainPage() throws Exception {
		return "main";
	}
	
}