package cn.edu.saif.ccm.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import cn.edu.saif.ccm.domain.security.Role;
import cn.edu.saif.ccm.persistence.dao.RoleDao;

@Repository
public class RoleDaoImpl implements RoleDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Role> findAll() {
		return em.createQuery("FROM Role", Role.class)
				.getResultList();
	}

	@Override
	public Role findById(int id) {
		return em.find(Role.class, id);
	}

	@Override
	public Role findByName(String roleName) {
		Role role=null;
		List<Role> roles=em.createQuery("FROM Role WHERE name=?", Role.class)
				.setParameter(1, roleName)
				.getResultList();
		if(roles.size()>0)
			role=roles.get(0);
		return role;
	}

	@Override
	public void save(Role role) {
		em.persist(role);
	}

	@Override
	public void update(Role role) {
		em.merge(role);
	}

	@Override
	public List<Role> findDefault() {
		List<Role> roles=em.createQuery("FROM Role WHERE defaultRole is ?", Role.class)
				.setParameter(1, true)
				.getResultList();
		return roles;
	}

	@Override
	public void remove(Role role) {
		em.remove(role);
	}

}
