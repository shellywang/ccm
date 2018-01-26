package cn.edu.saif.ccm.domain.security;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;

import cn.edu.saif.ccm.domain.user.User;

@Entity
@Table(name="ROLE")
public class Role implements Serializable{

	private static final long serialVersionUID = -4446659037960529040L;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable=false, unique=true)
	private String name;
	
	@Column(nullable=false)
	private Date creationTime;
	
	@Column(name="isdefault")
	private boolean defaultRole;
	
	private String description;
	
	@ManyToMany(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
	@JoinTable(name = "ROLE_PERMISSION", joinColumns = {
			@JoinColumn(name = "role_id", updatable = false)}, inverseJoinColumns = {
			@JoinColumn(name = "permission_id", updatable = false)})
	private Set<Permission> permissions;
	
	@ManyToMany(cascade = CascadeType.REFRESH,fetch=FetchType.LAZY)
	@JoinTable(name="USER_ROLE", joinColumns = {
			@JoinColumn(name="role_id", updatable=false) }, inverseJoinColumns = {
			@JoinColumn(name="user_id", updatable=false) })
	private Set<User> users;
	
	public Role() {
	}
	
	public Role(Integer id) {
		this.id = id;
	}
	
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

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public boolean isDefaultRole() {
		return defaultRole;
	}

	public void setDefaultRole(boolean defaultRole) {
		this.defaultRole = defaultRole;
	}
	
}
