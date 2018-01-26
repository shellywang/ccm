package cn.edu.saif.ccm.service;

import java.util.List;

import cn.edu.saif.ccm.domain.dto.user.UserDTO;
import cn.edu.saif.ccm.domain.user.EpUser;
import cn.edu.saif.ccm.domain.user.User;
import cn.edu.saif.shared.common.BaseException;

public interface UserService {
	
	public User loadUserByNameOrEmail(String arg) throws BaseException;
	
	public EpUser loadUserByIp(String ipAddress) throws BaseException;
	
	public User details(int id) throws BaseException;
	
	public boolean isUsernameExists(String username);
	
	public boolean isEmailExists(String username);
	
	public User register(UserDTO userDTO) throws BaseException;
	
	public void sendRegister(User user) throws BaseException;
	
	public void changePwd(String username,String password,String newPassword) throws BaseException;
	
	public void changeRole(int userId,List<Integer> idList) throws BaseException;
	
	public void changeEpRole(int userId,List<Integer> idList) throws BaseException;
	
	public void add(UserDTO userDTO) throws BaseException;
	
	public void add(EpUser epUser) throws BaseException;
	
	public EpUser epDetails(int id) throws BaseException;
	
	public User findByName(String username) throws BaseException;
	
	public EpUser findEpById(int id) throws BaseException;
	
	public List<User> findAudit() throws BaseException;
	
	public List<User> findActive() throws BaseException;
	
	public List<EpUser> findEpActive() throws BaseException;
	
	public List<User> findExpired() throws BaseException;
	
	public List<EpUser> findEpExpired() throws BaseException;
	
	public List<User> findAll() throws BaseException;
	
	public User approval(int userId,java.sql.Date expireDate) throws BaseException;
	
	public void sendApproval(User user) throws BaseException;
	
	public void deny(int userId) throws BaseException;
	
	public void validate(int userId,java.sql.Date expireDate) throws BaseException;
	
	public void epValidate(int userId,java.sql.Date expireDate) throws BaseException;
	
	public void deleteUser(int userId) throws BaseException;
	
	public void deleteEpUser(int userId) throws BaseException;
}
