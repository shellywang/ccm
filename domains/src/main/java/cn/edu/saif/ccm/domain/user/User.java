package cn.edu.saif.ccm.domain.user;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cn.edu.saif.ccm.domain.log.UserDLog;
import cn.edu.saif.ccm.domain.log.UserLog;
import cn.edu.saif.ccm.domain.security.Role;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="USERS")
public class User implements Serializable{

	private static final long serialVersionUID = 115341082476945898L;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable=false, unique=true)
	private String username;
	
	@JsonIgnore
	@Column(nullable=false)
	private String password;
	
	@Column(name="fullname")
	private String fullName;
	
	@Column(nullable=false, unique=true)
	private String email;
	
	private String institution;
	
	@Column(name="usertype")
	private String 	userType;
	
	@Column(name="applydate")
	private Date applyDate;
	
	@Column(nullable = false)
	private Integer approval;
	
	@Column(name="expiredate")
	private Date expireDate;
	
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinTable(name = "USER_ROLE", joinColumns = {
			@JoinColumn(name = "user_id", updatable = false)}, inverseJoinColumns = {
			@JoinColumn(name = "role_id", updatable = false)})
	private Set<Role> roles;
	
	@OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch = FetchType.LAZY) 
	private Set<UserLog> logs;
	
	@OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch = FetchType.LAZY) 
	private Set<UserDLog> dLogs;
	
	public User(){
	}
			
	public User(int id, String name, String email, String password) {
		this.id = id;
		this.username = name;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public Integer getApproval() {
		return approval;
	}

	public void setApproval(Integer approval) {
		this.approval = approval;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<UserLog> getLogs() {
		return logs;
	}

	public void setLogs(Set<UserLog> logs) {
		this.logs = logs;
	}

	public Set<UserDLog> getdLogs() {
		return dLogs;
	}

	public void setdLogs(Set<UserDLog> dLogs) {
		this.dLogs = dLogs;
	}

}
