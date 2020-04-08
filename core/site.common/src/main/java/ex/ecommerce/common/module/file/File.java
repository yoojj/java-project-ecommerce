package ex.ecommerce.common.module.file;

import java.io.Serializable;

@SuppressWarnings("serial")
public class File implements Serializable {

	private int fno;
	private int fk;
	private String table;
	private String fileName;
	private String saveFileName;
	private String thumbnailName;
	private String fileSize;
	private String directory;
	private String updateAdmin;
	private String updateDate;
	private String updateMsg;
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

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public String getThumbnailName() {
		return thumbnailName;
	}

	public void setThumbnailName(String thumbnailName) {
		this.thumbnailName = thumbnailName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
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
		sb.append("번호        [ " + fno + " ] \n");
		sb.append("외래키      [ " + fk + " ] \n");
		sb.append("테이블      [ " + table + " ] \n");
		sb.append("원본 파일명 [ " + fileName + " ] \n");
		sb.append("저장 파일명 [ " + saveFileName + " ] \n");
		sb.append("썸네일      [ " + thumbnailName + " ] \n");
		sb.append("파일 크기   [ " + fileSize + " ] \n");
		sb.append("저장 경로   [ " + directory + " ] \n");
		sb.append("수정자      [ " + updateAdmin + " ] \n");
		sb.append("수정일      [ " + updateDate + " ] \n");
		sb.append("수정 이유   [ " + updateMsg + " ] \n");
		sb.append("삭제 여부   [ " + status + " ] \n");
		
		return sb.toString();
	}
	
}