package ex.ecommerce.common.vo.site;

import java.io.Serializable;

@SuppressWarnings("serial") 
public class UserPoint implements Serializable {

	private int upno;

	private String id;
	
	/** 포인트 정보 */
	private Point point;
	
	/** 포인트 적립일 */
	private String savePointDate;
	
	/** 포인트 사용일 */
	private String usePointDate;
	
	private String updateAdmin;
	private String updateDate;
	private String updateMsg;
	
	/** 포인트 상태 -- 사용 가능 여부 */
	private boolean state;

	public int getUpno() {
		return upno;
	}

	public void setUpno(int upno) {
		this.upno = upno;
	}

	public String getId() {
		return id;
	}

	public void setUser(String id) {
		this.id = id;
	}
	
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public String getSavePointDate() {
		return savePointDate;
	}

	public void setSavePointDate(String savePointDate) {
		this.savePointDate = savePointDate;
	}

	public String getUsePointDate() {
		return usePointDate;
	}

	public void setUsePointDate(String usePointDate) {
		this.usePointDate = usePointDate;
	}

	public String getUpdateAdmin() {
		return updateAdmin;
	}

	public void setUpdateAdmin(String updateAdmin) {
		this.updateAdmin = updateAdmin;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateMsg() {
		return updateMsg;
	}

	public void setUpdateMsg(String updateMsg) {
		this.updateMsg = updateMsg;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	public String toSting(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n");
		sb.append(this.getClass().getName()).append("\n");
		sb.append("번호             [ " + upno + " ] \n");
		sb.append("회원             [ " + id + " ] \n");
		sb.append("포인트 정보      [ " + point.toString() + " ] \n");
		sb.append("포인트 적립일    [ " + savePointDate + " ] \n");
		sb.append("포인트 사용일    [ " + usePointDate + " ] \n");
		sb.append("수정자           [ " + updateAdmin + " ] \n");
		sb.append("수정일           [ " + updateDate + " ] \n");
		sb.append("수정 이유        [ " + updateMsg + " ] \n");
		sb.append("사용 가능 여부   [ " + state + " ] \n");
		
		return sb.toString();
	}
	
}