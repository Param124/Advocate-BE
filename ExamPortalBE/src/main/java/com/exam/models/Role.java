package com.exam.models;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private Long roleId;
private String roleName;
@OneToMany(cascade=CascadeType.ALL , fetch=FetchType.LAZY,mappedBy="role")
@JsonIgnoreProperties("role")
private Set<UserRole> userRole=new HashSet<>();
public Role(Long roleId, String roleName, Set<UserRole> userRole) {
	super();
	this.roleId = roleId;
	this.roleName = roleName;
	this.userRole = userRole;
}
public Role() {
	super();
	// TODO Auto-generated constructor stub
}

public Set<UserRole> getUserRole() {
	return userRole;
}
public void setUserRole(Set<UserRole> userRole) {
	this.userRole = userRole;
}
public Role(Long roleId, String roleName) {
	super();
	this.roleId = roleId;
	this.roleName = roleName;
}
public Long getRoleId() {
	return roleId;
}
public void setRoleId(Long roleId) {
	this.roleId = roleId;
}
public String getRoleName() {
	return roleName;
}
public void setRoleName(String roleName) {
	this.roleName = roleName;
}
@Override
public String toString() {
	return "Role [roleId=" + roleId + ", roleName=" + roleName + ",]";
}

}
