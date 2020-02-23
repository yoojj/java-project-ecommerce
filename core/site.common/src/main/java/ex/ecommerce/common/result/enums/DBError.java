package ex.ecommerce.common.result.enums;

public enum DBError {
	
	CONNECT_ERROR (2000, "connect error")
	
	,INSERT_ERROR (2005, "insert error")
	,SELECT_ERROR (2006, "select error")
	,UPDATE_ERROR (2007, "update error")
	,DELETE_ERROR (2008, "delete error");

	private final int code;
	private final String description;
	
	private DBError(int code, String description) {
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