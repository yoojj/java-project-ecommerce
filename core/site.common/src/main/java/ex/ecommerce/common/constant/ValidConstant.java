package ex.ecommerce.common.constant;

public class ValidConstant {

	public static final int ID_MIN_NUM = 3;
	public static final int PWD_MIN_NUM = 3;
	public static final int EMAIL_MIN_NUM = 6;
	
	public static final int TITLE_MIN_NUM = 1;
	public static final int CONTENT_MIN_NUM = 1;
	
	public static final int KEYWORD_MIN_NUM = 2;
	
	public static final String REG_ONLY_KOR= "^[가-힣]+$";
	public static final String REG_ONLY_ENG = "^[a-zA-Z]+$";
	public static final String REG_ONLY_NUM = "^[0-9]+$";
	
	public static final String REG_ENG_NUM = "^[a-zA-Z0-9]+$";
	public static final String REG_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\\.[a-z]+)+$";
	
	public static final String REG_FILE_IMG = "\\.(gif|jpg|jpe|jpeg|png|tif|bmp)*$";
	
}