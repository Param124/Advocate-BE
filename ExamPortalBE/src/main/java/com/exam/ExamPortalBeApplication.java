package com.exam;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.Services.UserService;
import com.exam.models.Role;
import com.exam.models.User;
import com.exam.models.UserRole;

@SpringBootApplication
public class ExamPortalBeApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(ExamPortalBeApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}

}
