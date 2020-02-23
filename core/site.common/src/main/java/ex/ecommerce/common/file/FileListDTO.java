package ex.ecommerce.common.file;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FileListDTO implements Serializable {
	
	private int fno;
	private int fk;
	private boolean status;

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public int getFk() {
		return fk;
	}

	public void setFk(int fk) {
		this.fk = fk;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String toSting(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n");
		sb.append(this.getClass().getName()).append("\n");
		sb.append("번호      [ " + fno + " ] \n");
		sb.append("외래키    [ " + fk + " ] \n");
		sb.append("삭제 여부 [ " + status + " ] \n");
		
		return sb.toString();
	}
	
}
