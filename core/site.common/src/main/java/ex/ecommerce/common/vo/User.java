package ex.ecommerce.common.vo;

import java.io.Serializable;

@SuppressWarnings("serial") 
public class User implements Serializable {

	private String id;
	private String pwd;
	private int level;
	private String clientIp;
	private String loginDate;
	private String joinDate;
	private String updateAdmin;
	private String updateDate;
	private String updateMsg;
	private String deleteDate;
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

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
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

	public String getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String toSting(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n");
		sb.append(this.getClass().getName()).append("\n");
		sb.append("유저 아이디 [ " + id + " ] \n");
		sb.append("비밀번호    [ " + pwd + " ] \n");
		sb.append("등급        [ " + level + " ] \n");
		sb.append("아이피      [ " + clientIp + " ] \n");
		sb.append("로그인 날짜 [ " + loginDate + " ] \n");
		sb.append("가입 날짜   [ " + joinDate + " ] \n");
		sb.append("수정자      [ " + updateAdmin + " ] \n");
		sb.append("수정일      [ " + updateDate + " ] \n");
		sb.append("수정 이유   [ " + updateMsg + " ] \n");
		sb.append("탈퇴 날짜   [ " + deleteDate + " ] \n");
		sb.append("상태        [ " + state + " ] \n");
		
		return sb.toString();
	}
	
}