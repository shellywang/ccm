package cn.edu.saif.shared.common;

public class Pageable {
	
	private int pageNumber;
	private int pageSize;
	private int offset;
	private int totalSize;
	
	public int getPageNumber() {
		if(pageNumber==0)
			pageNumber=1;
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
		
}
