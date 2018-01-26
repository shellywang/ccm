package cn.edu.saif.ccm.persistence.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import cn.edu.saif.ccm.domain.reset.ResetRequest;
import cn.edu.saif.ccm.persistence.dao.ResetDao;

@Repository
public class ResetDaoImpl implements ResetDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public ResetRequest findById(int id) {
		return em.find(ResetRequest.class, id);
	}

	@Override
	public ResetRequest findByCode(String code) {
		ResetRequest resetRequest=null;
		List<ResetRequest> list=em.createQuery("FROM ResetRequest WHERE code=?", ResetRequest.class)
				.setParameter(1, code)
				.getResultList();
		if(list.size()>0)
			resetRequest=list.get(0);
		return resetRequest;
	}

	@Override
	public ResetRequest findValidByCode(String code, Date date) {
		ResetRequest resetRequest=null;
		List<ResetRequest> list=em.createQuery("FROM ResetRequest WHERE code=? AND expireTime>?", ResetRequest.class)
				.setParameter(1, code)
				.setParameter(2, date)
				.getResultList();
		if(list.size()>0)
			resetRequest=list.get(0);
		return resetRequest;
	}
	
	@Override
	public List<ResetRequest> findAll() {
		return em.createQuery("FROM ResetRequest", ResetRequest.class)
				.getResultList();
	}

	@Override
	public void save(ResetRequest resetRequest) {
		em.persist(resetRequest);
	}

	@Override
	public void update(ResetRequest resetRequest) {
		em.merge(resetRequest);
	}

	@Override
	public void delete(ResetRequest resetRequest) {
		em.remove(resetRequest);
	}

	@Override
	public void deleteInvalid(Date date) {
		em.createQuery("DELETE FROM ResetRequest WHERE expireTime < ?")
			.setParameter(1, date)
			.executeUpdate();
	}

}
