package cn.edu.saif.ccm.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.saif.ccm.domain.bond.CLBondCapAppRet;
import cn.edu.saif.ccm.domain.bond.CLBondRet;
import cn.edu.saif.ccm.domain.bond.CLBondYield;
import cn.edu.saif.ccm.domain.bond.GBondCapAppRet;
import cn.edu.saif.ccm.domain.bond.GBondDesc;
import cn.edu.saif.ccm.domain.bond.GBondMat;
import cn.edu.saif.ccm.domain.bond.GBondPrc;
import cn.edu.saif.ccm.domain.bond.GBondRet;
import cn.edu.saif.ccm.service.BondService;
import cn.edu.saif.shared.common.BaseException;
import cn.edu.saif.shared.config.AppConfig;
import cn.edu.saif.shared.utils.JsonUtils;

@ContextConfiguration(classes = { AppConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@Transactional
public class BondServiceImplTest {
	
	@Autowired
	BondService bondService;
	
	@Test
	public void findGBondRetTest() throws BaseException{
	}
	
	@Test
	public void findGBondDescTest() throws BaseException{
	}
	
	@Test
	public void findGBondMatTest() throws BaseException{
	}
	
	@Test
	public void findGBondPrcTest() throws BaseException{
	}
	
	@Test
	public void findGBondCapAppRetTest() throws BaseException{
	}
	
	@Test
	public void findCLBondRetTest() throws BaseException{
	}
	
	@Test
	public void findCLBondCapAppRetTest() throws BaseException{
	}
	
	@Test
	public void findCLBondYieldTest() throws BaseException{
	}
}
