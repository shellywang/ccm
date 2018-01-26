package cn.edu.saif.ccm.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.saif.ccm.domain.log.EpUserDLog;
import cn.edu.saif.ccm.domain.log.EpUserLog;
import cn.edu.saif.ccm.domain.log.EpUserQLog;
import cn.edu.saif.ccm.domain.log.UserDLog;
import cn.edu.saif.ccm.domain.log.UserLog;
import cn.edu.saif.ccm.domain.log.UserQLog;
import cn.edu.saif.ccm.domain.user.EpUser;
import cn.edu.saif.ccm.domain.user.User;
import cn.edu.saif.ccm.persistence.dao.LogDao;
import cn.edu.saif.ccm.service.LogService;
import cn.edu.saif.shared.common.ExportDTO;
import cn.edu.saif.shared.query.MyUser;
import cn.edu.saif.shared.query.QueryMeta;
import cn.edu.saif.shared.utils.SpringSecurityUtil;

@Service
@Transactional
public class LogServiceImpl implements LogService {
	
	@Autowired
	LogDao logDao;
	
	@Override
	public UserLog findById(int id) {
		return logDao.findById(id);
	}

	@Override
	public UserLog findByUserId(int userId) {
		return logDao.findByUserId(userId);
	}

	@Override
	public List<UserLog> findAll(int first, int max) {
		return logDao.findAll(first, max);
	}

	@Override
	public List<EpUserLog> findEpAll(int first, int max) {
		return logDao.findEpAll(first, max);
	}
	
	@Override
	public List<UserDLog> findDownLoadAll(int first, int max) {
		return logDao.findDAll(first, max);
	}

	@Override
	public List<EpUserDLog> findEpDownLoadAll(int first, int max) {
		return logDao.findEpDAll(first, max);
	}
	
	@Async
	@Override
	public void saveUserLog(int userId, String ipAddress) {
		UserLog log=logDao.findByUserId(userId);
		if(log==null) {
			log=new UserLog();
			log.setLastLoginTime(new Date());
			User user=new User();
			user.setId(userId);
			
			log.setUser(user);
			log.setLoginCount(1);
			log.setLastLoginIp(ipAddress);
			logDao.save(log);
		}else{
			log.setLastLoginTime(new Date());
			log.setLoginCount(log.getLoginCount()+1);
			log.setLastLoginIp(ipAddress);
			logDao.update(log);
		}
	}

	@Async
	@Override
	public void saveEpUserLog(int userId, String ipAddress) {
		EpUserLog log=logDao.findEpByUserId(userId);
		if(log==null) {
			log=new EpUserLog();
			log.setLastLoginTime(new Date());
			EpUser user=new EpUser();
			user.setId(userId);
			
			log.setUser(user);
			log.setLoginCount(1);
			log.setLastLoginIp(ipAddress);
			logDao.save(log);
		}else{
			log.setLastLoginTime(new Date());
			log.setLoginCount(log.getLoginCount()+1);
			log.setLastLoginIp(ipAddress);
			logDao.update(log);
		}
	}

	@Async
	@Override
	public void saveUserDLog(int userId,QueryMeta meta, ExportDTO result) {
		String tableName=result.getClazz().getAnnotation(Table.class).name();
		UserDLog log=new UserDLog();

		if(result.getCode().equals("success")){
			log.setStatus(true);
		}
		
		User user=new User();
		user.setId(userId);
		
		log.setUser(user);
		log.setTime(result.getTime());
		log.setBelong(tableName);
		log.setFileSize(result.getFileSize());
		log.setRunTime(result.getRunTime());
		log.setRecordCount(result.getRecodCount());
		
		logDao.save(log);
	}
	
	@Async
	@Override
	public void saveEpUserDLog(int userId, QueryMeta meta, ExportDTO result) {
		String tableName=result.getClazz().getAnnotation(Table.class).name();
		EpUserDLog log=new EpUserDLog();

		if(result.getCode().equals("success")){
			log.setStatus(true);
		}
		
		EpUser user=new EpUser();
		user.setId(userId);
		
		log.setUser(user);
		log.setTime(result.getTime());
		log.setBelong(tableName);
		log.setFileSize(result.getFileSize());
		log.setRunTime(result.getRunTime());
		log.setRecordCount(result.getRecodCount());
		
		logDao.save(log);
	}

	@Override
	public List<UserQLog> findQueryAll(int first, int max) {
		return logDao.findQAll(first, max);
	}

	@Override
	public List<EpUserQLog> findEpQueryAll(int first, int max) {
		return logDao.findEpQAll(first, max);
	}
	
	@Async
	@Override
	public void saveUserQLog(int userId, QueryMeta meta, ExportDTO result) {
		String tableName=result.getClazz().getAnnotation(Table.class).name();
		UserQLog log=new UserQLog();
		log.setTime(result.getTime());
		if(result.getCode().equals("success")){
			log.setStatus(true);
		}
		
		User user=new User();
		user.setId(userId);
		
		log.setUser(user);
		log.setBelong(tableName);
		log.setRunTime(result.getRunTime());
		log.setRecordCount(result.getRecodCount());
		
		logDao.save(log);
	}

	@Async
	@Override
	public void saveEpUserQLog(int userId, QueryMeta meta, ExportDTO result) {
		String tableName=result.getClazz().getAnnotation(Table.class).name();
		EpUserQLog log=new EpUserQLog();
		log.setTime(result.getTime());
		if(result.getCode().equals("success")){
			log.setStatus(true);
		}
		
		EpUser user=new EpUser();
		user.setId(userId);
		
		log.setUser(user);
		log.setBelong(tableName);
		log.setRunTime(result.getRunTime());
		log.setRecordCount(result.getRecodCount());
		
		logDao.save(log);
	}

}
