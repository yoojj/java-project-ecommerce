package ex.ecommerce.common.module.result.enumImpl;

import ex.ecommerce.common.module.result.ICodeEnum;

public enum AdminError implements ICodeEnum {

	ID_NULL        (11000, "아이디가 존재하지 않습니다.")
	,ID_EMPTY      (11001, "아이디가 비었습니다.")
	,ID_EXIST      (11002, "아이디가 존재합니다.")
	
	,PWD_NULL      (11003, "비밀번호가 비었습니다.")
	,PWD_NOT_MATCH (11004, "비밀번호가 일치하지 않습니다.");

	private final int code;
	private final String description;
	
	private AdminError(int code, String description) {
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