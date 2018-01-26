package cn.edu.saif.ccm.service;

import cn.edu.saif.ccm.domain.stock.DailyInfo;
import cn.edu.saif.ccm.domain.stock.PortfolioRet;
import cn.edu.saif.ccm.domain.stock.StockRet;
import cn.edu.saif.ccm.domain.stock.ThreeFactor;
import cn.edu.saif.shared.common.BaseException;
import cn.edu.saif.shared.common.ExportDTO;
import cn.edu.saif.shared.common.Page;
import cn.edu.saif.shared.query.QueryMeta;

public interface StockService {
	
	public Page<StockRet> findStockRet(QueryMeta meta,ExportDTO result) ;
	
	public Page<PortfolioRet> findPortfolioRet(QueryMeta meta,ExportDTO result) throws BaseException;
	
	public Page<DailyInfo> findDailyInfo(QueryMeta meta,ExportDTO result) throws BaseException;
	
	public Page<ThreeFactor> findFactor(QueryMeta meta,ExportDTO result) throws BaseException;
	
}
