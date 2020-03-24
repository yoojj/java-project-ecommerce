package ex.ecommerce.common.vo.site;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Search implements Serializable {
	
	/** 검색 형태 */
	private String type;
	
	/** 검색 형태 목록 */
	private String[] typeIs;
	
	/** 검색어 */
	private String keyword;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String[] getTypeIs() {
		return typeIs;
	}

	public void setTypeIs(String[] typeIs) {
		this.typeIs = typeIs;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String toSting(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n");
		sb.append(this.getClass().getName()).append("\n");
		sb.append("검색 형태      [ " + type + " ] \n");
		sb.append("검색 형태 목록 [ " + typeIs + " ] \n");
		sb.append("검색어         [ " + keyword + " ] \n");
		
		return sb.toString();
	}
	
}