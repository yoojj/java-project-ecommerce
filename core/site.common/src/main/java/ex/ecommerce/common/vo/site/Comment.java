package ex.ecommerce.common.vo.site;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Comment implements Serializable {

	private int cno;
	private int bno;
	private String content;
	private int allStar;
	private int allBlock;
	private String writeUser;
	private String writeAdmin;
	private String writeDate;
	private String updateAdmin;
	private String updateDate;
	private String updateMsg;
	private boolean secret;
	private boolean block;
	private boolean status;
	
	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getAllStar() {
		return allStar;
	}

	public void setAllStar(int allStar) {
		this.allStar = allStar;
	}

	public int getAllBlock() {
		return allBlock;
	}

	public void setAllBlock(int allBlock) {
		this.allBlock = allBlock;
	}

	public String getWriteUser() {
		return writeUser;
	}

	public void setWriteUser(String writeUser) {
		this.writeUser = writeUser;
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

	public String getUpdateAdmin() {
		return updateAdmin;
	}

	public void setUpdateAdmin(String updateAdmin) {
		this.updateAdmin = updateAdmin;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateMsg() {
		return updateMsg;
	}

	public void setUpdateMsg(String updateMsg) {
		this.updateMsg = updateMsg;
	}

	public boolean isSecret() {
		return secret;
	}

	public void setSecret(boolean secret) {
		this.secret = secret;
	}
	
	public boolean isBlock() {
		return block;
	}

	public void setBlock(boolean block) {
		this.block = block;
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
		sb.append("댓글 번호      [ " + cno + " ] \n");
		sb.append("게시물 번호    [ " + bno + " ] \n");
		sb.append("내용           [ " + content + " ] \n");
		sb.append("스타 개수      [ " + allStar + " ] \n");
		sb.append("블락 개수      [ " + allBlock + " ] \n");
		sb.append("등록자(회원)   [ " + writeUser + " ] \n");
		sb.append("등록자(관리자) [ " + writeAdmin + " ] \n");
		sb.append("등록일         [ " + writeDate + " ] \n");
		sb.append("수정자         [ " + updateAdmin + " ] \n");
		sb.append("수정일         [ " + updateDate + " ] \n");
		sb.append("수정 이유      [ " + updateMsg + " ] \n");
		sb.append("비밀 여부      [ " + secret + " ] \n");
		sb.append("블락 여부      [ " + block + " ] \n");
		sb.append("사용 여부      [ " + status + " ] \n");
		
		return sb.toString();
	}
	
}