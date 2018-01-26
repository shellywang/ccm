package cn.edu.saif.ccm.persistence.dao;

import java.util.Date;
import java.util.List;

import cn.edu.saif.ccm.domain.reset.ResetRequest;

public interface ResetDao {
	
	public ResetRequest findById(int id);
	
	public ResetRequest findByCode(String code);
	
	public ResetRequest findValidByCode(String code,Date date);
	
	public List<ResetRequest> findAll();
	
	public void save(ResetRequest resetRequest);
	
	public void update(ResetRequest resetRequest);
	
	public void delete(ResetRequest resetRequest);
	
	public void deleteInvalid(Date date);
	
}
