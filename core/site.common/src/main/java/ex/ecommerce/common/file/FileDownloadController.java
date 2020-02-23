package ex.ecommerce.common.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileDownloadController {

	@GetMapping(value = {"board/fileDownload", "admin/board/fileDownload"})
	public ModelAndView fileDownloadBean(String saveFileName, String fileName, String directory) 
			throws Exception {
		return new ModelAndView("fileDownloadBean");
	}

}
