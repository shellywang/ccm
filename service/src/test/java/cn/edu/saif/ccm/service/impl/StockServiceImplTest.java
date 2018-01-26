package cn.edu.saif.ccm.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.saif.ccm.domain.stock.DailyInfo;
import cn.edu.saif.ccm.domain.stock.PortfolioRet;
import cn.edu.saif.ccm.domain.stock.StockRet;
import cn.edu.saif.ccm.domain.user.EpUser;
import cn.edu.saif.ccm.service.StockService;
import cn.edu.saif.ccm.service.UserService;
import cn.edu.saif.shared.common.BaseException;
import cn.edu.saif.shared.config.AppConfig;
import cn.edu.saif.shared.query.QueryMeta;
import cn.edu.saif.shared.utils.JsonUtils;

@ContextConfiguration(classes = { AppConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@Transactional(readOnly=true)
public class StockServiceImplTest {
	
	@Autowired
	StockService stockService;
	
	@Test
	public void findDailyInfoTest() throws BaseException{
	}
	
	@Test
	public void findDailyInfoTest2() throws BaseException{
	}
	
	@Test
	public void findStockRetTest() throws BaseException{
	}
	
	@Test
	public void findPortfolioRetTest() throws BaseException{
		
	}
}
