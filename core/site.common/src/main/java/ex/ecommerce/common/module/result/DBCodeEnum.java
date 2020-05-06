package ex.ecommerce.common.module.result;

public enum DBCodeEnum {

	ERROR (0),
	SUCCESS (1);
	
	private final int code;
	
	private DBCodeEnum(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

}