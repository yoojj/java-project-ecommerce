package ex.ecommerce.common.module.result.enumImpl;

public enum PatternError {

	PATTREN_ONLY_KOR      (3000, "한글만 입력 가능합니다.")
	,PATTREN_ONLY_NUM     (3001, "숫자만 입력 가능합니다.")
	,PATTREN_ONLY_ENG     (3002, "영문만 입력 가능합니다.")
	,PATTREN_ONLY_ENG_NUM (3003, "영문 및 숫자만 입력 가능합니다.");
	
	private final int code;
	private final String description;
	
	private PatternError(int code, String description) {
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