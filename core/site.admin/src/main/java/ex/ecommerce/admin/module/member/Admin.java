package ex.ecommerce.admin.module.member;

import java.io.Serializable;

@SuppressWarnings("serial") 
public class Admin implements Serializable {

	private String id;
	private String pwd;
	private int level;
	private String clientIp;
	private String loginDate;
	private String regAdmin;
	private String regDate;
	private String regMsg;
	private String updateAdmin;
	private String updateDate;
	private String updateMsg;
	private boolean state;
	
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

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}

	public String getRegAdmin() {
		return regAdmin;
	}

	public void setRegAdmin(String regAdmin) {
		this.regAdmin = regAdmin;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getRegMsg() {
		return regMsg;
	}

	public void setRegMsg(String regMsg) {
		this.regMsg = regMsg;
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

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String toSting(){
		
		final StringBuilder sb = new StringBuilder();
		
		sb.append("\n");
		sb.append(this.getClass().getName()).append("\n");
		sb.append("아이디      [ " + id + " ] \n");
		sb.append("비밀번호    [ " + pwd + " ] \n");
		sb.append("등급        [ " + level + " ] \n");
		sb.append("아이피      [ " + clientIp + " ] \n");
		sb.append("로그인 날짜 [ " + loginDate + " ] \n");
		sb.append("등록자      [ " + regAdmin + " ] \n");
		sb.append("등록일      [ " + regDate + " ] \n");
		sb.append("등록 이유   [ " + regMsg + " ] \n");
		sb.append("수정자      [ " + updateAdmin + " ] \n");
		sb.append("수정일      [ " + updateDate + " ] \n");
		sb.append("수정 이유   [ " + updateMsg + " ] \n");
		sb.append("사용 여부   [ " + state + " ] \n");
		
		return sb.toString();
	}
	
}