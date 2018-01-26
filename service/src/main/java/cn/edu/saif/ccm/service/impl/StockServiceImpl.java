package cn.edu.saif.ccm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import cn.edu.saif.ccm.domain.stock.DailyInfo;
import cn.edu.saif.ccm.domain.stock.PortfolioRet;
import cn.edu.saif.ccm.domain.stock.StockRet;
import cn.edu.saif.ccm.domain.stock.ThreeFactor;
import cn.edu.saif.ccm.persistence.dao.StockDao;
import cn.edu.saif.ccm.service.LogService;
import cn.edu.saif.ccm.service.StockService;
import cn.edu.saif.shared.common.BaseException;
import cn.edu.saif.shared.common.Constants;
import cn.edu.saif.shared.common.ExportDTO;
import cn.edu.saif.shared.common.Page;
import cn.edu.saif.shared.common.Pageable;
import cn.edu.saif.shared.query.MyUser;
import cn.edu.saif.shared.query.QueryMeta;
import cn.edu.saif.shared.utils.HqlUitls;
import cn.edu.saif.shared.utils.SpringSecurityUtil;

@Service
public class StockServiceImpl implements StockService {
	
	@Autowired
	LogService logService;
	
	@Autowired
	StockDao stockDao;
	
	@Override
	public Page<StockRet> findStockRet(QueryMeta meta,ExportDTO result) {
		result.setTime(new Date());
		result.setClazz(StockRet.class);
		Long start=System.currentTimeMillis();
		Page<StockRet> page=null;
		Pageable pageable=new Pageable();
		try {
			String hql=HqlUitls.getQueryHql(meta,StockRet.class);
			Long totalSize=stockDao.getCount("SELECT COUNT(*) "+hql);
			
			pageable.setPageSize(meta.getPageSize());
			pageable.setPageNumber(meta.getPageNow());
			pageable.setTotalSize(totalSize.intValue());
			
			result.setRecodCount(totalSize);
			List<StockRet> data=stockDao.findStockRet(meta.getFirstIndex(),meta.getPageSize(),hql);
			page=new Page<StockRet>(data,pageable);
			
			result.setCode(Constants.CODE_SUCCESS);
		} catch (Exception e) {
			result.setCode(Constants.CODE_FAIL);
			result.setMsg(e.getMessage());
		}
		Long end=System.currentTimeMillis();
		result.setRunTime(end-start);
		saveQueryLog(meta, result);
		return page;
	}

	@Override
	public Page<PortfolioRet> findPortfolioRet(QueryMeta meta,ExportDTO result) throws BaseException {
		result.setTime(new Date());
		result.setClazz(PortfolioRet.class);
		Long start=System.currentTimeMillis();
		Page<PortfolioRet> page=null;
		try {
			String hql=HqlUitls.getQueryHql(meta,PortfolioRet.class);
			Long totalSize=stockDao.getCount("SELECT COUNT(*) "+hql);
			
			Pageable pageable=new Pageable();
			pageable.setPageSize(meta.getPageSize());
			pageable.setPageNumber(meta.getPageNow());
			pageable.setTotalSize(totalSize.intValue());
			
			result.setRecodCount(totalSize);
			List<PortfolioRet> data=stockDao.findPortfolioRet(meta.getFirstIndex(),meta.getPageSize(),hql);
			page=new Page<PortfolioRet>(data,pageable);
			
			result.setCode(Constants.CODE_SUCCESS);
		} catch (Exception e) {
			result.setCode(Constants.CODE_FAIL);
			result.setMsg(e.getMessage());
		} 
		Long end=System.currentTimeMillis();
		result.setRunTime(end-start);
		saveQueryLog(meta, result);
		return page;
	}

	@Override
	public Page<DailyInfo> findDailyInfo(QueryMeta meta,ExportDTO result) throws BaseException {
		result.setTime(new Date());
		result.setClazz(DailyInfo.class);
		Long start=System.currentTimeMillis();
		Page<DailyInfo> page=null;
		try {
			String hql=HqlUitls.getQueryHql(meta,DailyInfo.class);
			Long totalSize=stockDao.getCount("SELECT COUNT(*) "+hql);
			
			Pageable pageable=new Pageable();
			pageable.setPageSize(meta.getPageSize());
			pageable.setPageNumber(meta.getPageNow());
			pageable.setTotalSize(totalSize.intValue());
			
			result.setRecodCount(totalSize);
			List<DailyInfo> data=stockDao.findDailyInfo(meta.getFirstIndex(),meta.getPageSize(),hql);
			page=new Page<DailyInfo>(data,pageable);
			
			result.setCode(Constants.CODE_SUCCESS);
		} catch (Exception e) {
			result.setCode(Constants.CODE_FAIL);
			result.setMsg(e.getMessage());
		} 
		Long end=System.currentTimeMillis();
		result.setRunTime(end-start);
		saveQueryLog(meta, result);
		return page;
	}
	
	@Override
	public Page<ThreeFactor> findFactor(QueryMeta meta,ExportDTO result) throws BaseException {
		result.setTime(new Date());
		result.setClazz(ThreeFactor.class);
		Long start=System.currentTimeMillis();
		Page<ThreeFactor> page=null;
		try{
			String hql=HqlUitls.getQueryHql(meta, ThreeFactor.class);
			Long totalSize=stockDao.getCount("SELECT COUNT(*) "+hql);
			
			Pageable pageable=new Pageable();
			pageable.setPageSize(meta.getPageSize());
			pageable.setPageNumber(meta.getPageNow());
			pageable.setTotalSize(totalSize.intValue());
			
			result.setRecodCount(totalSize);
			List<ThreeFactor> data=stockDao.findFactor(meta.getFirstIndex(),meta.getPageSize(),hql);
			page=new Page<ThreeFactor>(data,pageable);
			
			result.setCode(Constants.CODE_SUCCESS);
		}catch(Exception e){
			result.setCode(Constants.CODE_FAIL);
			result.setMsg(e.getMessage());
		} 
		Long end=System.currentTimeMillis();
		result.setRunTime(end-start);
		saveQueryLog(meta, result);
		return page;
	}
	
	private void saveQueryLog(QueryMeta meta,ExportDTO result) {
		if(meta.isFirst()){
			MyUser user=SpringSecurityUtil.getUserDetails();
			if(user.getLoginType().equals("1")){
				logService.saveUserQLog(user.getUserId(),meta,result);
			}else{
				logService.saveEpUserQLog(user.getUserId(),meta,result);
			}
		}
	}
}
