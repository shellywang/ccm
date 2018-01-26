package cn.edu.saif.ccm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.saif.ccm.domain.bond.CLBondCapAppRet;
import cn.edu.saif.ccm.domain.bond.CLBondRet;
import cn.edu.saif.ccm.domain.bond.CLBondYield;
import cn.edu.saif.ccm.domain.bond.GBondCapAppRet;
import cn.edu.saif.ccm.domain.bond.GBondDesc;
import cn.edu.saif.ccm.domain.bond.GBondMat;
import cn.edu.saif.ccm.domain.bond.GBondPrc;
import cn.edu.saif.ccm.domain.bond.GBondRet;
import cn.edu.saif.ccm.domain.stock.StockRet;
import cn.edu.saif.ccm.persistence.dao.BondDao;
import cn.edu.saif.ccm.service.BondService;
import cn.edu.saif.ccm.service.LogService;
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
public class BondServiceImpl implements BondService{
	
	@Autowired
	LogService logService;
	
	@Autowired
	BondDao bondDao;
	
	@Override
	public Page<GBondRet> findGBondRet(QueryMeta meta,ExportDTO result) throws BaseException {
		result.setTime(new Date());
		result.setClazz(GBondRet.class);
		Long start=System.currentTimeMillis();
		Page<GBondRet> page=null;
		Pageable pageable=new Pageable();
		try{
			String hql=HqlUitls.getQueryHql(meta, GBondRet.class);
			Long totalSize=bondDao.getCount("SELECT COUNT(*) "+hql);
			
			pageable.setPageSize(meta.getPageSize());
			pageable.setPageNumber(meta.getPageNow());
			pageable.setTotalSize(bondDao.getCount("SELECT COUNT(*) "+hql).intValue());
			
			result.setRecodCount(totalSize);
			List<GBondRet> data=bondDao.findGBondRet(meta.getFirstIndex(),meta.getPageSize(),hql);
			page=new Page<GBondRet>(data,pageable);
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

	@Override
	public Page<GBondDesc> findGBondDesc(QueryMeta meta,ExportDTO result) throws BaseException {
		result.setTime(new Date());
		result.setClazz(GBondDesc.class);
		Long start=System.currentTimeMillis();
		Page<GBondDesc> page=null;
		Pageable pageable=new Pageable();
		try{
			String hql=HqlUitls.getQueryHql(meta, GBondDesc.class);
			Long totalSize=bondDao.getCount("SELECT COUNT(*) "+hql);
			
			pageable.setPageSize(meta.getPageSize());
			pageable.setPageNumber(meta.getPageNow());
			pageable.setTotalSize(bondDao.getCount("SELECT COUNT(*) "+hql).intValue());
			
			result.setRecodCount(totalSize);
			List<GBondDesc> data=bondDao.findGBondDesc(meta.getFirstIndex(),meta.getPageSize(),hql);
			page=new Page<GBondDesc>(data,pageable);
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

	@Override
	public Page<GBondMat> findGBondMat(QueryMeta meta,ExportDTO result) throws BaseException {
		result.setTime(new Date());
		result.setClazz(GBondMat.class);
		Long start=System.currentTimeMillis();
		Page<GBondMat> page=null;
		Pageable pageable=new Pageable();
		try{
			String hql=HqlUitls.getQueryHql(meta, GBondMat.class);
			Long totalSize=bondDao.getCount("SELECT COUNT(*) "+hql);
			
			pageable.setPageSize(meta.getPageSize());
			pageable.setPageNumber(meta.getPageNow());
			pageable.setTotalSize(bondDao.getCount("SELECT COUNT(*) "+hql).intValue());
			
			result.setRecodCount(totalSize);
			List<GBondMat> data=bondDao.findGBondMat(meta.getFirstIndex(),meta.getPageSize(),hql);
			page=new Page<GBondMat>(data,pageable);
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

	@Override
	public Page<GBondPrc> findGBondPrc(QueryMeta meta,ExportDTO result) throws BaseException {
		result.setTime(new Date());
		result.setClazz(GBondPrc.class);
		Long start=System.currentTimeMillis();
		Page<GBondPrc> page=null;
		Pageable pageable=new Pageable();
		try{
			String hql=HqlUitls.getQueryHql(meta, GBondPrc.class);
			Long totalSize=bondDao.getCount("SELECT COUNT(*) "+hql);
			
			pageable.setPageSize(meta.getPageSize());
			pageable.setPageNumber(meta.getPageNow());
			pageable.setTotalSize(bondDao.getCount("SELECT COUNT(*) "+hql).intValue());
			
			result.setRecodCount(totalSize);
			List<GBondPrc> data=bondDao.findGBondPrc(meta.getFirstIndex(),meta.getPageSize(),hql);
			page=new Page<GBondPrc>(data,pageable);
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

	@Override
	public Page<GBondCapAppRet> findGBondCapAppRet(QueryMeta meta,ExportDTO result) throws BaseException {
		result.setTime(new Date());
		result.setClazz(GBondCapAppRet.class);
		Long start=System.currentTimeMillis();
		Page<GBondCapAppRet> page=null;
		Pageable pageable=new Pageable();
		try{
			String hql=HqlUitls.getQueryHql(meta, GBondCapAppRet.class);
			Long totalSize=bondDao.getCount("SELECT COUNT(*) "+hql);
			
			pageable.setPageSize(meta.getPageSize());
			pageable.setPageNumber(meta.getPageNow());
			pageable.setTotalSize(bondDao.getCount("SELECT COUNT(*) "+hql).intValue());
			
			result.setRecodCount(totalSize);
			List<GBondCapAppRet> data=bondDao.findGBondCapAppRet(meta.getFirstIndex(),meta.getPageSize(),hql);
			page=new Page<GBondCapAppRet>(data,pageable);
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

	@Override
	public Page<CLBondRet> findCLBondRet(QueryMeta meta,ExportDTO result) throws BaseException {
		result.setTime(new Date());
		result.setClazz(CLBondRet.class);
		Long start=System.currentTimeMillis();
		Page<CLBondRet> page=null;
		Pageable pageable=new Pageable();
		try{
			String hql=HqlUitls.getQueryHql(meta, CLBondRet.class);
			Long totalSize=bondDao.getCount("SELECT COUNT(*) "+hql);
			
			pageable.setPageSize(meta.getPageSize());
			pageable.setPageNumber(meta.getPageNow());
			pageable.setTotalSize(bondDao.getCount("SELECT COUNT(*) "+hql).intValue());
			
			result.setRecodCount(totalSize);
			List<CLBondRet> data=bondDao.findCLBondRet(meta.getFirstIndex(),meta.getPageSize(),hql);
			page=new Page<CLBondRet>(data,pageable);
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

	@Override
	public Page<CLBondCapAppRet> findCLBondCapAppRet(QueryMeta meta,ExportDTO result) throws BaseException {
		result.setTime(new Date());
		result.setClazz(CLBondCapAppRet.class);
		Long start=System.currentTimeMillis();
		Page<CLBondCapAppRet> page=null;
		Pageable pageable=new Pageable();
		try{
			String hql=HqlUitls.getQueryHql(meta, CLBondCapAppRet.class);
			Long totalSize=bondDao.getCount("SELECT COUNT(*) "+hql);
			
			pageable.setPageSize(meta.getPageSize());
			pageable.setPageNumber(meta.getPageNow());
			pageable.setTotalSize(bondDao.getCount("SELECT COUNT(*) "+hql).intValue());
			
			result.setRecodCount(totalSize);
			List<CLBondCapAppRet> data=bondDao.findCLBondCapAppRet(meta.getFirstIndex(),meta.getPageSize(),hql);
			page=new Page<CLBondCapAppRet>(data,pageable);
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

	@Override
	public Page<CLBondYield> findCLBondYield(QueryMeta meta ,ExportDTO result) throws BaseException {
		result.setTime(new Date());
		result.setClazz(CLBondYield.class);
		Long start=System.currentTimeMillis();
		Page<CLBondYield> page=null;
		Pageable pageable=new Pageable();
		try{
			String hql=HqlUitls.getQueryHql(meta, CLBondYield.class);
			Long totalSize=bondDao.getCount("SELECT COUNT(*) "+hql);
			
			pageable.setPageSize(meta.getPageSize());
			pageable.setPageNumber(meta.getPageNow());
			pageable.setTotalSize(bondDao.getCount("SELECT COUNT(*) "+hql).intValue());
			
			result.setRecodCount(totalSize);
			List<CLBondYield> data=bondDao.findCLBondYield(meta.getFirstIndex(),meta.getPageSize(),hql);
			page=new Page<CLBondYield>(data,pageable);
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
