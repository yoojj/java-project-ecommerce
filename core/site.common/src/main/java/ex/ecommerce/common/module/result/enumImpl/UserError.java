package ex.ecommerce.common.module.result.enumImpl;

public enum UserError {

	ID_NULL          (21000, "아이디가 존재하지 않습니다.")
	,ID_EMPTY        (21001, "아이디가 비었습니다.")
	,ID_EXIST        (21002, "아이디가 존재합니다.")
	
	,PWD_EMPTY       (21003, "비밀번호가 비었습니다.")
	,PWD_NOT_MATCH   (21004, "비밀번호가 일치하지 않습니다.")

	,EMAIL_EMPTY     (21005, "이메일이 비었습니다.")
	,EMAIL_NOT_EXIST (21006, "이메일이 존재하지 않습니다.")
	,EMAIL_EXIST     (21007, "이메일이 존재합니다.");
	
	private final int code;
	private final String description;
	
	private UserError(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
}