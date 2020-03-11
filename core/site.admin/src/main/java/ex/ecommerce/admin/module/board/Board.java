package ex.ecommerce.admin.module.board;


import java.io.Serializable;

@SuppressWarnings("serial")
public class Board implements Serializable {

	private int bno;
	private int kind;
	private int priority;
	private String title;
	private String content;
	private int hit;
	private String writeUser;
	private String writeAdmin;
	private String writeDate;
	private String updateAdmin;
	private String updateDate;
	private String updateMsg;
	private boolean status;
	
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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
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
		sb.append("번호           [ " + bno + " ] \n");
		sb.append("종류           [ " + kind + " ] \n");
		sb.append("우선순위       [ " + priority + " ] \n");
		sb.append("제목           [ " + title + " ] \n");
		sb.append("내용           [ " + content + " ] \n");
		sb.append("조회수         [ " + hit + " ] \n");
		sb.append("등록자(회원)   [ " + writeUser + " ] \n");
		sb.append("등록자(관리자) [ " + writeAdmin + " ] \n");
		sb.append("등록일         [ " + writeDate + " ] \n");
		sb.append("수정자         [ " + updateAdmin + " ] \n");
		sb.append("수정일         [ " + updateDate + " ] \n");
		sb.append("수정 이유      [ " + updateMsg + " ] \n");
		sb.append("삭제 여부      [ " + status + " ] \n");
		
		return sb.toString();

	}
	
}