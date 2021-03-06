package com.exam.Services.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.BALModel.UserBALModel;
import com.exam.Repo.RoleRepository;
import com.exam.Repo.UserRepository;
import com.exam.Repo.UserRoleRepository;
import com.exam.Services.UserService;
import com.exam.models.User;
import com.exam.models.UserRole;

import antlr.collections.List;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
private UserRepository userRepository;
	@Autowired
private RoleRepository roleRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Override
	public User createUser(User user, Set<UserRole> userRole) {
		var local=this.userRepository.findByUsername(user.getUsername());
		if(local!=null)
			System.out.print("User already exist");
		for(UserRole ur:userRole)
		{
			roleRepository.save(ur.getRole());
		}
		user.getUserRoles().addAll(userRole);
		local=this.userRepository.save(user);
		return null;
	}

	@Override
	public User getUser(String userName) {
		var local=this.userRepository.findByUsername(userName);
		return local;
	}

	@Override
	public void deleteUser(Long id) {
		this.userRepository.deleteById(id);
		
	}

	@Override
	public User findUserByUsernameAndPassword(String UserName, String Password) {
		// TODO Auto-generated method stub
		return this.userRepository.findUserByUsernameAndPassword(UserName, Password);
	}

	@Override
	public UserRole findUserWithRole(String username) {
//		return this.userRepository.findUserWithRole();
		var a=this.userRoleRepository.findAll();
		System.out.println("ppppppppppppppppppppp"+a);
		
var users= a.stream().filter(x->x.getUser().getUsername().equals(username)).map(y->y).findAny().orElse(null);
		
		//var users= a.stream().filter(x->x.getUserRoleId()==3).map(y->y).findAny().orElse(null);
		
//		a.stream().map(x->x.getUser().getUsername()).forEach(System.out::println);
		
		System.out.println("..................."+users);
		return users;
	}

}
