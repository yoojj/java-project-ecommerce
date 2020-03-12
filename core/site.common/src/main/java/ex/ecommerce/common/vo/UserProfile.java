package ex.ecommerce.common.vo;

import java.io.Serializable;

@SuppressWarnings("serial") 
public class UserProfile implements Serializable {

	private String id;
	private String name;
	private int gender;
	private String birthday;
	private String email;
	private String secondEmail;
	private String imgFileName;
	private String imgSaveName;
	private boolean adAcceptYN;

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getGender() {
		return gender;
	}
	
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSecondEmail() {
		return secondEmail;
	}
	
	public void setSecondEmail(String secondEmail) {
		this.secondEmail = secondEmail;
	}
	
	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public String getImgSaveName() {
		return imgSaveName;
	}

	public void setImgSaveName(String imgSaveName) {
		this.imgSaveName = imgSaveName;
	}
	
	public boolean getAdAcceptYN() {
		return adAcceptYN;
	}
	
	public void setAdAcceptYN(boolean adAcceptYN) {
		this.adAcceptYN = adAcceptYN;
	}
	
	public String toSting(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n");
		sb.append(this.getClass().getName()).append("\n");
		sb.append("아이디        [ " + id + " ] \n");
		sb.append("이름          [ " + name + " ] \n");
		sb.append("성별          [ " + gender + " ] \n");
		sb.append("생년월일      [ " + birthday + " ] \n");
		sb.append("이메일        [ " + email + " ] \n");
		sb.append("두번째 이메일 [ " + secondEmail + " ] \n");
		sb.append("원본 이미지명 [ " + imgFileName + " ] \n");
		sb.append("저장 이미지명 [ " + imgSaveName + " ] \n");
		sb.append("광고 동의     [ " + adAcceptYN + " ] \n");
		
		return sb.toString();
	}
	
}