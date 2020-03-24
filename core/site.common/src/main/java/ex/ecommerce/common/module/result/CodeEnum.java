package ex.ecommerce.common.module.result;

public enum CodeEnum implements ICodeEnum {

	SUCCESS(0, "SUCCESS")
	,ERROR (1, "ERROR");
	
	private final int code;
	private final String description;
	
	private CodeEnum(int code, String description) {
		this.code = code;
		this.description = description;
	}

	@Override
	public int getCode() {
		return code;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
}