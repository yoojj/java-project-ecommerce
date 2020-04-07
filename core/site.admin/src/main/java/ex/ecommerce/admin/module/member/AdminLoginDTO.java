package ex.ecommerce.admin.module.member;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import ex.ecommerce.common.constant.ValidConstant;

@SuppressWarnings("serial") 
public class AdminLoginDTO implements Serializable {
	
	@Size(min=ValidConstant.ID_MIN_NUM, message="아이디는 " + ValidConstant.ID_MIN_NUM + "글자 이상입니다.")
	@Pattern(regexp=ValidConstant.REG_ENG_NUM, message="아이디는 영문 및 숫자만 입력 가능합니다.")
	private String id;
	
	@Size(min=ValidConstant.PWD_MIN_NUM, message="비밀번호는 " + ValidConstant.PWD_MIN_NUM + "글자 이상입니다.")
	private String pwd;

	private String clientIp;
	
	//private String sessionId;
	
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

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	
	public String toSting(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n");
		sb.append(this.getClass().getName()).append("\n");
		sb.append("아이디    [ " + id + " ] \n");
		sb.append("비밀번호  [ " + pwd + " ] \n");
		sb.append("아이피    [ " + clientIp + " ] \n");
		
		return sb.toString();
	}
	
}