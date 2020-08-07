package ex.ecommerce.site.module.user;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import ex.ecommerce.common.constant.ValidConstant;

@SuppressWarnings("serial") 
public class UserLoginDTO implements Serializable {

	@Size(min=ValidConstant.ID_MIN_NUM, message="아이디는 " + ValidConstant.ID_MIN_NUM + "글자 이상입니다.")
	@Pattern(regexp=ValidConstant.REG_ENG_NUM, message="아이디는 영문 및 숫자만 입력 가능합니다.")
	private String id;
	
	@Size(min=ValidConstant.PWD_MIN_NUM, message="비밀번호는 " + ValidConstant.PWD_MIN_NUM + "글자 이상입니다.")
	private String pwd;
	
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

	public String toSting(){
		
		final StringBuilder sb = new StringBuilder();
		
		sb.append("\n");
		sb.append(this.getClass().getName()).append("\n");
		sb.append("아이디    [ " + id + " ] \n");
		sb.append("비밀번호  [ " + pwd + " ] \n");
		
		return sb.toString();
	}
	
}