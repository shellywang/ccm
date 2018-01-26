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

import cn.edu.saif.ccm.domain.log.EpUserDLog;
import cn.edu.saif.ccm.domain.log.EpUserLog;
import cn.edu.saif.ccm.domain.security.Role;

@Entity
@Table(name="EPUSERS")
public class EpUser implements Serializable{

	private static final long serialVersionUID = 3179854077232885366L;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable=false)
	private String name;//Enterprise name
	
	@Column(name="fullname",nullable=false)
	private String fullName;//Enterprise name
	
	@Column(name="ipstart",nullable=false)
	private String ipStart;
	
	@Column(name="ipend",nullable=false)
	private String ipEnd;
	
	@Column(name="expiredate")
	private Date expireDate;
	
	private String description;

	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinTable(name = "EPUSER_ROLE", joinColumns = {
			@JoinColumn(name = "user_id", updatable = false)}, inverseJoinColumns = {
			@JoinColumn(name = "role_id", updatable = false)})
	private Set<Role> roles;
	
	@OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch = FetchType.LAZY) 
	private Set<EpUserLog> logs;
	
	@OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch = FetchType.LAZY) 
	private Set<EpUserDLog> dLogs;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIpStart() {
		return ipStart;
	}

	public void setIpStart(String ipStart) {
		this.ipStart = ipStart;
	}

	public String getIpEnd() {
		return ipEnd;
	}

	public void setIpEnd(String ipEnd) {
		this.ipEnd = ipEnd;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<EpUserLog> getLogs() {
		return logs;
	}

	public void setLogs(Set<EpUserLog> logs) {
		this.logs = logs;
	}

	public Set<EpUserDLog> getdLogs() {
		return dLogs;
	}

	public void setdLogs(Set<EpUserDLog> dLogs) {
		this.dLogs = dLogs;
	}
	
}
