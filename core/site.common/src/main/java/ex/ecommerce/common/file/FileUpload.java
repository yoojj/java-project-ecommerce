package ex.ecommerce.common.file;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import ex.ecommerce.common.util.DateUtil;
import ex.ecommerce.common.util.SessionScopeUtil;

@Component
public class FileUpload {

	@Value("${path.resources.upload:@null}")
	private static String FILE_PATH;
	
	@Value("${path.resources.upload}")
	public void setPath(String path) {
		FILE_PATH = path;
	}
	
	private String filePath;
	private String fileSize;
	
	private FileUpload() {};
	
	public static FileUpload getInstance() {
		return _FileUpload.instance;
	}
	
	private static class _FileUpload {
		public static FileUpload instance = new FileUpload();
	}
	
	public String getFilePath() {
		return filePath;
	}

	public String getFileSize() {
		return fileSize;
	}
	
	public String saveFileName(MultipartFile fileUpload, String ...folder) throws IOException {
		
		this.fileSize = Long.toString( fileUpload.getSize() );
		
		String newFileName = this.newFileName( fileUpload.getOriginalFilename() );

		// 경로 수정시 
		// this.filePath = realPath()
		
		// admin, home, temp
		if( folder.length > 0 ) {
			this.filePath = FILE_PATH + File.separator + folder[0] + File.separator + DateUtil.getDate() + File.separator;
		
		} else {
			this.filePath = FILE_PATH + File.separator + "temp" + File.separator + DateUtil.getDate() + File.separator;
		}

		File file = new File(this.filePath, newFileName);
		if(file.exists() == false) file.mkdirs();
		
		fileUpload.transferTo(file);
		
		return newFileName;
	}
	
	private String newFileName(String fileName) {
		
		String uuid = UUID.randomUUID().toString().replace("-", "");
		
		return uuid  + "_" + fileName;
	}
	
	@SuppressWarnings("unused")
	private String realPath() throws IOException {
		
		ServletContext context = SessionScopeUtil.getRequest().getServletContext();
		
		return context.getRealPath("/");
	}
	
}