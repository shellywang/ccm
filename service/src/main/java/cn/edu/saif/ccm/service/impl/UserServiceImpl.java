package cn.edu.saif.ccm.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.saif.ccm.domain.dto.user.UserDTO;
import cn.edu.saif.ccm.domain.reset.ResetRequest;
import cn.edu.saif.ccm.domain.security.Role;
import cn.edu.saif.ccm.domain.user.EpUser;
import cn.edu.saif.ccm.domain.user.User;
import cn.edu.saif.ccm.persistence.dao.ResetDao;
import cn.edu.saif.ccm.persistence.dao.RoleDao;
import cn.edu.saif.ccm.persistence.dao.UserDao;
import cn.edu.saif.ccm.service.UserService;
import cn.edu.saif.shared.common.BaseException;
import cn.edu.saif.shared.utils.EncoderHandler;
import cn.edu.saif.shared.utils.IPv4Util;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	protected Logger log = LoggerFactory.getLogger(UserServiceImpl.class);  
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	ResetDao resetDao;
	
	@Autowired
	JavaMailSenderImpl sender;
	
	@Override
	public User loadUserByNameOrEmail(String arg) throws BaseException {
		User user=null;
		if(arg.contains("@"))
			user=userDao.findUserByEmail(arg);
		else
			user=userDao.findUserByName(arg);
		if(user!=null){
			if(user.getApproval()!=null)
				if(user.getApproval()==0)
					throw new BaseException("The account is being verified!");
			if(user.getExpireDate()!=null){
				Long expire=user.getExpireDate().getTime();
				Long now=new Date().getTime();
				if (now>expire)
					throw new BaseException("The account has expired!");
			}
			log.debug("Hibernate Lazy load ["+user+".roles]");
			user.getRoles().size();
		}else{
			throw new BaseException("Username or password is wrong!");
		}
		return user;
	}
	
	@Override
	public EpUser loadUserByIp(String ipAddress) throws BaseException {
		Long ipLong=IPv4Util.ip2Int(ipAddress);
		EpUser user=userDao.findUserByIp(ipLong);
		if(user!=null){
			if(user.getExpireDate()!=null){
				Long expire=user.getExpireDate().getTime();
				Long now=new Date().getTime();
				if (now>expire)
					throw new BaseException("The enterprise account has expired!");
			}
			log.debug("Hibernate Lazy load ["+user+".roles]");
			user.getRoles().size();
		}else{
			throw new BaseException("No enterprise contains ip ["+ipAddress+"]");
		}
		return user;
	}

	@Override
	public List<User> findAll() throws BaseException {
		return userDao.findAll();
	}

	@Override
	public User register(UserDTO userDTO) throws BaseException {
		checkUser(userDTO);
		User user=convert(userDTO);
		user.setApplyDate(new java.sql.Date(new Date().getTime()));
		user.setApproval(0);
		userDao.save(user);
		return user;
	}
	
	@Override
	public List<User> findAudit() throws BaseException {
		return userDao.findAudit();
	}

	@Override
	public List<User> findActive() throws BaseException {
		java.sql.Date exDate=new java.sql.Date(new Date().getTime());
		return userDao.findActive(exDate);
	}

	@Override
	public List<User> findExpired() throws BaseException {
		java.sql.Date exDate=new java.sql.Date(new Date().getTime());
		return userDao.findExpired(exDate);
	}

	@Override
	public User approval(int userId,java.sql.Date expireDate) throws BaseException {
		List<Role> dRoles =roleDao.findDefault();
		Set<Role> roles=new HashSet<Role>();
		for(Role role:dRoles){
			roles.add(role);
		}
		Role iRole=roleDao.findByName("ROLE_IUSER");
		roles.add(iRole);
		User user=userDao.findUserById(userId);
		user.setApproval(1);
		user.setExpireDate(expireDate);
		user.setRoles(roles);
		userDao.save(user);
		return user;
	}
	
	@Override
	public void deny(int userId) throws BaseException {
		User user=userDao.findUserById(userId);
		if(user!=null)
			userDao.remove(user);
	}
	
	@Override
	public void validate(int userId,java.sql.Date expireDate) throws BaseException {
		User user=userDao.findUserById(userId);
		if(user!=null)
			user.setExpireDate(expireDate);
		userDao.save(user);
	}
	
	@Override
	public List<EpUser> findEpActive() throws BaseException {
		java.sql.Date exDate=new java.sql.Date(new Date().getTime());
		return userDao.findEpActive(exDate);
	}

	@Override
	public List<EpUser> findEpExpired() throws BaseException {
		java.sql.Date expDate=new java.sql.Date(new Date().getTime());
		return userDao.findEpExpired(expDate);
	}

	@Override
	public void epValidate(int userId,java.sql.Date expireDate) throws BaseException {
		EpUser user=userDao.findEpUserById(userId);
		if(user!=null)
			user.setExpireDate(expireDate);
		userDao.save(user);
	}

	@Override
	public void add(UserDTO userDTO) throws BaseException {
		checkUser(userDTO);
		User user=convert(userDTO);
		List<Role> dRoles =roleDao.findDefault();
		Set<Role> roles=new HashSet<Role>();
		for(Role role:dRoles){
			roles.add(role);
		}
		Role iRole=roleDao.findByName("ROLE_IUSER");
		roles.add(iRole);
		
		user.setApproval(1);
		user.setRoles(roles);
		userDao.save(user);
	}
	
	@Override
	public void add(EpUser epUser) throws BaseException {
		checkEpUser(epUser);
		List<Role> dRoles =roleDao.findDefault();
		Set<Role> roles=new HashSet<Role>();
		for(Role role:dRoles){
			roles.add(role);
		}
		Role eRole=roleDao.findByName("ROLE_EUSER");
		roles.add(eRole);
		
		epUser.setRoles(roles);
		userDao.save(epUser);
	}
	
	@Override
	public boolean isUsernameExists(String username) {
		User user=userDao.findUserByName(username);
		if(user!=null)
			return true;
		else
			return false;
	}

	@Override
	public boolean isEmailExists(String email) {
		User user=userDao.findUserByEmail(email);
		if(user!=null)
			return true;
		else
			return false;
	}

	@Override
	public void changePwd(String username, String password, String newPassword)
			throws BaseException {
		User user=userDao.findUserByNamePwd(username, password);
		if(user==null) {
			throw new BaseException("Old password is incorrect!");
		}else {
			user.setPassword(newPassword);
			userDao.update(user);
		}
	}

	@Override
	public void changeRole(int userId, List<Integer> idList)
			throws BaseException {
		User user=userDao.findUserById(userId);
		Set<Role> roles=user.getRoles();
		Iterator<Role> iter=roles.iterator();
		while(iter.hasNext()){
			int roleId=iter.next().getId();
			boolean isDetele=true;
			for(int j=0;j<idList.size();j++){
				if(roleId==idList.get(j)){
					idList.remove(j);
					isDetele=false;
				}
			}
			if(isDetele){
				iter.remove();
			}
		}
		for(int roleId:idList){ //找到要添加的role
			Role role=roleDao.findById(roleId);
			if(role!=null){
				roles.add(role);
			}
		}
		userDao.update(user);
	}
	
	@Override
	public void changeEpRole(int userId, List<Integer> idList)
			throws BaseException {
		EpUser user=userDao.findEpUserById(userId);
		Set<Role> roles=user.getRoles();
		Iterator<Role> iter=roles.iterator();
		while(iter.hasNext()){
			int roleId=iter.next().getId();
			boolean isDetele=true;
			for(int j=0;j<idList.size();j++){
				if(roleId==idList.get(j)){
					idList.remove(j);
					isDetele=false;
				}
			}
			if(isDetele){
				iter.remove();
			}
		}
		for(int roleId:idList){ //找到要添加的role
			Role role=roleDao.findById(roleId);
			if(role!=null){
				roles.add(role);
			}
		}
		userDao.update(user);
	}
	
	@Override
	public User details(int id) throws BaseException {
		User user=userDao.findUserById(id);
		if(user!=null)
			user.getRoles().size();
		return user;
	}
	
	@Override
	public EpUser epDetails(int id) throws BaseException {
		EpUser user=userDao.findEpUserById(id);
		if(user!=null)
			user.getRoles().size();
		return user;
	}
	
	private User convert(UserDTO userDTO){
		User user=new User();
		user.setUsername(userDTO.getUserName());
		user.setPassword(EncoderHandler.encodeByMD5(userDTO.getPwd()));
		user.setEmail(userDTO.getEmail());
		user.setFullName(userDTO.getFullName());
		user.setInstitution(userDTO.getInst());
		user.setUserType(userDTO.getUserType());
		user.setExpireDate(userDTO.getExpireDate());
		return user;
	}
	
	public void checkUser(UserDTO userDTO) throws BaseException{
		if(StringUtils.isBlank(userDTO.getUserName()))
			throw new BaseException("Username can not be null!");
		if(StringUtils.isBlank(userDTO.getPwd()))
			throw new BaseException("Password can not be null!");
		if(StringUtils.isBlank(userDTO.getEmail()))
			throw new BaseException("Email can not be null!");
		if(!isEmail(userDTO.getEmail()))
			throw new BaseException("Invalid email format!");
		User user=userDao.findUserByName(userDTO.getUserName());
		if(user!=null)
			throw new BaseException("Username already exists!");
		user=userDao.findUserByEmail(userDTO.getEmail());
		if(user!=null)
			throw new BaseException("Email already exists!");
	}
	
	private void checkEpUser(EpUser epUser) throws BaseException{
		if(StringUtils.isBlank(epUser.getName()))
			throw new BaseException("Enterprise name can not be null!");
		if(StringUtils.isBlank(epUser.getFullName()))
			throw new BaseException("Enterprise full name can not be null!");
		if(StringUtils.isBlank(epUser.getIpStart()))
			throw new BaseException("Start ip can not be null!");
		if(!IPv4Util.isValid(epUser.getIpStart()))
			throw new BaseException("Invalid start ip address!");
		if(StringUtils.isBlank(epUser.getIpEnd()))
			throw new BaseException("End ip can not be null!");
		if(!IPv4Util.isValid(epUser.getIpEnd()))
			throw new BaseException("Invalid end ip address!");
		EpUser user=userDao.findEpUserByName(epUser.getName());
		if(user!=null)
			throw new BaseException("Enterprise name already exists!");
		user=userDao.findEpUserByFullName(epUser.getFullName());
		if(user!=null)
			throw new BaseException("Enterprise full name already exists!");
		user=userDao.findUserByIp(IPv4Util.ip2Int(epUser.getIpStart()));
		if(user!=null)
			throw new BaseException("Start ip already exists!");
		user=userDao.findUserByIp(IPv4Util.ip2Int(epUser.getIpEnd()));
		if(user!=null)
			throw new BaseException("End ip already exists!");
	}
	
	@Async
	@Override
	public void sendRegister(User user){
		MimeMessage mail=sender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mail, true,"GBK");
			helper.setFrom(sender.getUsername());
			helper.setTo(sender.getUsername());
			helper.setSubject("New CCM "+user.getUserType() +" Account Request");
			helper.setText("A user has requested a new account. Please login to CCM, go to "
					+"<a href='http://ccm.cafr.cn/' target='_blank'>http://ccm.cafr.cn/</a> to approve or deny the latest account request.<br>"
					+"<br>Once approved, the user will have access to CCM.<br>"
					+"<br>User information:"
					+"<br><strong>Fullname:</strong> "+user.getFullName()
					+"<br><strong>User type:</strong> "+user.getUserType()
					+"<br><strong>Username:</strong> "+user.getEmail()
					+"<br><strong>Institution:</strong> "+user.getInstitution()
					+"<br><strong>Email:</strong> <a href='mailto:"
					+user.getEmail()+"'>"+user.getEmail()+"</a>",true);
			sender.send(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Async
	@Override
	public void sendApproval(User user){
		MimeMessage mail=sender.createMimeMessage();
		try {
			ResetRequest req=new ResetRequest();
			Date now=new Date();
			String code=EncoderHandler.encodeByMD5(user.getUsername()+user.getEmail()+user.getPassword()+now.getTime());
			req.setCode(code);
			req.setUser(user);
			req.setExpireTime(new Date(now.getTime()+86400000L));
			
			String resetLink="http://ccm.cafr.cn/resetpassword/"+code;
			MimeMessageHelper helper = new MimeMessageHelper(mail, false,"GBK");
			helper.setFrom(sender.getUsername());
			helper.setTo(user.getEmail());
			helper.setSubject("Welcome to the Chinese Capital Market");
			helper.setText("Dear "+user.getFullName()+",<br><br>"
					+"Your CCM Account has just been approved.<br>"
					+"<br>Username: "+user.getUsername()+"<br>"
					+"<br>You can visit the following link to set a new password if you forget the old one.<br>"
					+"<br><a href='"+resetLink+"' target='_blank'>"+resetLink+"</a><br>"
					+"<br><strong>Please note that this link will only be active for the next 24 hours.</strong><br>"
					+"<br>Best Regards,<br>The CCM Staff",true);
			resetDao.save(req);
			sender.send(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User findByName(String username) throws BaseException {
		return userDao.findUserByName(username);
	}

	@Override
	public EpUser findEpById(int id) throws BaseException {
		return userDao.findEpUserById(id);
	}
	
	@Override
	public void deleteUser(int userId) throws BaseException {
		User user=userDao.findUserById(userId);
		if(user!=null)
			userDao.remove(user);
	}
	
	@Override
	public void deleteEpUser(int userId) throws BaseException {
		EpUser user=userDao.findEpUserById(userId);
		if(user!=null)
			userDao.remove(user);
	}
	
	private boolean isEmail(String email) { 
	     boolean tag = true; 
	     final String pattern1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"; 
	     final Pattern pattern = Pattern.compile(pattern1); 
	     final Matcher mat = pattern.matcher(email); 
	     if (!mat.find()) { 
	         tag = false; 
	     }
	     return tag; 
	}

}
