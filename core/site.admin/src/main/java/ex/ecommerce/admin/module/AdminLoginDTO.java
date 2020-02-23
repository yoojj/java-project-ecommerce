package ex.ecommerce.admin.module;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import ex.ecommerce.common.constant.ValidConstant;

@SuppressWarnings("serial") 
public class AdminLoginDTO implements Serializable {
	
	@Size(min=ValidConstant.ID_MIN_NUM, message="아이디는 " + ValidConstant.ID_MIN_NUM + "글자 이상입니다.")
	@Pattern(regexp=ValidConstant.REG_ENG_NUM, message="아이디는 영문 및 숫자만 입력 가능합니다.")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message="아이디는 영문 및 숫자만 입력 가능합니다.")
	private String adminId;
	
	@Size(min=ValidConstant.PWD_MIN_NUM, message="비밀번호는 " + ValidConstant.PWD_MIN_NUM + "글자 이상입니다.")
	private String adminPwd;

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public String toSting(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n");
		sb.append(this.getClass().getName()).append("\n");
		sb.append("아이디    [ " + adminId + " ] \n");
		sb.append("비밀번호  [ " + adminPwd + " ] \n");
		
		return sb.toString();
	}
	
}