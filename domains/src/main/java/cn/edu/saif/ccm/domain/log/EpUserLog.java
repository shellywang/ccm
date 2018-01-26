package cn.edu.saif.ccm.domain.log;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import cn.edu.saif.ccm.domain.user.EpUser;

@Entity
@Table(name="LOG_EPUSER")
public class EpUserLog implements Serializable{

	private static final long serialVersionUID = -3909337288556184646L;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade=CascadeType.REFRESH) 
	@JoinColumn(name="user_id") 
	private EpUser user;
	
	@Column(name="logincount", nullable=false)
	private int loginCount;
	
	@Column(name="lastlogintime", nullable=false)
	private Date lastLoginTime;
	
	@Column(name="lastloginip", nullable=false)
	private String lastLoginIp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EpUser getUser() {
		return user;
	}

	public void setUser(EpUser user) {
		this.user = user;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
}
