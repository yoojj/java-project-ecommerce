package ex.ecommerce.admin.module.board;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import ex.ecommerce.common.constant.ValidConstant;

@SuppressWarnings("serial") 
public class AdminBoardWriteDTO implements Serializable {

	private int bno;
	private int kind;
	private int priority;

	@Size(min=ValidConstant.TITLE_MIN_NUM, message="제목을 입력하세요.")
	private String title;
	
	@Size(min=ValidConstant.CONTENT_MIN_NUM, message="내용을 입력하세요.")
	private String content;
	
	private MultipartFile fileUpload;
	private String writeAdmin;
	private String writeDate;
	private Boolean status;
	
	public int getBno() {
		return bno;
	}
	
	public void setBno(int bno) {
		this.bno = bno;
	}
	
	public int getKind() {
		return kind;
	}
	
	public void setKind(int kind) {
		this.kind = kind;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public MultipartFile getFileUpload() {
		return fileUpload;
	}
	
	public void setFileUpload(MultipartFile fileUpload) {
		this.fileUpload = fileUpload;
	}
	
	public String getWriteAdmin() {
		return writeAdmin;
	}
	
	public void setWriteAdmin(String writeAdmin) {
		this.writeAdmin = writeAdmin;
	}
	
	public String getWriteDate() {
		return writeDate;
	}
	
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String toSting(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n");
		sb.append(this.getClass().getName()).append("\n");
		sb.append("종류      [ " + kind + " ] \n");
		sb.append("우선순위  [ " + priority + " ] \n");
		sb.append("제목      [ " + title + " ] \n");
		sb.append("내용      [ " + content + " ] \n");
		sb.append("첨부파일  [ " + fileUpload.getOriginalFilename() + " ] \n");
		sb.append("등록자    [ " + writeAdmin + " ] \n");
		sb.append("등록일    [ " + writeDate + " ] \n");
		sb.append("글 상태   [ " + status + " ] \n");
		
		return sb.toString();
	}
	
}