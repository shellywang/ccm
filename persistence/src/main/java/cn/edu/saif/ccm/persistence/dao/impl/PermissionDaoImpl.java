package cn.edu.saif.ccm.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import cn.edu.saif.ccm.domain.security.Permission;
import cn.edu.saif.ccm.persistence.dao.PermissionDao;

@Repository
public class PermissionDaoImpl implements PermissionDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Permission> findAll() {
		return em.createQuery("FROM Permission",Permission.class)
				.getResultList();
	}

	@Override
	public Permission findById(int id) {
		return em.find(Permission.class, id);
	}

	@Override
	public Permission findByUrl(String url) {
		Permission permission=null;
		List<Permission> list=em.createQuery("FROM Permission WHERE url=?", Permission.class)
				.setParameter(1, url)
				.getResultList();
		if(list.size()>0)
			permission=list.get(0);
		return permission;
	}

	@Override
	public void save(Permission permission) {
		em.persist(permission);
	}

	@Override
	public void remove(Permission permission) {
		em.remove(permission);
	}

}
