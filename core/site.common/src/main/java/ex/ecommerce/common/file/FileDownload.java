package ex.ecommerce.common.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component
public class FileDownload extends AbstractView {

	public FileDownload() {
		setContentType("application/download; utf-8");
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		final String saveFileName = (String) request.getParameter("saveFileName");
		final String fileName = (String) request.getParameter("fileName");
		final String directory = (String) request.getParameter("directory");
				
		final File file = new File( directory, saveFileName );
		
		response.setContentType(this.getContentType());
		response.setContentLength((int)file.length());
		response.setHeader("Content-Disposition", "attachment; fileName=" 
				+ new String(fileName.getBytes("UTF-8"),"8859_1"));
		response.setHeader("Content-Transfer-encoding", "binary");

		BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
		ServletOutputStream out = response.getOutputStream();   
		 
		FileCopyUtils.copy(in, out);
		
		if( in != null ) in.close();
		
		out.flush();
		
	}
}
