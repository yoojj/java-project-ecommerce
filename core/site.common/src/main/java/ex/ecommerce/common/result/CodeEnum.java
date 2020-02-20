package ex.ecommerce.common.result;

public enum CodeEnum {

	SUCCESS(0, "SUCCESS")
	,ERROR (1, "ERROR");
	
	private final int code;
	private final String description;
	
	private CodeEnum(int code, String description) {
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