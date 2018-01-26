package cn.edu.saif.ccm.domain.dto;

import java.util.List;

public class Auth {
	
	private Integer roleId;
	private List<Integer> permList;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public List<Integer> getPermList() {
		return permList;
	}
	public void setPermList(List<Integer> permList) {
		this.permList = permList;
	}
	
}
