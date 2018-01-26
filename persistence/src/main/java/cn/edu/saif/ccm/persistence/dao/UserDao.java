package cn.edu.saif.ccm.persistence.dao;

import java.sql.Date;
import java.util.List;

import cn.edu.saif.ccm.domain.user.EpUser;
import cn.edu.saif.ccm.domain.user.User;

public interface UserDao {
	
	public User findUserById(int id);
	
	public EpUser findEpUserById(int id);
	
	public User findUserByName(String username);
	
	public EpUser findEpUserByName(String name);
	
	public EpUser findEpUserByFullName(String fullName);
	
	public User findUserByEmail(String email);
	
	public User findUserByNamePwd(String username,String pwd);
	
	public EpUser findUserByIp(Long ipLong);
	
	public List<User> findAudit();
	
	public List<User> findActive(Date date);
	
	public List<EpUser> findEpActive(Date date);
	
	public List<User> findExpired(Date date);
	
	public List<EpUser> findEpExpired(Date date);
	
	public List<User> findAll();
	
	public void save(User user);
	
	public void save(EpUser epUser);
	
	public void update(User user);
	
	public void update(EpUser user);
	
	public void remove(User user);
	
	public void remove(EpUser user);
	
}
