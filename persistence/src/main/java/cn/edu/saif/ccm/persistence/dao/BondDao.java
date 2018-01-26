package cn.edu.saif.ccm.persistence.dao;

import java.util.List;

import cn.edu.saif.ccm.domain.bond.CLBondCapAppRet;
import cn.edu.saif.ccm.domain.bond.CLBondRet;
import cn.edu.saif.ccm.domain.bond.CLBondYield;
import cn.edu.saif.ccm.domain.bond.GBondCapAppRet;
import cn.edu.saif.ccm.domain.bond.GBondDesc;
import cn.edu.saif.ccm.domain.bond.GBondMat;
import cn.edu.saif.ccm.domain.bond.GBondPrc;
import cn.edu.saif.ccm.domain.bond.GBondRet;

public interface BondDao {
	
	public Long getCount(String hql);
	
	public List<GBondRet> findGBondRet(int first,int max,String hql);
	
	public List<GBondCapAppRet> findGBondCapAppRet(int first,int max,String hql);
	
	public List<GBondDesc> findGBondDesc(int first,int max,String hql);
	
	public List<GBondMat> findGBondMat(int first,int max,String hql);
	
	public List<GBondPrc> findGBondPrc(int first,int max,String hql);
	
	public List<CLBondRet> findCLBondRet(int first,int max,String hql);
	
	public List<CLBondCapAppRet> findCLBondCapAppRet(int first,int max,String hql);
	
	public List<CLBondYield> findCLBondYield(int first,int max,String hql);
}
