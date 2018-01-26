package cn.edu.saif.ccm.persistence.dao;

import java.util.List;

import cn.edu.saif.ccm.domain.log.EpUserDLog;
import cn.edu.saif.ccm.domain.log.EpUserLog;
import cn.edu.saif.ccm.domain.log.EpUserQLog;
import cn.edu.saif.ccm.domain.log.UserDLog;
import cn.edu.saif.ccm.domain.log.UserLog;
import cn.edu.saif.ccm.domain.log.UserQLog;

public interface LogDao {
	
	public Long getCount(String hql);
	
	public UserLog findById(int id);
	
	public UserLog findByUserId(int userId);
	
	public EpUserLog findEpByUserId(int userId);
	
	public List<UserLog> findAll(int first,int max);
	
	public List<EpUserLog> findEpAll(int first,int max);
	
	public List<UserDLog> findDAll(int first,int max);
	
	public List<EpUserDLog> findEpDAll(int first,int max);
	
	public List<UserQLog> findQAll(int first,int max);
	
	public List<EpUserQLog> findEpQAll(int first,int max);
	
	public void save(UserLog userLog);
	
	public void save(EpUserLog userLog);
	
	public void save(UserDLog userDLog);
	
	public void save(EpUserDLog userDLog);
	
	public void save(UserQLog userQLog);
	
	public void save(EpUserQLog userQLog);
	
	public void update(UserLog userLog);
	
	public void update(EpUserLog userLog);
	
}
