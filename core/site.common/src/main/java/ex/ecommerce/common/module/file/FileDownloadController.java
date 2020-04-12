package ex.ecommerce.common.module.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileDownloadController {

	@GetMapping(value="board/fileDownload")
	public ModelAndView fileDownloadBean(String fileName, String saveFileName, String directory) 
			throws Exception {
		return new ModelAndView("fileDownloadBean");
	}

}