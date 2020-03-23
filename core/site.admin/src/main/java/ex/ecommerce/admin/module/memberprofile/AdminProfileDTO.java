package ex.ecommerce.admin.module.memberprofile;

public class AdminProfileDTO {
	
	private String id;
	private String pwd;
	private String email;
	private int level;
	
	public String toSting(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n");
		sb.append(this.getClass().getName()).append("\n");
		sb.append("아이디      [ " + id + " ] \n");
		sb.append("비밀번호    [ " + pwd + " ] \n");
		sb.append("이메일      [ " + email + " ] \n");
		sb.append("등급        [ " + level + " ] \n");
		
		return sb.toString();
	}
	
}