package cn.edu.saif.ccm.domain.dto.audit;

import java.sql.Date;
import java.util.List;

public class Audit {
	
	private List<Integer> idList;
	private Date expireDate;

	public List<Integer> getIdList() {
		return idList;
	}
	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	
}
