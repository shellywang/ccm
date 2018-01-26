package cn.edu.saif.ccm.persistence.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.edu.saif.ccm.domain.stock.DailyInfo;
import cn.edu.saif.ccm.domain.stock.PortfolioRet;
import cn.edu.saif.ccm.domain.stock.StockRet;
import cn.edu.saif.ccm.domain.stock.ThreeFactor;

/**
 * Finance Data Dao
 *
 * @author Xiao GuangLei
 * @since 1.0
 */
public interface StockDao {
	
	public Long getCount(String hql);
	
	public List<StockRet> findStockRet(int first,int max,String hql);
		
	public List<PortfolioRet> findPortfolioRet(int first,int max,String hql);
	
	public List<DailyInfo> findDailyInfo(int first,int max,String hql);
	
	public List<DailyInfo> findDailyInfo(DetachedCriteria dc);
	
	public List<ThreeFactor> findFactor(int first,int max,String hql);

}
