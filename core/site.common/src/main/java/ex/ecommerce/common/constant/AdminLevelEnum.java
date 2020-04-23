package ex.ecommerce.common.constant;

public enum AdminLevelEnum {

	LEVEL_0(0, "임시 관리자"),
	LEVEL_1(1, "루트 관리자"),
	LEVEL_2(2, "상위 관리자"),
	LEVEL_3(3, "중간 관리자"),
	LEVEL_4(4, "하위 관리자");
	
	private final int num;
	private final String str;
	
	private AdminLevelEnum(int num, String str) {
		this.num = num;
		this.str = str;
	}

	public int getNum() {
		return num;
	}

	public String getStr() {
		return str;
	}

}