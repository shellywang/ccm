package cn.edu.saif.ccm.service;

import java.util.List;

import cn.edu.saif.ccm.domain.security.Permission;
import cn.edu.saif.shared.common.BaseException;

public interface PermissionService {
	
	public List<Permission> finAll();
	
	public List<Permission> loadPermissions();
	
	public void add(Permission permission) throws BaseException;
	
	public void delete(int permId) throws BaseException;
	
}
