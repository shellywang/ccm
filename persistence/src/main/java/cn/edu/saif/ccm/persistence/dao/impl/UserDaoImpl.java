package cn.edu.saif.ccm.persistence.dao.impl;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import cn.edu.saif.ccm.domain.user.EpUser;
import cn.edu.saif.ccm.domain.user.User;
import cn.edu.saif.ccm.persistence.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User findUserById(int id) {
		return em.find(User.class, id);
	}

	@Override
	public EpUser findEpUserById(int id) {
//		EpUser user=null;
//		List<EpUser> users=em.createQuery("FROM EpUser WHERE id=?",EpUser.class)
//		.setParameter(1, id)
//		.getResultList();
//		if(users.size()>0)
//			user=users.get(0);
		return em.find(EpUser.class, id);
	}
	
	@Override
	public User findUserByEmail(String email) {
		User user=null;
		String hql="FROM User WHERE email=?";
		List<User> users=em.createQuery(hql,User.class)
				.setParameter(1, email)
				.getResultList();
		if(users.size()!=0){
			user=users.get(0);
		}
		return user;
	}
	
	@Override
	public User findUserByNamePwd(String userName, String pwd) {
		User user=null;
		String hql="FROM User WHERE username=? AND password=?";
		List<User> users=em.createQuery(hql,User.class)
				.setParameter(1, userName).setParameter(2, pwd)
				.getResultList();
		if(users.size()!=0){
			user=users.get(0);
		}
		return user;
	}

	@Override
	public User findUserByName(String username) {
		User user=null;
		String hql="FROM User WHERE username=?";
		List<User> users=em.createQuery(hql,User.class)
				.setParameter(1, username)
				.getResultList();
		if(users.size()!=0){
			user=users.get(0);
		}
		return user;
	}
	
	@Override
	public EpUser findEpUserByName(String name) {
		EpUser user=null;
		String hql="FROM EpUser WHERE name=?";
		List<EpUser> users=em.createQuery(hql,EpUser.class)
				.setParameter(1, name)
				.getResultList();
		if(users.size()!=0){
			user=users.get(0);
		}
		return user;
	}
	
	@Override
	public EpUser findEpUserByFullName(String fullName) {
		EpUser user=null;
		String hql="FROM EpUser WHERE fullName=?";
		List<EpUser> users=em.createQuery(hql,EpUser.class)
				.setParameter(1, fullName)
				.getResultList();
		if(users.size()!=0){
			user=users.get(0);
		}
		return user;
	}
	
	@Override
	public List<User> findAll() {
		return em.createQuery("FROM User",User.class)
				.getResultList();
	}

	@Override
	public void save(User user) {
		em.persist(user);
	}

	@Override
	public List<User> findAudit() {
		return em.createQuery("FROM User where approval=0", User.class)
				.getResultList();
	}

	@Override
	public List<User> findActive(Date date) {
		return em.createQuery("FROM User where approval=1 and (expireDate is null OR expireDate >?)", User.class)
				.setParameter(1, date)
				.getResultList();
	}

	@Override
	public List<User> findExpired(Date date) {
		return em.createQuery("FROM User where approval=1 and expireDate <=?", User.class)
				.setParameter(1, date)
				.getResultList();
	}

	@Override
	public EpUser findUserByIp(Long ipLong) {
		EpUser user=null;
		String hql="FROM EpUser WHERE dbo.IP2Int(ipStart) <=? AND dbo.IP2Int(ipEnd) >=?";
		List<EpUser> users=em.createQuery(hql, EpUser.class)
		.setParameter(1, ipLong).setParameter(2, ipLong)
		.getResultList();
		if(users.size()>0)
			user=users.get(0);
		return user;
	}

	@Override
	public List<EpUser> findEpActive(Date date) {
		return em.createQuery("FROM EpUser where (expireDate is null OR expireDate >?)", EpUser.class)
				.setParameter(1, date)
				.getResultList();
	}

	@Override
	public List<EpUser> findEpExpired(Date date) {
		return em.createQuery("FROM EpUser where expireDate <=?", EpUser.class)
				.setParameter(1, date)
				.getResultList();
	}

	@Override
	public void save(EpUser epUser) {
		em.persist(epUser);
	}

	@Override
	public void update(User user) {
		em.merge(user);
	}

	@Override
	public void remove(User user) {
		em.remove(user);
	}

	@Override
	public void update(EpUser user) {
		em.merge(user);
	}

	@Override
	public void remove(EpUser user) {
		em.remove(user);
	}

}
