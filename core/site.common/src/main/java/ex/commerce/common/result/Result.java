package ex.commerce.common.result;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Result implements Serializable {

	private int code;
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
	
}