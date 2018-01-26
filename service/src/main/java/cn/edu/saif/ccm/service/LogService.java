package cn.edu.saif.ccm.service;

import java.util.List;

import cn.edu.saif.ccm.domain.log.EpUserDLog;
import cn.edu.saif.ccm.domain.log.EpUserLog;
import cn.edu.saif.ccm.domain.log.EpUserQLog;
import cn.edu.saif.ccm.domain.log.UserDLog;
import cn.edu.saif.ccm.domain.log.UserLog;
import cn.edu.saif.ccm.domain.log.UserQLog;
import cn.edu.saif.shared.common.ExportDTO;
import cn.edu.saif.shared.query.QueryMeta;

public interface LogService {
	
	public UserLog findById(int id);
	
	public UserLog findByUserId(int userId);
	
	public List<UserLog> findAll(int first,int max);
	
	public List<EpUserLog> findEpAll(int first,int max);
	
	public List<UserDLog> findDownLoadAll(int first,int max);
	
	public List<EpUserDLog> findEpDownLoadAll(int first,int max);
	
	public List<UserQLog> findQueryAll(int first,int max);
	
	public List<EpUserQLog> findEpQueryAll(int first,int max);
	
	public void saveUserLog(int userId,String ipAddress);
	
	public void saveEpUserLog(int userId,String ipAddress);
	
	public void saveUserDLog(int userId,QueryMeta meta,ExportDTO result);
	
	public void saveEpUserDLog(int userId,QueryMeta meta,ExportDTO result);
	
	public void saveUserQLog(int userId, QueryMeta meta, ExportDTO result);
			
	public void saveEpUserQLog(int userId, QueryMeta meta, ExportDTO result);
	
}
