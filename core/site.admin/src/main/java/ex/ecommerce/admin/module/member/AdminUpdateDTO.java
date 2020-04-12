package ex.ecommerce.admin.module.member;

import java.io.Serializable;

@SuppressWarnings("serial") 
public class AdminUpdateDTO implements Serializable {

	private String id;
	private String pwd;
	private int level;
	private boolean state;
	private String updateAdmin;
	private String updateDate;
	private String updateMsg;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
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

	public String toSting(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n");
		sb.append(this.getClass().getName()).append("\n");
		sb.append("아이디    [ " + id + " ] \n");
		sb.append("비밀번호  [ " + pwd + " ] \n");
		sb.append("등급      [ " + level + " ] \n");
		sb.append("사용 여부 [ " + state + " ] \n");
		sb.append("수정자    [ " + updateAdmin + " ] \n");
		sb.append("수정일    [ " + updateDate + " ] \n");
		sb.append("수정 이유 [ " + updateMsg + " ] \n");
		
		return sb.toString();
	}
	
}