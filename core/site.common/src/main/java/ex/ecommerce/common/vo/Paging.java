package ex.ecommerce.common.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Paging implements Serializable {

	/** 전체 글 개수 */
	private int allPost;
	
	/** 한 페이지에 보여질 글 수 */
	private int postList;

	/** 페이지네이션에 보여질 페이지 수 */
	private int pageList;
	
	/** 글 시작점  */
	private int postMark;
	
	/** 페이지 시작 */
	private int pageStart;
	
	/** 페이지 끝 */
	private int pageEnd;
	
	/** 요청 페이지 */
	private int page;
	
	/** 페이지 목록 시작 */
	private int pageListStart;
	
	/** 페이지 목록 끝 */
	private int pageListEnd;
	
	public Paging() {
		
		// fetchSize와 동일한 값 
		this.postList = 15;
		this.pageList = 5;
		this.pageStart = 1;
		
	}
	
	public void setPaging(int allPost, int page) {
	
		this.allPost = allPost;
		this.page = page;
		this.pageEnd = (this.allPost - 1) / this.postList + 1;
		
		this.init();
	}
	
	private void init() {

		if( this.page > this.pageEnd ) this.page = this.pageEnd;
		
		this.postMark = (this.page - 1) * postList;

		if( this.page <= this.pageStart ) {
			
			this.pageListStart = this.pageStart;
			this.pageListEnd = this.pageList <= this.pageEnd ? this.pageList : this.pageEnd ;
		
		} else {
			
			this.pageListStart = this.pageList + (this.page - this.pageList);
			int temp = this.pageList + this.pageListStart - 1;
			this.pageListEnd = temp <= this.pageEnd ? temp : this.pageEnd ;
			
		}
	
	}

	public int getAllPost() {
		return allPost;
	}

	public int getPostList() {
		return postList;
	}

	public int getPageList() {
		return pageList;
	}

	public int getPostMark() {
		return postMark;
	}
	
	public int getPageStart() {
		return pageStart;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public int getPage() {
		return page;
	}

	public int getPageListStart() {
		return pageListStart;
	}

	public int getPageListEnd() {
		return pageListEnd;
	}

	public String toSting(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n");
		sb.append(this.getClass().getName()).append("\n");
		sb.append("전체 게시물 개수 [ " + allPost + " ] \n");
		sb.append("보여질 글 개수   [ " + postList + " ] \n");
		sb.append("보여질 페이지 수 [ " + pageList + " ] \n");
		sb.append("글 시작점        [ " + postMark + " ] \n");
		sb.append("페이지 시작      [ " + pageStart + " ] \n");
		sb.append("페이지 끝        [ " + pageEnd + " ] \n");
		sb.append("요청 페이지      [ " + page + " ] \n");
		sb.append("페이지 목록 시작 [ " + pageListStart + " ] \n");
		sb.append("페이지 목록 끝   [ " + pageListEnd + " ] \n");
		
		return sb.toString();
	}
	
}