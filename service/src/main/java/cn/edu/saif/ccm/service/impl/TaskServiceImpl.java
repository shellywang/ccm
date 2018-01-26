package cn.edu.saif.ccm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import cn.edu.saif.ccm.service.FtpService;
import cn.edu.saif.ccm.service.ResetService;
import cn.edu.saif.ccm.service.TaskService;
import cn.edu.saif.ccm.service.UserService;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	ResetService resetService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	FtpService ftpService;
	
	@Scheduled(cron="1 0 0 ? * *") //每天0时0分1秒执行
	@Override
	public void deleteInvalidResetLink() {
		System.out.println("-----Start task: delete expired reset link------");
		resetService.deleteInvalid();
	}

	@Scheduled(cron="0 30 0 20 * ?") //每月20日上午0:30触发
	@Override
	public void downloadCCMData() {
		System.out.println("-----Start task: download ccm data ------");
		ftpService.download();
	}

}
