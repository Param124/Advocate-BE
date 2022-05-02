package com.exam.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity(name="user_role")
public class UserRole {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
public Long userRoleId;
	@ManyToOne(fetch=FetchType.EAGER)
	@JsonIgnoreProperties("userRoles")
private User user;
	@JsonIgnoreProperties("userRoles")
	@ManyToOne(fetch=FetchType.EAGER)
	private Role role;
	
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRole(Long userRoleId, User user, Role role) {
		super();
		this.userRoleId = userRoleId;
		this.user = user;
		this.role = role;
	}
	public Long getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", user=" + user + ", role=" + role + "]";
	}
	
}
