package cn.edu.saif.shared.common;

import java.util.List;

public class Page<T> {
	
	private List<T> data;
	
	private Pageable pageable;
	
	public Page(List<T> data,Pageable pageable){
		this.data=data;
		this.pageable=pageable;
	}
	
	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Pageable getPageable() {
		return pageable;
	}

	public void setPageable(Pageable pageable) {
		this.pageable = pageable;
	}
	
}
