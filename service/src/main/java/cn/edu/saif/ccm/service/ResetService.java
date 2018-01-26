package cn.edu.saif.ccm.service;

import java.util.List;

import cn.edu.saif.ccm.domain.reset.ResetRequest;
import cn.edu.saif.shared.common.BaseException;

public interface ResetService {
	
	public ResetRequest findById(int id);
	
	public ResetRequest findByCode(String code);
	
	public ResetRequest findValidByCode(String code);
	
	public List<ResetRequest> findAll();
	
	public void reset(String code,String password) throws BaseException;
	
	public void sendReset(String email) throws BaseException;
	
	public void add(ResetRequest resetRequest);
	
	public void delete(ResetRequest resetRequest);
	
	public void deleteInvalid();
	
}
