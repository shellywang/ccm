package cn.edu.saif.ccm.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import cn.edu.saif.ccm.domain.stock.DailyInfo;
import cn.edu.saif.ccm.domain.stock.PortfolioRet;
import cn.edu.saif.ccm.domain.stock.StockRet;
import cn.edu.saif.ccm.domain.stock.ThreeFactor;
import cn.edu.saif.ccm.persistence.dao.StockDao;

/**
 * Finance Data Dao Impl
 *
 * @author Xiao GuangLei
 * @since 1.0
 */
@Repository
public class StockDaoImpl implements StockDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Long getCount(String hql){
		return (Long) em.createQuery(hql).getResultList().get(0);
	}
	
	@Override
	public List<StockRet> findStockRet(int first, int max, String hql) {
		return em.createQuery(hql,StockRet.class)
				.setFirstResult(first)
				.setMaxResults(max)
				.getResultList();
	}
	
	@Override
	public List<PortfolioRet> findPortfolioRet(int first, int max, String hql) {
		return em.createQuery(hql,PortfolioRet.class)
				.setFirstResult(first)
				.setMaxResults(max)
				.getResultList();
	}
	
	@Override
	public List<DailyInfo> findDailyInfo(int first, int max, String hql) {
		return em.createQuery(hql,DailyInfo.class)
				.setFirstResult(first)
				.setMaxResults(max)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DailyInfo> findDailyInfo(DetachedCriteria dc) {
		Session session=(Session) em.getDelegate();
		return dc.getExecutableCriteria(session).setMaxResults(20).list();
	}

	@Override
	public List<ThreeFactor> findFactor(int first,int max,String hql){
		return em.createQuery(hql, ThreeFactor.class)
				.setFirstResult(first)
				.setMaxResults(max)
				.getResultList();
	}
	
}
