package cn.edu.saif.ccm.service;

import cn.edu.saif.ccm.domain.bond.CLBondCapAppRet;
import cn.edu.saif.ccm.domain.bond.CLBondRet;
import cn.edu.saif.ccm.domain.bond.CLBondYield;
import cn.edu.saif.ccm.domain.bond.GBondCapAppRet;
import cn.edu.saif.ccm.domain.bond.GBondDesc;
import cn.edu.saif.ccm.domain.bond.GBondMat;
import cn.edu.saif.ccm.domain.bond.GBondPrc;
import cn.edu.saif.ccm.domain.bond.GBondRet;
import cn.edu.saif.shared.common.BaseException;
import cn.edu.saif.shared.common.ExportDTO;
import cn.edu.saif.shared.common.Page;
import cn.edu.saif.shared.query.QueryMeta;

public interface BondService {
	
	public Page<GBondRet> findGBondRet(QueryMeta meta,ExportDTO result) throws BaseException;
	
	public Page<GBondCapAppRet> findGBondCapAppRet(QueryMeta meta,ExportDTO result) throws BaseException;
	
	public Page<GBondDesc> findGBondDesc(QueryMeta meta,ExportDTO result) throws BaseException;
	
	public Page<GBondMat> findGBondMat(QueryMeta meta,ExportDTO result) throws BaseException;
	
	public Page<GBondPrc> findGBondPrc(QueryMeta meta,ExportDTO result) throws BaseException;
	
	public Page<CLBondRet> findCLBondRet(QueryMeta meta,ExportDTO result) throws BaseException;
	
	public Page<CLBondCapAppRet> findCLBondCapAppRet(QueryMeta meta,ExportDTO result) throws BaseException;
	
	public Page<CLBondYield> findCLBondYield(QueryMeta meta,ExportDTO result) throws BaseException;
}
