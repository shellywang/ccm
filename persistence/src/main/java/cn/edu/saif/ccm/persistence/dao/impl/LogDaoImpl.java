package cn.edu.saif.ccm.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import cn.edu.saif.ccm.domain.log.EpUserDLog;
import cn.edu.saif.ccm.domain.log.EpUserLog;
import cn.edu.saif.ccm.domain.log.EpUserQLog;
import cn.edu.saif.ccm.domain.log.UserDLog;
import cn.edu.saif.ccm.domain.log.UserLog;
import cn.edu.saif.ccm.domain.log.UserQLog;
import cn.edu.saif.ccm.persistence.dao.LogDao;

@Repository
public class LogDaoImpl implements LogDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Long getCount(String hql){
		return (Long) em.createQuery(hql).getResultList().get(0);
	}
	
	@Override
	public UserLog findById(int id) {
		return em.find(UserLog.class, id);
	}

	@Override
	public UserLog findByUserId(int userId) {
		UserLog log=null;
		List<UserLog> list=em.createQuery("FROM UserLog WHERE user.id=?", UserLog.class)
				.setParameter(1, userId)
				.getResultList();
		if(list.size()!=0)
			log=list.get(0);
		return log;
	}

	@Override
	public EpUserLog findEpByUserId(int userId) {
		EpUserLog log=null;
		List<EpUserLog> list=em.createQuery("FROM EpUserLog WHERE user.id=?", EpUserLog.class)
				.setParameter(1, userId)
				.getResultList();
		if(list.size()!=0)
			log=list.get(0);
		return log;
	}
	
	@Override
	public List<UserLog> findAll(int first, int max) {
		return em.createQuery("FROM UserLog ORDER BY lastLoginTime DESC", UserLog.class)
				.setFirstResult(first)
				.setMaxResults(max)
				.getResultList();
	}

	@Override
	public List<EpUserLog> findEpAll(int first, int max) {
		return em.createQuery("FROM EpUserLog ORDER BY lastLoginTime DESC", EpUserLog.class)
				.setFirstResult(first)
				.setMaxResults(max)
				.getResultList();
	}
	
	@Override
	public List<UserDLog> findDAll(int first, int max) {
		return em.createQuery("FROM UserDLog ORDER BY id DESC", UserDLog.class)
				.setFirstResult(first)
				.setMaxResults(max)
				.getResultList();
	}
	
	@Override
	public List<EpUserDLog> findEpDAll(int first, int max) {
		return em.createQuery("FROM EpUserDLog ORDER BY id DESC", EpUserDLog.class)
				.setFirstResult(first)
				.setMaxResults(max)
				.getResultList();
	}
	
	@Override
	public void save(UserLog userLog) {
		em.persist(userLog);
	}

	@Override
	public void save(EpUserLog userLog) {
		em.persist(userLog);
	}

	@Override
	public void save(UserDLog userDLog) {
		em.persist(userDLog);
	}

	@Override
	public void save(EpUserDLog userDLog) {
		em.persist(userDLog);
	}

	@Override
	public List<UserQLog> findQAll(int first, int max) {
		return em.createQuery("FROM UserQLog ORDER BY id DESC", UserQLog.class)
				.setFirstResult(first)
				.setMaxResults(max)
				.getResultList();
	}

	@Override
	public List<EpUserQLog> findEpQAll(int first, int max) {
		return em.createQuery("FROM EpUserQLog ORDER BY id DESC", EpUserQLog.class)
				.setFirstResult(first)
				.setMaxResults(max)
				.getResultList();
	}

	@Override
	public void save(UserQLog userQLog) {
		em.persist(userQLog);
	}

	@Override
	public void save(EpUserQLog userQLog) {
		em.persist(userQLog);
	}

	@Override
	public void update(UserLog userLog) {
		em.merge(userLog);
	}

	@Override
	public void update(EpUserLog userLog) {
		em.merge(userLog);
	}

}
