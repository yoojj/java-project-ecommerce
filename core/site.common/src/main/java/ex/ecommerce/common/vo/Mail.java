package ex.ecommerce.common.vo;

import java.io.Serializable;

import javax.activation.FileDataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import ex.ecommerce.common.util.DateUtil;

@SuppressWarnings("serial")
public class Mail implements Serializable, InitializingBean {

	@Autowired
	private Environment env;

	/** 발신 메일 */
	public String fromMail;
	
	/** 수신 메일 */
	private String toMail;
	
	/** 그룹 수신 메일 */
	private String[] groupMail;
	
	/** 숨은 그룹 수신 */ 
	private String[] groupMailHide;
	
	/** 메일 제목 */
	private String mailSubject;
	
	/** 메일 내용 */
	private String mailContent;
	
	/** 메일 내용 html */
	private String mailHTMLContent;
	
	/** 메일 첨부 파일 */
	private FileDataSource mailFile;
	
	/** 메일 첨부 파일 명 */
	private String mailFileName;
	
	/** 메일 첨부 파일 설명 */
	private String mailFileDescription;
	
	/** 메일 작성일 */
	private String mailWriteDate;
	
	/** 메일 수신 확인 */
	private String mailReadDate;
	
	public String getFromMail() {
		return fromMail;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.fromMail = env.getProperty("mail.username");
	}
	
	public String getToMail() {
		return toMail;
	}
	
	public void setToMail(String toMail) {
		this.toMail = toMail;
	}
	
	public String[] getGroupMail() {
		return groupMail;
	}
	
	public void setGroupMail(String[] groupMail) {
		this.groupMail = groupMail;
	}
	
	public String[] getGroupMailHide() {
		return groupMailHide;
	}
	
	public void setGroupMailHide(String[] groupMailHide) {
		this.groupMailHide = groupMailHide;
	}
	
	public String getMailSubject() {
		return mailSubject;
	}
	
	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}
	
	public String getMailContent() {
		return mailContent;
	}
	
	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}
	
	public String getMailHTMLContent() {
		return mailHTMLContent;
	}

	public void setMailHTMLContent(String mailHTMLContent) {
		this.mailHTMLContent = mailHTMLContent;
	}
	
	public FileDataSource getMailFile() {
		return mailFile;
	}
	
	public void setMailFile(FileDataSource mailFile) {
		this.mailFile = mailFile;
	}
	
	public String getMailFileName() {
		return mailFileName;
	}
	
	public void setMailFileName(String mailFileName) {
		this.mailFileName = mailFileName;
	}
	
	public String getMailFileDescription() {
		return mailFileDescription;
	}
	
	public void setMailFileDescription(String mailFileDescription) {
		this.mailFileDescription = mailFileDescription;
	}
	
	public String getMailWriteDate() {
		return mailWriteDate;
	}
	
	public void setMailWriteDate(String mailWriteDate) {
		this.mailWriteDate = DateUtil.getDateTime();
	}
	
	public String getMailReadDate() {
		return mailReadDate;
	}
	
	public void setMailReadDate(String mailReadDate) {
		this.mailReadDate = mailReadDate;
	}

	public String toSting(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n");
		sb.append(this.getClass().getName()).append("\n");
		sb.append("보내는 메일  [ " + fromMail + " ] \n");
		sb.append("받는 메일    [ " + toMail + " ] \n");
		sb.append("메일 제목    [ " + mailSubject + " ] \n");
		sb.append("메일 내용    [ " + mailContent + " ] \n");
		
		return sb.toString();
	}

}