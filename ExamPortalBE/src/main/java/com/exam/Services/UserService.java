package com.exam.Services;

import java.util.Set;

import com.exam.BALModel.UserBALModel;
import com.exam.models.User;
import com.exam.models.UserRole;

public interface UserService {
//creating user
	
	public User createUser(User user,Set<UserRole> userRole);
	
	public User getUser(String userName);
	public void deleteUser(Long id);
	public User findUserByUsernameAndPassword(String UserName,String Password);
	
	
	public UserRole findUserWithRole(String username);
}
