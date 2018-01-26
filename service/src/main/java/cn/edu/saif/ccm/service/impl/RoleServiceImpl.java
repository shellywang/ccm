package cn.edu.saif.ccm.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.saif.ccm.domain.dto.Auth;
import cn.edu.saif.ccm.domain.security.Permission;
import cn.edu.saif.ccm.domain.security.Role;
import cn.edu.saif.ccm.persistence.dao.PermissionDao;
import cn.edu.saif.ccm.persistence.dao.RoleDao;
import cn.edu.saif.ccm.service.RoleService;
import cn.edu.saif.shared.common.BaseException;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
	
	protected Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	PermissionDao permDao;
	
	@Override
	public List<Role> loadRoles() {
		List<Role> roles=roleDao.findAll();
		log.debug("Hibernate Lazy load ["+roles+".permissions]");
		for(Role role:roles){
			role.getPermissions().size();
		}
		return roles;
	}

	@Override
	public void add(Role role) throws BaseException {
		checkRole(role);
		role.setCreationTime(new Date());
		roleDao.save(role);
	}
	
	private void checkRole(Role role) throws BaseException{
		if(StringUtils.isBlank(role.getName()))
			throw new BaseException("Role name can not be null!");
		Role role1=roleDao.findByName(role.getName());
		if(role1!=null)
			throw new BaseException("Role name already exists!");
	}

	@Override
	public Role details(int id) {
		Role role=roleDao.findById(id);
		log.debug("Hibernate Lazy load ["+role+".permissions]");
		if(role!=null)
			role.getPermissions().size();
		return role;
	}

	@Override
	public void changePermission(Auth auth) throws BaseException {
		checkAuth(auth);
		Role role=roleDao.findById(auth.getRoleId());
		if(role==null)
			throw new BaseException("Role id not not exists ["+auth.getRoleId()+"]");
		List<Integer> permList=auth.getPermList();
		Set<Permission> permissions=role.getPermissions();
		Iterator<Permission> iter=permissions.iterator();
		while(iter.hasNext()){
			int permId=iter.next().getId();
			boolean isDetele=true;
			for(int j=0;j<permList.size();j++){
				if(permId==permList.get(j)){
					permList.remove(j);
					isDetele=false;
				}
			}
			if(isDetele){
				iter.remove();
			}
		}
		for(int permId:permList){ //找到要添加的permission
			Permission perm=permDao.findById(permId);
			if(perm!=null){
				permissions.add(perm);
			}
		}
		roleDao.update(role);
	}
	
	private void checkAuth(Auth auth) throws BaseException{
		if(auth.getRoleId()==null)
			throw new BaseException("Role id can not be null!");
	}

	@Override
	public List<Role> findAll() {
		List<Role> roles=roleDao.findAll();
		return roles;
	}

	@Override
	public void delete(int roleId) throws BaseException {
		Role role=roleDao.findById(roleId);
		if(role!=null)
			roleDao.remove(role);
	}
}
