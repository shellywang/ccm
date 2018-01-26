package cn.edu.saif.shared.query;

import java.sql.Date;
import java.util.List;

public class QueryMeta {
	
	private List<DataField> fields;
	
	private List<Condition> conditions;	

	private int pageSize;
	
	private int pageNow;
	
	private String dateName;
	
	private Date fromDate;
	
	private boolean first;
	
	private Date toDate;
	
	private Integer dateType;
	
	private String fileType;

	public List<DataField> getFields() {
		return fields;
	}

	public void setFields(List<DataField> fields) {
		this.fields = fields;
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public int getPageSize() {
		if(pageSize==0)
			return 25;
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	
	public int getFirstIndex(){
		if(pageNow==0)
			pageNow=1;
		return (pageNow-1)*pageSize;
	}

	public String getDateName() {
		return dateName;
	}

	public void setDateName(String dateName) {
		this.dateName = dateName;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Integer getDateType() {
		return dateType;
	}

	public void setDateType(Integer dateType) {
		this.dateType = dateType;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}
	
}
