package ex.ecommerce.admin.module;

import java.io.Serializable;

@SuppressWarnings("serial") 
public class AdminSessionDTO implements Serializable {

	private String id;
	private int level;
	private String clientIp;
	private String sessionId;
	private boolean state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
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
		sb.append("아이디      [ " + id + " ] \n");
		sb.append("등급        [ " + level + " ] \n");
		sb.append("아이피      [ " + clientIp + " ] \n");
		sb.append("세션 아이디 [ " + sessionId + " ] \n");
		sb.append("사용 여부   [ " + state + " ] \n");
		return sb.toString();
	}
	
}