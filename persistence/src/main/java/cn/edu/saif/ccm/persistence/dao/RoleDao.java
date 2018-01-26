package cn.edu.saif.ccm.persistence.dao;

import java.util.List;

import cn.edu.saif.ccm.domain.security.Role;

public interface RoleDao {
	
	public List<Role> findAll();
	
	public Role findById(int id);
	
	public Role findByName(String roleName);
	
	public List<Role> findDefault();
	
	public void save(Role role);
	
	public void remove(Role role);
	
	public void update(Role role);
	
}
