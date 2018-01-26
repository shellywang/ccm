package cn.edu.saif.ccm.persistence.dao;

import java.util.List;

import cn.edu.saif.ccm.domain.security.Permission;

public interface PermissionDao {
	
	public List<Permission> findAll();
	
	public Permission findById(int id);
	
	public Permission findByUrl(String url);
	
	public void save(Permission permission);
	
	public void remove(Permission permission);
	
}
