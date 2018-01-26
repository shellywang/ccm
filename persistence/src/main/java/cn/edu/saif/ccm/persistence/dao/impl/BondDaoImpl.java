package cn.edu.saif.ccm.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import cn.edu.saif.ccm.domain.bond.CLBondCapAppRet;
import cn.edu.saif.ccm.domain.bond.CLBondRet;
import cn.edu.saif.ccm.domain.bond.CLBondYield;
import cn.edu.saif.ccm.domain.bond.GBondCapAppRet;
import cn.edu.saif.ccm.domain.bond.GBondDesc;
import cn.edu.saif.ccm.domain.bond.GBondMat;
import cn.edu.saif.ccm.domain.bond.GBondPrc;
import cn.edu.saif.ccm.domain.bond.GBondRet;
import cn.edu.saif.ccm.persistence.dao.BondDao;

@Repository
public class BondDaoImpl implements BondDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Long getCount(String hql) {
		return (Long) em.createQuery(hql).getResultList().get(0);
	}
	
	@Override
	public List<GBondRet> findGBondRet(int first,int max,String hql) {
		return em.createQuery(hql, GBondRet.class)
				.setFirstResult(first)
				.setMaxResults(max)
				.getResultList();
	}

	@Override
	public List<GBondDesc> findGBondDesc(int first,int max,String hql) {
		return em.createQuery(hql, GBondDesc.class)
				.setFirstResult(first)
				.setMaxResults(max)
				.getResultList();
	}

	@Override
	public List<GBondMat> findGBondMat(int first,int max,String hql) {
		return em.createQuery(hql, GBondMat.class)
				.setFirstResult(first)
				.setMaxResults(max)
				.getResultList();
	}

	@Override
	public List<GBondPrc> findGBondPrc(int first,int max,String hql) {
		return em.createQuery(hql, GBondPrc.class)
				.setFirstResult(first)
				.setMaxResults(max)
				.getResultList();
	}

	@Override
	public List<GBondCapAppRet> findGBondCapAppRet(int first,int max,String hql) {
		return em.createQuery(hql, GBondCapAppRet.class)
				.setFirstResult(first)
				.setMaxResults(max)
				.getResultList();
	}

	@Override
	public List<CLBondRet> findCLBondRet(int first,int max,String hql) {
		return em.createQuery(hql, CLBondRet.class)
				.setFirstResult(first)
				.setMaxResults(max)
				.getResultList();
	}

	@Override
	public List<CLBondCapAppRet> findCLBondCapAppRet(int first,int max,String hql) {
		return em.createQuery(hql, CLBondCapAppRet.class)
				.setFirstResult(first)
				.setMaxResults(max)
				.getResultList();
	}

	@Override
	public List<CLBondYield> findCLBondYield(int first,int max,String hql) {
		return em.createQuery(hql, CLBondYield.class)
				.setFirstResult(first)
				.setMaxResults(max)
				.getResultList();
	}

}
