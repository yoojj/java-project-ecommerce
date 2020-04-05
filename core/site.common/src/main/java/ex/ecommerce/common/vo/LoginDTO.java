package ex.ecommerce.common.vo;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class LoginDTO {
	
	private String adminId;
	private String adminPwd;
	private String userId;
	private String userPwd;
	
	public String getAdminId() {
		return adminId;
	}

	public String getAdminPwd() {
		return adminPwd;
	}
	
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = BCrypt.withDefaults().hashToString(12, adminPwd.toCharArray());
	}
	
	public String getUserId() {
		return userId;
	}

	public String getUserPwd() {
		return userPwd;
	}
	
	public void setUserPwd(String userPwd) {
		this.userPwd = BCrypt.withDefaults().hashToString(12, userPwd.toCharArray());
	}
	
}