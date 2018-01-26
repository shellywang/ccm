package cn.edu.saif.ccm.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.saif.ccm.domain.security.Permission;
import cn.edu.saif.ccm.persistence.dao.PermissionDao;
import cn.edu.saif.ccm.service.PermissionService;
import cn.edu.saif.shared.common.BaseException;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
	
	protected Logger log = LoggerFactory.getLogger(PermissionServiceImpl.class);
	
	@Autowired
	private PermissionDao permissionDao;
	
	@Override
	public List<Permission> loadPermissions() {
		List<Permission> permissions=permissionDao.findAll();
		log.debug("Hibernate Lazy load ["+permissions+".roles]");
		for(Permission permisson : permissions){
			permisson.getRoles().size();
		}
		return permissions;
	}

	@Override
	public void add(Permission permission) throws BaseException {
		checkPermission(permission);
		permissionDao.save(permission);
	}
	
	private void checkPermission(Permission permission) throws BaseException{
		if(StringUtils.isBlank(permission.getUrl()))
			throw new BaseException("Permission url can not be null!");
		Permission p=permissionDao.findByUrl(permission.getUrl());
		if(p!=null){
			throw new BaseException("Permission already exists!");
		}
	}

	@Override
	public List<Permission> finAll() {
		List<Permission> permissions=permissionDao.findAll();
		return permissions;
	}

	@Override
	public void delete(int permId) throws BaseException {
		Permission perm=permissionDao.findById(permId);
		if(perm!=null)
			permissionDao.remove(perm);
	}
}
