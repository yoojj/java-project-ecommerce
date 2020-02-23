package ex.ecommerce.admin.module;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import ex.ecommerce.common.constant.ValidConstant;

@SuppressWarnings("serial") 
public class AdminRegDTO implements Serializable {

	@Size(min=ValidConstant.ID_MIN_NUM, message="아이디는 " + ValidConstant.ID_MIN_NUM + "글자 이상입니다.")
	@Pattern(regexp=ValidConstant.REG_ENG_NUM, message="아이디는 영문 및 숫자만 입력 가능합니다.")
	private String id;
	
	@Size(min=ValidConstant.PWD_MIN_NUM, message="비밀번호는 " + ValidConstant.PWD_MIN_NUM + "글자 이상입니다.")
	private String pwd;
	
	private String level;
	private boolean state;
	private String regAdmin;
	private String regDate;
	private String regMsg;

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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
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

	public String toSting(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n");
		sb.append(this.getClass().getName()).append("\n");
		sb.append("아이디     [ " + id + " ] \n");
		sb.append("비밀번호   [ " + pwd + " ] \n");
		sb.append("등급       [ " + level + " ] \n");
		sb.append("사용 여부  [ " + state + " ] \n");
		sb.append("등록자     [ " + regAdmin + " ] \n");
		sb.append("등록일     [ " + regDate + " ] \n");
		sb.append("등록 이유  [ " + regMsg + " ] \n");
		
		return sb.toString();
	}
	
}