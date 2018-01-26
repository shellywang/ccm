package cn.edu.saif.ccm.service.impl;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.saif.ccm.domain.reset.ResetRequest;
import cn.edu.saif.ccm.domain.user.User;
import cn.edu.saif.ccm.persistence.dao.ResetDao;
import cn.edu.saif.ccm.persistence.dao.UserDao;
import cn.edu.saif.ccm.service.ResetService;
import cn.edu.saif.shared.common.BaseException;
import cn.edu.saif.shared.utils.EncoderHandler;

@Service
@Transactional
public class ResetServiceImpl implements ResetService{

	protected Logger log = LoggerFactory.getLogger(ResetServiceImpl.class);
	
	@Autowired
	private ResetDao resetDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	JavaMailSenderImpl sender;
	
	@Override
	public ResetRequest findById(int id) {
		return resetDao.findById(id);
	}

	@Override
	public ResetRequest findByCode(String code) {
		return resetDao.findByCode(code);
	}

	@Override
	public ResetRequest findValidByCode(String code) {
		Date date=new Date();
		return resetDao.findValidByCode(code, date);
	}
	
	@Override
	public List<ResetRequest> findAll() {
		return resetDao.findAll();
	}

	@Override
	public void add(ResetRequest resetRequest) {
		resetDao.save(resetRequest);
	}

	@Override
	public void delete(ResetRequest resetRequest) {
		
	}
	
	@Override
	public void reset(String code, String password) throws BaseException {
		ResetRequest req=resetDao.findByCode(code);
		if(req==null)
			throw new BaseException("Invalid code.");
		User user=req.getUser();
		user.setPassword(EncoderHandler.encodeByMD5(password));
		userDao.save(user);
		resetDao.delete(req);
	}
	
	@Override
	public void sendReset(String email) throws BaseException {
		User user=userDao.findUserByEmail(email);
		if(user==null)
			throw new BaseException("The email address does not exist.");
		ResetRequest req=new ResetRequest();
		Date now=new Date();
		String code=EncoderHandler.encodeByMD5(user.getUsername()+user.getEmail()+user.getPassword()+now.getTime());
		req.setCode(code);
		req.setUser(user);
		req.setExpireTime(new Date(now.getTime()+86400000L));
		sendResetLink(user,code);
		resetDao.save(req);
	}
	
	@Async
	public void sendResetLink(User user,String code){
		MimeMessage mail=sender.createMimeMessage();
		try {
			String resetLink="http://ccm.cafr.cn/resetpassword/"+code;
			MimeMessageHelper helper = new MimeMessageHelper(mail, false,"GBK");
			helper.setFrom(sender.getUsername());
			helper.setTo(user.getEmail());
			helper.setSubject("Reset your CCM account password");
			helper.setText("Dear "+user.getFullName()+",<br>"
					+"<br>The following link will take you to the CCM password reset page:<br>"
					+"<br><a href='"+resetLink+"' target='_blank'>"+resetLink+"</a><br>"
					+"<br><strong>Please note that this link will only be active for the next 24 hours.</strong><br>"
					+"<br>Let us know if there is anything further we can do for you.<br>"
					+"<br>Best Regards,<br>The CCM Staff",true);
			sender.send(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteInvalid() {
		Date date=new Date();
		resetDao.deleteInvalid(date);
	}

}
