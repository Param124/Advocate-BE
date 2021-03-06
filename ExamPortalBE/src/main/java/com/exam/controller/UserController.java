package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.BALModel.UserBALModel;
import com.exam.Services.UserService;
import com.exam.models.Role;
import com.exam.models.User;
import com.exam.models.UserRole;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	@CrossOrigin("*")
	public User createUser(@RequestBody User user) 
	{

		Set<UserRole> roles=new HashSet<>();
		Role role1=new Role();
		role1.setRoleName("Normal");
		UserRole userRole=new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);
		roles.add(userRole);
		
		return this.userService.createUser(user,roles);
	}
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String userName)
	{
	return	this.userService.getUser(userName);
	}
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long id)
	{
		this.userService.deleteUser(id);
	}
	@GetMapping("validate-login")
	public User Validate(@RequestParam String username,@RequestParam String password)
	{
		return this.userService.findUserByUsernameAndPassword(username, password);
	}
	
	@GetMapping("GetCurrentUser")
//	public UserBALModel UserWithRole(@RequestParam String username)
	public UserBALModel UserWithRole(@RequestHeader("Authorization") String username)
	{
		var roleData =this.userService.findUserWithRole(username);
		if(roleData!=null)
		{
			UserBALModel model=new UserBALModel(roleData.getUser().getEmail(),roleData.getUser().getFirstName(),roleData.getRole().getRoleName(),roleData.getUser().getUsername());
			return model;
		}
		else
		{
			return null;
		}	
	}
}
