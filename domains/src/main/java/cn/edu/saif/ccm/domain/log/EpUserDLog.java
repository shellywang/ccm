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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.edu.saif.ccm.domain.user.EpUser;

@Entity
@Table(name="LOG_DOWNLOAD_EPUSER")
public class EpUserDLog implements Serializable {

	private static final long serialVersionUID = -6350992599278618770L;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne(cascade=CascadeType.REFRESH) 
	@JoinColumn(name="user_id")
	private EpUser user;
	
	@Column(nullable=false)
	private Date time;
	
	@Column(nullable=false)
	private String belong;
	
	@Column(name="recordcount", nullable=false)
	private Long recordCount;
	
	@Column(name="filesize")
	private Long fileSize;
	
	@Column(name="runtime", nullable=false)
	private Long runTime;
	
	private boolean status;

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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	public Long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Long recordCount) {
		this.recordCount = recordCount;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public Long getRunTime() {
		return runTime;
	}

	public void setRunTime(Long runTime) {
		this.runTime = runTime;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
