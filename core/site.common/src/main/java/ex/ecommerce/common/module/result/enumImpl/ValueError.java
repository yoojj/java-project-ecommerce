package ex.ecommerce.common.module.result.enumImpl;

public enum ValueError {

	VALUE_NULL       (1000, "값이 없습니다.")
	,VALUE_EMPTY     (1001, "값이 비었습니다.")
	,VALUE_EXIST     (1002, "값이 존재합니다.")
	,VALUE_NOT_MATCH (1003, "값이 일치하지 않습니다.");
	
	private final int code;
	private final String description;
	
	private ValueError(int code, String description) {
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