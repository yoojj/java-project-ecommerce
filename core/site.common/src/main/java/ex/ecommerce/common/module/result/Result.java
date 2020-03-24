package ex.ecommerce.common.module.result;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Result implements Serializable {

	private int code = CodeEnum.ERROR.getCode();
	private String message;
	private Object result;
	private ResultMap resultMap;

	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
	public ResultMap getResultMap() {
		return resultMap;
	}

	public void setResultMap(ResultMap map) {
		this.resultMap = map;
	}
	
	public String toSting(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n");
		sb.append(this.getClass().getName()).append("\n");
		sb.append("결과 코드  [ " + code + " ] \n");
		sb.append("메시지     [ " + message + " ] \n");
	
		if( result != null ) 		
			sb.append("결과   [ " + result.toString() + " ] \n");
		
		if( resultMap != null ) 
			sb.append("결과   [ " + resultMap.toString() + " ] \n");
		
		return sb.toString();
	}

}