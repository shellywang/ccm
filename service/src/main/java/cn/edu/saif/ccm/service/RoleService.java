package cn.edu.saif.ccm.service;

import java.util.List;

import cn.edu.saif.ccm.domain.dto.Auth;
import cn.edu.saif.ccm.domain.security.Role;
import cn.edu.saif.shared.common.BaseException;

public interface RoleService {
	
	public List<Role> loadRoles();
	
	public List<Role> findAll();
	
	public void add(Role role) throws BaseException;
	
	public void delete(int roleId) throws BaseException;
	
	public Role details(int id);
	
	public void changePermission(Auth auth)  throws BaseException ;
	
}
