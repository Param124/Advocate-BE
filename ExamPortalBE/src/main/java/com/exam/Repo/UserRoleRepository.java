package com.exam.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.models.*;

public interface UserRoleRepository extends JpaRepository<UserRole,Long>{

}
